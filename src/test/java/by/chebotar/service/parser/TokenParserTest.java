package by.chebotar.service.parser;

import by.chebotar.bean.Token;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenParserTest {

  private static TokenParser tokenParser = new TokenParser();

  @Test
  public void shouldReturnNewToken(){
    Assert.assertEquals(tokenParser.parse("word").getText(),"word");
  }

  @Test
  public void shouldPassTokenToNextParserInChain(){
    tokenParser.linkWith(new TokenWithSymbolParser());
    Assert.assertEquals(tokenParser.parse("word,").getClass(), Token.class);
  }
}
