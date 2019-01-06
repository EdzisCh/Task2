package by.chebotar.service.parser;

import by.chebotar.bean.Sentence;
import by.chebotar.interfaces.TextStructure;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewSentenceParser extends AbstractParser {

  private static final Pattern PATTERN = Pattern.compile("[A-Z](\\w*)");
  private Matcher matcher;

  @Override
  public TextStructure parse(String token) {
    matcher = PATTERN.matcher(token);
    if (matcher.matches()) {
      Sentence newSentence = new Sentence();
      newSentence.setChild(nextParse(token));
      return newSentence;
    } else {
      return nextParse(token);
    }
  }
}
