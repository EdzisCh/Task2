package by.chebotar.service.reader;

import by.chebotar.exception.InvalidPathException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileReader {

  private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

  public List<String> getLines(Path path) throws InvalidPathException {
    List<String> lists;
    try{
      lists = Files.readAllLines(path);
      LOGGER.info("All lines read successfully");
      return lists;
    } catch (IOException e){
      LOGGER.error("Exception in FileReader " + e.getMessage());
      throw new InvalidPathException("Path" + path + "is not valid",e);
    }
  }
}
