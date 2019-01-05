package by.chebotar.service.parser;

import by.chebotar.interfaces.TextStructure;
import java.util.regex.Pattern;

public class TokenParser extends AbstractParser {

  private static final Pattern PATTERN = Pattern.compile("(\\w*)");

  public TextStructure parse(String token) {
    return null;
  }
}
