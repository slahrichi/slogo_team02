package slogo.View.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SlogoReader {

  private String fileContents;
  private Path fileName;

  public SlogoReader(String file) throws IOException {

    fileName = Path.of(file);
    parseFile();

  }

  private void parseFile() throws IOException {

    fileContents = Files.readString(fileName);
    System.out.println(fileContents);
    ;

  }

  public String getString(){
    return fileContents;
  }

}
