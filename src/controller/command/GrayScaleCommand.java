package controller.command;

import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a grayscale command.
 */
public class GrayScaleCommand extends Command {

  /**
   * Constructs a command that uses the grayscale method.
   * @param tokens the script used to identify when
   *               the user wants to add a grayscale
   *               filter to an image
   */
  public GrayScaleCommand(String[] tokens) {
    super("gray", tokens);
  }

  @Override
  public boolean isValid() {
    String[] tokens = getTokens();
    boolean valid = true;
    int value = 0;
    if (tokens.length != 1) {
      valid = false;
    }
    else if (tokens[0].compareTo("gray") != 0) {
      valid = false;
    }
    return valid;
  }

  @Override
  public boolean execute(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    success = multiLayerImage.grayscale();
    return success;
  }
}
