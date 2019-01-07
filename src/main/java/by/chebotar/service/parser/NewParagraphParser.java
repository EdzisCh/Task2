package by.chebotar.service.parser;

import by.chebotar.bean.Token;
import by.chebotar.interfaces.TextStructure;

public class NewParagraphParser extends AbstractParser {

  @Override
  public TextStructure parse(String token) {
    if(token == null || token.equals("") || token.equals("\t")){
      return new Token(" ");
    } else {
      return nextParse(token);
    }
  }
}
