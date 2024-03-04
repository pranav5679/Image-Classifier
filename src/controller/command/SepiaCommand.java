package controller.command;

import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a sepia command.
 */
public class SepiaCommand extends Command {

  /**
   * Constructs a command that uses the sepia method.
   * @param tokens the script used to identify when
   *               the user wants to apply a sepia
   *               filter to an image
   */
  public SepiaCommand(String[] tokens) {
    super("sepia", tokens);
  }

  @Override
  public boolean isValid() {
    String[] tokens = getTokens();
    boolean valid = true;
    int value = 0;
    if (tokens.length != 1) {
      valid = false;
    }
    else if (tokens[0].compareTo("sepia") != 0) {
      valid = false;
    }
    return valid;
  }

  @Override
  public boolean execute(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    success = multiLayerImage.sepia();
    return success;
  }
}
