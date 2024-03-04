package controller.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The representation of a Parser.
 */
public class Parser {

  private FileInputStream fstream = null;
  private BufferedReader br = null;

  /**
   * Constructs a parser.
   * @param filepath the filepath used to obtain a piece of script
   */
  public Parser(String filepath) {
    try {
      fstream = new FileInputStream(filepath);
      br = new BufferedReader(new InputStreamReader(fstream));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets a formatted command line that can be
   * read by the ScriptManager.
   * @return an array of strings representing each line of script
   */
  public String[] getNextCommandLine() {
    String commandLine = null;
    String[] commandTokens = null;
    int index = -1;
    if (br != null) {
      try {
        while ((commandLine = br.readLine()) != null) {
          commandLine = commandLine.trim();
          if (commandLine.length() == 0) {
            continue;
          } else if (commandLine.charAt(0) == '#') {
            continue;
          } else {
            index = commandLine.indexOf('#');
            if (index != -1) {
              commandLine = commandLine.substring(0, index);
              commandLine = commandLine.trim();
            }
            commandTokens = commandLine.split("\\s+");
            break;
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return commandTokens;
  }

  /**
   * Closes the file that is being read.
   */
  public void close() {
    try {
      fstream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
