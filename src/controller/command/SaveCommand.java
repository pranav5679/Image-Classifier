package controller.command;

import java.io.File;
import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a save command.
 */
public class SaveCommand extends Command {

  /**
   * Constructs a command that uses the saveImage method.
   * @param tokens the script used to identify when
   *               the user wants to save an image
   */
  public SaveCommand(String[] tokens) {
    super("save", tokens);
  }

  @Override
  public boolean isValid() {
    String[] tokens = getTokens();
    boolean valid = true;
    File file = null;
    if (tokens.length != 2) {
      valid = false;
    }
    else if (tokens[0].compareTo("save") != 0) {
      valid = false;
    }
    else {
      try {
        file = new File(tokens[1]);
        if (file != null && file.exists() && !file.isDirectory()) {
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
      success = multiLayerImage.saveImage(tokens[1]);
    }
    catch (NumberFormatException e) {
      e.printStackTrace();
    }
    return success;
  }
}
