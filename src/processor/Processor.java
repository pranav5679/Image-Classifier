package processor;

import controller.IController;

/**
 * Represents a generic processor.
 */
public class Processor implements IProcessor {

  protected IController controller;

  /**
   * Constructs a default processor.
   */
  public Processor() {
    this(null);
  }

  /**
   * Constructs a processor that takes in a controller object.
   *
   * @param controller the controller that is compatible with the processor
   */
  public Processor(IController controller) {
    this.controller = controller;
  }

  /**
   * Set the controller in the processor to this controller.
   *
   * @param controller the controller replacing the current one
   */
  protected void setController(IController controller) {
    this.controller = controller;
  }

  @Override
  public boolean run() {
    return controller.run();
  }
}
