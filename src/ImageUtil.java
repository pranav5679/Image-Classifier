import processor.IProcessor;
import processor.ProcessorFactory;

/**
 * Represents the utilities of this MVC model that
 * mainly works on calling out to different views.
 */
public class ImageUtil {

  /**
   * Calls out to the different views based on command line inputs.
   * @param argv the command line that is going to call to a view
   */
  public static void main(String[] argv) {
    IProcessor processor = null;
    boolean success = false;
    if (argv == null || argv.length == 0) {
      System.out.println("Invalid argument.");
    }
    else {
      switch (argv[0]) {
        case "-script":
          processor = ProcessorFactory.instantiate(ProcessorFactory.SCRIPT_PROCESSOR, argv);
          if (processor != null) {
            success = processor.run();
          }
          else {
            System.out.println("Usage: ImageUtil -script <script>");
          }
          break;
        case "-text":
          processor = ProcessorFactory.instantiate(ProcessorFactory.TEXT_PROCESSOR, argv);
          if (processor != null) {
            success = processor.run();
          }
          else {
            System.out.println("Usage: ImageUtil -text");
          }
          break;
        case "-interactive":
          processor = ProcessorFactory.instantiate(ProcessorFactory.GUI_PROCESSOR, argv);
          if (processor != null) {
            success = processor.run();
          }
          else {
            System.out.println("Usage: ImageUtil -interactive");
          }
          break;
        default:
          System.out.println("Invalid command line syntax.");
          break;
      }
    }
    if (processor != null) {
      if (!success) {
        System.out.println("ImageUtil failed.");
      }
    }
  }
}
