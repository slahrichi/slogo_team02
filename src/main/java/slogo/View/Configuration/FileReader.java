package slogo.View.Configuration;

import java.io.File;

public class FileReader {

  private File myFile;
  private String fileContents;

  public FileReader(String file){

    myFile = new File(file);
    parseFile();

  }

  private void parseFile(){

    fileContents = myFile.toString();
    System.out.println(fileContents);

  }

  public String getString(){
    return fileContents;
  }

}
