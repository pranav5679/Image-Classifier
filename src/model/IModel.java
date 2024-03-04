package model;

import controller.command.CommandException;
import controller.command.CommandResponse;
import model.multilayerimage.MultiLayerImageImpl;

/**
 * Represents the interface for the model.
 */
public interface IModel {

  /**
   * Process a command.
   * @param commandLine command to be processed.
   * @return response object to be returned
   */
  CommandResponse processCommand(MultiLayerImageImpl multiLayerImage, String commandLine)
      throws CommandException;

  /**
   * Gets a response object.
   * @return the object that contains the response
   */
  Object getResponseObject(CommandResponse commandResponse);
}
