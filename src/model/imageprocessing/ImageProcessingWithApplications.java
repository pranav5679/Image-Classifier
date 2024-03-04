package model.imageprocessing;

import model.image.IImage;
import model.transformation.ITransformation;

/**
 * Interface to add methods that apply transformations and processes to images.
 */
public interface ImageProcessingWithApplications {

  /**
   * Applies the given transformation to the image with the associated key.
   *
   * @param key            key associated with image to transform
   * @param transformation transformation to apply
   * @return the transformed image
   */
  IImage applyTransformation(String key, ITransformation transformation);

}
