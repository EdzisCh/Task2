package by.chebotar.service.parser;

import by.chebotar.bean.Token;
import by.chebotar.interfaces.TextStructure;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenParser extends AbstractParser {

  private static final Pattern PATTERN = Pattern.compile("(\\w*)");
  private Matcher matcher;

  public TextStructure parse(String token) {
    matcher = PATTERN.matcher(token);
    if (matcher.matches()) {
      return new Token(token);
    } else {
      return nextParse(token);
    }
  }
}
