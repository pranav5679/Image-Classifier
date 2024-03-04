package view;

import controller.IController;

import controller.command.CommandResponse;

/**
 * Represents the interface of a view.
 */
public interface IView {

  /**
   * Starts the view.
   *
   * @return Success or failure
   */
  boolean start(Object param);

  /**
   * Render message.
   *
   * @param message the message to be rendered
   */
  void renderMessage(String message);

  /**
   * Render Response.
   *
   * @param commandResponse the response object to be rendered
   */
  void renderResponse(CommandResponse commandResponse);

  /**
   * Set controller.
   *
   * @param controller the controller object to be set
   */
  void setController(IController controller);

}
