package controller.command;

/**
 * The representation of a factory that can call to each type of command.
 */
public class CommandFactory {

  /**
   * Calls to one type of command.
   *
   * @param commandLine the entire command line
   * @return the command that is going to look through the script
   */
  public static Command instantiate(String commandLine) {
    String[] commandTokens;
    commandLine = commandLine.trim();
    commandTokens = commandLine.split("\\s+");

    return CommandFactory.instantiate(commandTokens[0], commandTokens);
  }

  /**
   * Calls to one type of command.
   *
   * @param keyword the word associated with any of the commands
   * @param tokens  the script that is going to be passed to any one of the commands
   * @return the command that is going to look through the script
   */
  public static Command instantiate(String keyword, String[] tokens) {
    Command command = null;
    if (keyword.compareTo("create") == 0) {
      command = new CreateCommand(tokens);
    } else if (keyword.compareTo("delete") == 0) {
      command = new DeleteCommand(tokens);
    } else if (keyword.compareTo("current") == 0) {
      command = new CurrentCommand(tokens);
    } else if (keyword.compareTo("load") == 0) {
      command = new LoadCommand(tokens);
    } else if (keyword.compareTo("save") == 0) {
      command = new SaveCommand(tokens);
    } else if (keyword.compareTo("blur") == 0) {
      command = new BlurCommand(tokens);
    } else if (keyword.compareTo("sharpen") == 0) {
      command = new SharpenCommand(tokens);
    } else if (keyword.compareTo("sepia") == 0) {
      command = new SepiaCommand(tokens);
    } else if (keyword.compareTo("gray") == 0) {
      command = new GrayScaleCommand(tokens);
    } else if (keyword.compareTo("invisible") == 0) {
      command = new InvisibleCommand(tokens);
    }
    return command;
  }
}
