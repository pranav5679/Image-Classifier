package controller;

import controller.command.CommandException;
import controller.command.CommandResponse;
import model.IModel;
import model.multilayerimage.MultiLayerImageImpl;
import view.IView;

/**
 * Represents a generic controller object.
 */
public class Controller implements IController {

  protected IView view;
  protected IModel model;
  private MultiLayerImageImpl multiLayerImage;

  /**
   * Constructs a controller.
   *
   * @param model the model object
   * @param view  the view object
   */
  public Controller(IModel model, IView view) {
    this.model = model;
    this.view = view;
    multiLayerImage = new MultiLayerImageImpl();
  }

  /**
   * Process command.
   *
   * @param commandLine the command to be sent
   */
  public void processCommand(String commandLine) throws CommandException {
    CommandResponse commandResponse = null;
    commandResponse = this.model.processCommand(this.multiLayerImage, commandLine);
    if (commandResponse != null) {
      if (commandResponse.getSuccess()) {
        this.view.renderResponse(commandResponse);
      }
      else {
        String errorMessage = commandResponse.getErrorMessage();
        this.view.renderMessage(errorMessage);
      }
    }
  }

  /**
   * Starts the controller.
   *
   * @return Success or failure
   */
  public boolean run() {
    return this.view.start(null);
  }

  @Override
  public int getCurrentLayer() {
    return this.multiLayerImage.getCurrentID();
  }
}
