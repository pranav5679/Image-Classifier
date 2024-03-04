package processor;

import controller.IController;
import controller.TextController;
import model.TextModel;
import model.IModel;
import view.TextView;
import view.IView;

/**
 * Represents a processor for the text.
 */
public class TextProcessor extends Processor {

  /**
   * Constructs a processor for the text.
   */
  public TextProcessor() {
    super();
    IController controller = null;
    IView view = new TextView();
    IModel model = new TextModel();
    controller = new TextController(model, view);
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
