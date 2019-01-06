package by.chebotar.service.parser;

import by.chebotar.bean.Token;
import by.chebotar.interfaces.TextStructure;

/**
 * This parser should be in the end of the chain
 */
public class BitOperationsParser extends AbstractParser{

  public TextStructure parse(String token) {
    return new Token("dick");
  }
}
