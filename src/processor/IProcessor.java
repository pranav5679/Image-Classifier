package processor;

/**
 * The interface for a processor.
 */
public interface IProcessor {

  /**
   * Asserts that the processor has been successfully executed.
   *
   * @return the boolean value of its success
   */
  boolean run();
}
