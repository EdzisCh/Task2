package by.chebotar.service.parser;

import by.chebotar.bean.Token;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewParagraphParserTest {

  private static NewParagraphParser newParagraphParser = new NewParagraphParser();

  @Test
  public void shouldReturnNewTokenWithSpaceAsField(){
    Assert.assertEquals(newParagraphParser.parse("").getText(), " ");
  }

  @Test
  public void shouldPassTokenToNextParserInChain(){
    newParagraphParser.linkWith(new TokenWithSymbolParser());
    Assert.assertEquals(newParagraphParser.parse("word,").getClass(), Token.class);
  }
}
