package view;

import controller.command.CommandResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents a view object for a text.
 */
public class TextView extends View {

  /**
   * Starts a view.
   *
   * @return Success or failure
   */
  public boolean start(Object param) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    boolean done = false;
    String commandLine = "";
    int index = -1;
    while (!done) {
      System.out.print(">>");
      try {
        commandLine = reader.readLine();
      }
      catch (IOException e) {
        commandLine = "";
      }
      if (commandLine.compareTo("Quit") == 0) {
        done = true;
      }
      else {
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
    }
    return done;
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
