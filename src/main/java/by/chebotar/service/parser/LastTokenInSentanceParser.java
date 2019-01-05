package by.chebotar.service.parser;

import by.chebotar.interfaces.TextStructure;
import java.util.regex.Pattern;

public class LastTokenInSentanceParser extends AbstractParser {

  private static final Pattern PATTERN = Pattern.compile("(\\w*)(.|!|\\?)");

  @Override
  public TextStructure parse(String token) {
    return null;
  }
}
