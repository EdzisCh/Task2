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
    TextParser<TextStructure> textParser = new NewParagraphParser()
                                          .linkWith(new NewSentenceParser())
                                          .linkWith(new TokenParser())
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
    if(textPiece instanceof Sentence){
      text.setChild(textPiece);
    } else {
      ((Sentence) text.getLastChild()).setChild(textPiece);
    }
  }

  public String getText(){
    init();
    return text.getText();
  }
}
