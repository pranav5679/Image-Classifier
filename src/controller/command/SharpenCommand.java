package controller.command;

import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a sharpen command.
 */
public class SharpenCommand extends Command {

  /**
   * Constructs a command that uses the sharpen method.
   * @param tokens the script used to identify when
   *               the user wants to sharpen an image
   */
  public SharpenCommand(String[] tokens) {
    super("sharpen", tokens);
  }

  @Override
  public boolean isValid() {
    String[] tokens = getTokens();
    boolean valid = true;
    int value = 0;
    if (tokens.length != 1) {
      valid = false;
    }
    else if (tokens[0].compareTo("sharpen") != 0) {
      valid = false;
    }
    return valid;
  }

  @Override
  public boolean execute(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    success = multiLayerImage.sharpen();
    return success;
  }
}
