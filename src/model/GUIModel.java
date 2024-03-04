package model;

import controller.command.CommandResponse;
import model.multilayerimage.MultiLayerImageImpl;

/**
 * Represents a model of an image.
 */
public class GUIModel extends Model {

  /**
   * Constructs a image model.
   */
  public GUIModel() {
    super();
  }

  @Override
  protected void setResponse(CommandResponse commandResponse, MultiLayerImageImpl multiLayerImage) {
    commandResponse.setSuccess(true);
    commandResponse.setResponse(getCurrentImage(multiLayerImage));
  }

}
