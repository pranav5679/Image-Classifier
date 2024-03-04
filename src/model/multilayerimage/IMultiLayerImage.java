package model.multilayerimage;

/**
 * The interface for a Multilayer image.
 */
public interface IMultiLayerImage {

  /**
   * Gets the current layer id.
   * @return the id value
   */
  int getCurrentID();

  /**
   * Checks if passing in a create ... in the ScriptManager
   * is going to successfully implement the create command.
   * @param id the layer position assigned by the script
   * @return the boolean value of the create command's success
   */
  boolean addLayer(int id);

  /**
   * Checks if passing in a delete ... in the ScriptManager
   * is going to successfully implement the delete command.
   * @param id the layer position assigned by the script
   * @return the boolean value of the delete command's success
   */
  boolean removeLayer(int id);

  /**
   * Checks if passing in a current ... in the ScriptManager
   * is going to successfully implement the current command.
   * @param id the layer position assigned by the script
   * @return the boolean value of the current command's success
   */
  boolean setCurrent(int id);

  /**
   * Checks if passing in a invisible ... in the ScriptManager
   * is going to successfully implement the invisible command.
   * @param id the layer position assigned by the script
   * @return the boolean value of the invisible command's success
   */
  boolean setInvisible(int id);

  /**
   * Checks if passing in a load ... in the ScriptManager
   * is going to successfully implement the load command.
   * @param filepath the filepath to the image needed to be loaded
   * @return the boolean value of the load command's success
   */
  boolean loadImage(String filepath);

  /**
   * Checks if passing in a save ... in the ScriptManager
   * is going to successfully implement the save command.
   * @param filepath the filepath of the image needed to be saved
   * @return the boolean value of the save command's success
   */
  boolean saveImage(String filepath);

  /**
   * Checks if passing in a sepia in the ScriptManager
   * is going to successfully implement the sepia command.
   * @return the boolean value of the sepia command's success
   */
  boolean sepia();

  /**
   * Checks if passing in a gray in the ScriptManager
   * is going to successfully implement the grayscale command.
   * @return the boolean value of the grayscale command's success
   */
  boolean grayscale();

  /**
   * Checks if passing in a blur in the ScriptManager
   * is going to successfully implement the blur command.
   * @return the boolean value of the blur command's success
   */
  boolean blur();

  /**
   * Checks if passing in a sharpen in the ScriptManager
   * is going to successfully implement the sharpen command.
   * @return the boolean value of the sharpen command's success
   */
  boolean sharpen();

}
