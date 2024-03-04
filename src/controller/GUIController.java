package controller;

import model.IModel;
import view.IView;

/**
 * Represents an image controller that takes user input and works with the view and model to display
 * the finished product to the user.
 */
public class GUIController extends Controller {

  /**
   * Constructs a image controller.
   *
   * @param model the model object
   * @param view  the view object
   */
  public GUIController(IModel model, IView view) {
    super(model, view);
  }

}
