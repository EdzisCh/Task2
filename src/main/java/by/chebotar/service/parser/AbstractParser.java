package by.chebotar.service.parser;

import by.chebotar.interfaces.TextParser;
import by.chebotar.interfaces.TextStructure;

public abstract class AbstractParser implements TextParser<TextStructure> {

  private TextParser next;

  public abstract TextStructure parse(String token);

  public TextParser<TextStructure> linkWith(TextParser next) {
    return null;
  }

  protected TextStructure nextParse(String token){
    if(next != null){
      return (TextStructure) next.parse(token);
    } else {
      return null;
    }
  }
}
