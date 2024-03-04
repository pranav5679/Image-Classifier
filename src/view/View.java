package view;

import controller.IController;

/**
 * Represents an abstract class of a view object.
 */
public abstract class View implements IView {

  protected IController controller;

  /**
   * Set the controller.
   *
   * @param controller the controller object to be set
   */
  public void setController(IController controller) {
    this.controller = controller;
  }

}
