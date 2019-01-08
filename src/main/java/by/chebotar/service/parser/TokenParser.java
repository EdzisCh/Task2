package by.chebotar.service.parser;

import by.chebotar.bean.Token;
import by.chebotar.interfaces.TextStructure;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenParser extends AbstractParser {

  private static final Pattern PATTERN = Pattern.compile("(\\w*)");
  private static final Pattern PATTERN_WITH_BRACKETS = Pattern.compile("\\((\\w*)\\)");
  private Matcher firstMatcher;
  private Matcher secondMatcher;

  public TextStructure parse(String token) {
    firstMatcher = PATTERN.matcher(token);
    secondMatcher = PATTERN_WITH_BRACKETS.matcher(token);
    if (firstMatcher.matches() || secondMatcher.matches()) {
      return new Token(token);
    } else {
      return nextParse(token);
    }
  }
}
