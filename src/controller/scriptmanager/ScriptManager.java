package controller.scriptmanager;

import controller.command.Command;
import controller.command.CommandFactory;
import controller.parser.Parser;
import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a ScriptManager.
 */
public class ScriptManager {
  private Parser parser;
  private MultiLayerImageImpl multiLayerImage;

  /**
   * Constructs a ScriptManager.
   * @param filepath the filepath used to obtain the script
   */
  public ScriptManager(String filepath) {
    this(filepath, new MultiLayerImageImpl());
  }

  /**
   * Constructs a script manager.
   * @param filepath the filepath that contains the script
   * @param multiLayerImage the layer image setup
   */
  public ScriptManager(String filepath, MultiLayerImageImpl multiLayerImage) {
    this.parser = new Parser(filepath);
    this.multiLayerImage = multiLayerImage;
  }

  /**
   * Checks if all of the command lines have been successfully executed.
   * @return the boolean value of the successful use of the given script
   */
  public boolean run() {
    String[] tokens = null;
    Command command = null;
    boolean success = true;
    tokens = parser.getNextCommandLine();
    do {
      if (tokens != null) {
        System.out.println(tokens[0]);
        command = CommandFactory.instantiate(tokens[0], tokens);
        if (command != null) {
          if (command.isValid()) {
            success = command.execute(this.multiLayerImage);
            if (success) {
              System.out.println("Command " + command.getKeyword() + " is successful.");
            }
            else {
              System.out.println("Command " + command.getKeyword() + " failed.");
              break;
            }
          }
          else {
            success = false;
            System.out.println("Command " + command.getKeyword() + " is not valid.");
            break;
          }
        }
      }
      tokens = parser.getNextCommandLine();
    }
    while (tokens != null);
    parser.close();
    return success;
  }
}
