package model.layer;

import model.image.IImage;

/**
 * The interface for an Layer.
 */
public interface ILayer {

  /**
   * Sets the visibility of the Layer to be visible.
   */
  void turnOnLayer();

  /**
   * Sets the visibility of the Layer to be transparent.
   */
  void turnOffLayer();

  /**
   * Adds an image to an existing Layer.
   * @param image the image being added to the Layer
   */
  void addImageToLayer(IImage image);

  /**
   * Replaces the current image in the Layer with another image.
   * @param image the image replacing the current image
   */
  void setImage(IImage image);

  /**
   * Gets the current image in the Layer.
   * @return the image in the Layer
   */
  IImage getImage();

  /**
   * Checks if the Layer is visible or not.
   * @return the boolean value of the Layer's visibility
   */
  boolean getVisibility();
}
