package view;

import controller.command.CommandResponse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents a view object for a script.
 */
public class ScriptView extends View {

  /**
   * Starts the view.
   *
   * @return Success or failure
   */
  public boolean start(Object param) {
    String filepath = (String) param;
    boolean success = true;
    FileInputStream fstream = null;
    BufferedReader br = null;
    String commandLine = null;
    int index = -1;
    try {
      fstream = new FileInputStream(filepath);
      br = new BufferedReader(new InputStreamReader(fstream));
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
          this.controller.processCommand(commandLine);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      success = false;
    }
    return success;
  }

  @Override
  public void renderMessage(String message) {
    System.out.println(message);
  }

  @Override
  public void renderResponse(CommandResponse responseObject) {
    System.out.println((String) responseObject.getResponse());
  }

}
