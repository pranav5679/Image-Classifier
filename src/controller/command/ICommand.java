package controller.command;

import model.multilayerimage.MultiLayerImageImpl;

/**
 * The interface of a Command.
 */
public interface ICommand {

  /**
   * Extracts the keyword associated with the Command.
   * @return the string with the keyword
   */
  String getKeyword();

  /**
   * Extracts the tokens associated with the Command.
   * @return the string array that contains each token in the Command
   */
  String[] getTokens();

  /**
   * Extracts a token associated with the Command.
   * @param index the position value of a word in the command line
   * @return the word in a command line
   */
  String getToken(int index);

  /**
   * Checks if the Command can be used appropriately.
   * @return the boolean value of the validity of the command's use
   */
  boolean isValid();

  /**
   * Checks if the Command is implemented successfully on an image.
   * @param multiLayerImage an image with multiple layers that the
   *                        Command is going to work with
   * @return the boolean value of the command's success on the image
   */
  boolean execute(MultiLayerImageImpl multiLayerImage);
}
