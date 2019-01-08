package by.chebotar.service;

import by.chebotar.bean.Sentence;
import by.chebotar.bean.Text;
import by.chebotar.exception.InvalidPathException;
import by.chebotar.interfaces.TextStructure;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextServiceTest {

  private static TextService textService;

  @BeforeClass
  public static void init() throws InvalidPathException {
    textService = new TextService();
  }

  @Test
  public void shouldGetCompositeOfTokens(){
    TextStructure textStructure = textService.getText();
    Assert.assertEquals(((Text) textStructure).getLastChild().getClass(), Sentence.class);
  }
  
}
