package controller.command;

import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a blur command.
 */
public class BlurCommand extends Command {

  /**
   * Constructs a command for the blur method.
   * @param tokens the script used to identify when
   *               the user wants to blur an image
   */
  public BlurCommand(String[] tokens) {
    super("blur", tokens);
  }

  @Override
  public boolean isValid() {
    String[] tokens = getTokens();
    boolean valid = true;
    int value = 0;
    if (tokens.length != 1) {
      valid = false;
    }
    else if (tokens[0].compareTo("blur") != 0) {
      valid = false;
    }
    return valid;
  }

  @Override
  public boolean execute(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    success = multiLayerImage.blur();
    return success;
  }
}
