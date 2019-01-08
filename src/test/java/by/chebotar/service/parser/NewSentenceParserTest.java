package by.chebotar.service.parser;

import by.chebotar.bean.Sentence;
import by.chebotar.bean.Token;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewSentenceParserTest {

  private static NewSentenceParser newSentenceParser = new NewSentenceParser();

  @Test
  public void shouldPassTokenToNextParserInChain(){
    newSentenceParser.linkWith(new TokenWithSymbolParser());
    Assert.assertEquals(newSentenceParser.parse("word,").getClass(), Token.class);
  }

  @Test
  public void shouldReturnSentenceClass(){
    Assert.assertEquals(newSentenceParser.parse("asd.").getClass(), Sentence.class);
  }
}
