package processor;

/**
 * Represents a singleton class for the factory that searches for a processor.
 */
public class ProcessorFactory {

  public static final String GUI_PROCESSOR = "GUI Processor";
  public static final String TEXT_PROCESSOR = "Text Processor";
  public static final String SCRIPT_PROCESSOR = "Script Processor";

  /**
   * Starts up any one of the processors.
   *
   * @param processorType the call to one type of processor
   * @param argv          the command line used to start up one of the processors
   * @return the processor called out by the command line
   */
  public static IProcessor instantiate(String processorType, String[] argv) {
    IProcessor processor = null;
    switch (processorType) {
      case ProcessorFactory.GUI_PROCESSOR:
        if (argv.length == 1) {
          processor = new GUIProcessor();
        }
        break;
      case ProcessorFactory.TEXT_PROCESSOR:
        if (argv.length == 1) {
          processor = new TextProcessor();
        }
        break;
      case ProcessorFactory.SCRIPT_PROCESSOR:
        if (argv.length == 2) {
          processor = new ScriptProcessor(argv[1]);
        }
        break;
      default:
        break;
    }
    return processor;
  }
}
