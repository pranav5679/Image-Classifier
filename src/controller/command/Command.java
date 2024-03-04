package controller.command;

import model.multilayerimage.MultiLayerImageImpl;

/**
 * The representation of a Command.
 */
public class Command implements ICommand {
  private String[] tokens;
  private String keyword;

  /**
   * Constructs a command.
   * @param keyword the word associated with a command
   * @param tokens the script comprised of words used to identify
   *               what the user wants to do with an image
   */
  public Command(String keyword, String[] tokens) {
    this.tokens = tokens;
    this.keyword = keyword;
  }

  @Override
  public String getKeyword() {
    return keyword;
  }

  @Override
  public String[] getTokens() {
    return tokens;
  }

  @Override
  public String getToken(int index) {
    String token = null;
    if (tokens.length > index) {
      token = tokens[index];
    }
    return token;
  }

  @Override
  public boolean isValid() {
    return false;
  }

  @Override
  public boolean execute(MultiLayerImageImpl multiLayerImage) {
    return false;
  }
}
