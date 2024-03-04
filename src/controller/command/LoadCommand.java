package controller.command;

import java.io.File;
import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a load command.
 */
public class LoadCommand extends Command {

  /**
   * Constructs a command that uses the loadImage method.
   * @param tokens the script used to identify when
   *               the user wants to load an image to a layer
   */
  public LoadCommand(String[] tokens) {
    super("load", tokens);
  }

  @Override
  public boolean isValid() {
    String[] tokens = getTokens();
    boolean valid = true;
    File file = null;
    if (tokens.length != 2) {
      valid = false;
    }
    else if (tokens[0].compareTo("load") != 0) {
      valid = false;
    }
    else {
      try {
        file = new File(tokens[1]);
        if (file != null) {
          valid = file.isFile();
        }
        else {
          valid = false;
        }
      }
      catch (Exception e) {
        valid = false;
      }
    }
    return valid;
  }

  @Override
  public boolean execute(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    String[] tokens = getTokens();
    try {
      success = multiLayerImage.loadImage(tokens[1]);
    }
    catch (NumberFormatException e) {
      e.printStackTrace();
    }
    return success;
  }
}
