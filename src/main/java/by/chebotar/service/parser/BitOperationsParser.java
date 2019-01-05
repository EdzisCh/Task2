package by.chebotar.service.parser;

import by.chebotar.interfaces.TextStructure;
import java.util.regex.Pattern;

public class BitOperationsParser extends AbstractParser{

  private final static Pattern PATTERN =Pattern.compile("[^a-b]");
  public TextStructure parse(String token) {
    return null;
  }
}
