package processor;

import controller.GUIController;
import controller.IController;
import model.GUIModel;
import model.IModel;
import view.GUIView;
import view.IView;

/**
 * Represents the processor for the GUI.
 */
public class GUIProcessor extends Processor {

  /**
   * Constructs a processor for the GUI.
   */
  public GUIProcessor() {
    super();
    IController controller = null;
    IView view = new GUIView();
    IModel model = new GUIModel();
    controller = new GUIController(model, view);
    setController(controller);
    view.setController(controller);
  }

  /**
   * Start the processor.
   *
   * @return Success or failure
   */
  public boolean run() {
    return super.run();
  }
}
