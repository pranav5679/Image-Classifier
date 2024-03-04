package controller;

import model.IModel;
import view.IView;

/**
 * Represents a script controller that takes user input and works with the view and model to display
 * the finished product to the user.
 */
public class ScriptController extends Controller {

  private String filepath = null;

  /**
   * Constructs a image controller.
   *
   * @param model the model object
   * @param view  the view object
   */
  public ScriptController(String filepath, IModel model, IView view) {
    super(model, view);
    this.filepath = filepath;
  }

  @Override
  public boolean run() {
    return this.view.start(this.filepath);
  }

}
