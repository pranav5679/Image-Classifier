package controller.command;

import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a create command.
 */
public class CreateCommand extends Command {

  /**
   * Constructs a command that uses the addLayer method.
   * @param tokens the script used to identify when
   *               the user wants to create a layer
   */
  public CreateCommand(String[] tokens) {
    super("create", tokens);
  }

  @Override
  public boolean isValid() {
    String[] tokens = getTokens();
    boolean valid = true;
    int value = 0;
    if (tokens.length != 3) {
      valid = false;
    }
    else if (tokens[0].compareTo("create") != 0) {
      valid = false;
    }
    else if (tokens[1].compareTo("layer") != 0) {
      valid = false;
    }
    else {
      try {
        value = Integer.parseInt(tokens[2]);
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
      id = Integer.parseInt(tokens[2]);
      success = multiLayerImage.addLayer(id);
    }
    catch (NumberFormatException e) {
      e.printStackTrace();
    }
    return success;
  }
}
