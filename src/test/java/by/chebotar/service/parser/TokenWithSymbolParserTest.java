package by.chebotar.service.parser;

import by.chebotar.bean.Token;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenWithSymbolParserTest {

  private static TokenWithSymbolParser tokenWithSymbolParser = new TokenWithSymbolParser();
  @Test
  public void shouldReturnNewToken(){
    Assert.assertEquals(tokenWithSymbolParser.parse("word,").getText(),"word,");
  }

  @Test
  public void shouldPassTokenToNextParserInChain(){
    tokenWithSymbolParser.linkWith(new NewSentenceParser());
    Assert.assertEquals(tokenWithSymbolParser.parse("word,").getClass(), Token.class);
  }
}
