package by.chebotar.service;

import by.chebotar.bean.Sentence;
import by.chebotar.bean.Text;
import by.chebotar.exception.InvalidPathException;
import by.chebotar.interfaces.TextParser;
import by.chebotar.interfaces.TextStructure;
import by.chebotar.service.parser.BitOperationsParser;
import by.chebotar.service.parser.NewParagraphParser;
import by.chebotar.service.parser.NewSentenceParser;
import by.chebotar.service.parser.TokenParser;
import by.chebotar.service.parser.TokenWithSymbolParser;
import by.chebotar.service.reader.FileReader;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TextService {

  private List<String> unprocessedLines;
  private FileReader fileReader;
  private Text text = new Text();

  public TextService() throws InvalidPathException {
    this(Paths.get("src"+ File.separator + "main" + File.separator + "resources" + File.separator + "text.txt"));
  }

  public TextService(Path path) throws InvalidPathException {
    fileReader = new FileReader();
    unprocessedLines = fileReader.getLines(path);
  }

  private void init(){
    TextParser<TextStructure> textParser = new NewParagraphParser();
    textParser.linkWith(new NewSentenceParser()).linkWith(new TokenParser())
                                          .linkWith(new TokenWithSymbolParser())
                                          .linkWith(new BitOperationsParser());
    text.setChild(new Sentence());
    for (String line : unprocessedLines) {
      String[] temp = line.split(" ");
      for (String word : temp) {
        createTextComposite(textParser.parse(word));
      }
    }
  }

  private void createTextComposite(TextStructure textPiece){
    char lastChar = textPiece.getText().charAt(textPiece.getText().length()-1);
    if(textPiece instanceof Sentence) {
      text.setChild(textPiece);
    }else if ( lastChar == '.' || lastChar == '!' || lastChar == '?'){
      ((Sentence) text.getLastChild()).setChild(textPiece);
      text.setChild(new Sentence());
    } else {
      ((Sentence) text.getLastChild()).setChild(textPiece);
    }
  }

  public Text getText(){
    init();
    return text;
  }

  public List<String> getSortedTextInEverySentence(){
    if (text.getChildren().size() == 0) {
      init();
    }
    return sortByLength(prepareToSort());
  }

  private List<String> sortByLength(List<String> list){
    Collections.sort(list, Comparator.reverseOrder());
    return list;
  }

  private List<String> prepareToSort(){
    List<Sentence> listOfSentences = new ArrayList<>();
    for (TextStructure sentence : text.getChildren()) {
      listOfSentences.add((Sentence) sentence);
    }
    List<String> listOfTokens = new ArrayList<>();
    for (int i = 0; i < listOfSentences.size(); i++) {
      for (int j = 0; j < listOfSentences.get(i).getChildren().size(); j++) {
        listOfTokens.add(listOfSentences.get(i).getChild(j).getText());
      }
    }
    return listOfTokens;
  }
}
