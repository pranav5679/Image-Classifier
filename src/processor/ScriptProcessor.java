package processor;

import controller.IController;
import controller.ScriptController;
import model.ScriptModel;
import model.IModel;
import view.ScriptView;
import view.IView;

/**
 * Represents a processor for a script.
 */
public class ScriptProcessor extends Processor {

  /**
   * Constructs a processor for a script.
   */
  public ScriptProcessor(String filepath) {
    super();
    IController controller = null;
    IView view = new ScriptView();
    IModel model = new ScriptModel();
    controller = new ScriptController(filepath, model, view);
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
