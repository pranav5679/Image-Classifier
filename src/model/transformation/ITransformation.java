package model.transformation;

import model.image.IImage;

/**
 * Interface that represents a color transformation.
 */
public interface ITransformation {

  /**
   * Applies a transformation to the given image.
   *
   * @param image image to apply transformation to
   * @return a new instance of the image after the transformation
   */
  IImage applyTransformation(IImage image);

}
