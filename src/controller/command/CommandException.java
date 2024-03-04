package controller.command;

/**
 * Represents a exception class for a command.
 */
public class CommandException extends RuntimeException {

  public CommandException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }
}