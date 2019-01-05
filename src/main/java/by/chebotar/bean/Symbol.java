package by.chebotar.bean;

public class Symbol extends Token {

  private String symbol;

  public Symbol(String symbol) {
    this.symbol = symbol;
  }

  public String getText(){
    return this.symbol;
  }
}
