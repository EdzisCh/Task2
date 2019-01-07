package by.chebotar.bean;

import by.chebotar.interfaces.TextStructure;

public class Token implements TextStructure, Comparable<String>{

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

  @Override
  public int compareTo(String o) {
    return token.length() - o.length();
  }
}
