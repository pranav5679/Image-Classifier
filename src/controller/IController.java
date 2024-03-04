package controller;

import controller.command.CommandException;

/**
 * Represents the interface of a controller.
 */
public interface IController {

  /**
   * Send command.
   *
   * @param command the command to be sent
   */
  void processCommand(String command) throws CommandException;

  /**
   * Asserts the controller is run successfully.
   * @return Boolean indicating success or failure
   */
  boolean run();

  /**
   * Gets the id of the current layer.
   * @return the id of the current layer
   */
  int getCurrentLayer();
}
