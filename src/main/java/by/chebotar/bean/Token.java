package by.chebotar.bean;

import by.chebotar.interfaces.TextStructure;

public class Token implements TextStructure{

  private String token;

  public Token(){
    this(" ");               ////////////
  }

  public Token(String token){
    this.token = token;
  }

  public String getText() {
    return this.token;
  }
}
