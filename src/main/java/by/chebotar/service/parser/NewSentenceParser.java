package by.chebotar.service.parser;

import by.chebotar.bean.Sentence;
import by.chebotar.bean.Token;
import by.chebotar.interfaces.TextStructure;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewSentenceParser extends AbstractParser {

  private static final Pattern PATTERN = Pattern.compile("(\\w*)[.|!|\\?]");
  private Matcher matcher;
  private Sentence sentence;

  @Override
  public TextStructure parse(String token) {
    matcher = PATTERN.matcher(token);
    if (matcher.matches()) {
      sentence = new Sentence();
      sentence.setChild(new Token(token));
      return sentence;
    } else {
      return nextParse(token);
    }
  }
}
