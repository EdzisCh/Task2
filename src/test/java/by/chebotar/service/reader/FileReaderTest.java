package by.chebotar.service.reader;

import by.chebotar.exception.InvalidPathException;
import java.io.File;
import java.nio.file.Paths;
import org.testng.annotations.Test;

public class FileReaderTest {

  private static FileReader fileReader = new FileReader();

  @Test(expectedExceptions = InvalidPathException.class)
  public void notValidPathException() throws InvalidPathException {
    fileReader.getLines(Paths.get("not"+ File.separator+"valid"+File.separator+"path"));
  }
}
