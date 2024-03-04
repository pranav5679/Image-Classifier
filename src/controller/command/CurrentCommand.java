package controller.command;

import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a create command.
 */
public class CurrentCommand extends Command {

  /**
   * Constructs a command that uses the setCurrent method.
   * @param tokens the script used to identify when
   *               the user wants to go work on a specific layer
   */
  public CurrentCommand(String[] tokens) {
    super("current", tokens);
  }

  @Override
  public boolean isValid() {
    String[] tokens = getTokens();
    boolean valid = true;
    int value = 0;
    if (tokens.length != 2) {
      valid = false;
    }
    else if (tokens[0].compareTo("current") != 0) {
      valid = false;
    }
    else {
      try {
        value = Integer.parseInt(tokens[1]);
      }
      catch (NumberFormatException e) {
        valid = false;
      }
    }
    return valid;
  }

  @Override
  public boolean execute(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    String[] tokens = getTokens();
    int id = -1;
    try {
      id = Integer.parseInt(tokens[1]);
      success = multiLayerImage.setCurrent(id);
    }
    catch (NumberFormatException e) {
      e.printStackTrace();
    }
    return success;
  }

}
