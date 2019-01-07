package by.chebotar.service.parser;

import by.chebotar.interfaces.TextParser;
import by.chebotar.interfaces.TextStructure;

public abstract class AbstractParser implements TextParser<TextStructure> {

  private TextParser<TextStructure> next;

  public abstract TextStructure parse(String token);

  public TextParser<TextStructure> linkWith(TextParser<TextStructure> next) {
    this.next = next;
    return next;
  }

  protected TextStructure nextParse(String token){
    if(next != null){
      return next.parse(token);
    } else {
      return null;
    }
  }
}
