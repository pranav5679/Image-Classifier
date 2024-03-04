package controller.command;

/**
 * Represents a response class for a command.
 */
public class CommandResponse {
  private Object response = null;
  private boolean success = false;
  private String errorMessage = null;
  private String commandLine = null;

  /**
   * Constructs a default response to a command.
   */
  public CommandResponse(String commandLine) {
    this.response = null;
    this.success = false;
    this.errorMessage = null;
    this.commandLine = commandLine;
  }

  /**
   * Gets the response from a class object.
   * @return the object associated with the response
   */
  public Object getResponse() {
    return response;
  }

  /**
   * Set the current response to a given response.
   * @param response the response that is replacing the current one
   */
  public void setResponse(Object response) {
    this.response = response;
  }

  /**
   * Gets the success value of the class object.
   * @return the boolean value of the success
   */
  public boolean getSuccess() {
    return success;
  }

  /**
   * Set the current success value to a given value.
   * @param success the success value that is replacing the current one
   */
  public void setSuccess(boolean success) {
    this.success = success;
  }

  /**
   * Gets the error message of the class object.
   * @return the error message associated with the response
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * Set the current error message to a given message.
   * @param errorMessage the error message that is replacing the current one
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getCommandLine() {
    return this.commandLine;
  }
}
