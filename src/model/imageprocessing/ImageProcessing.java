package model.imageprocessing;

import model.image.IImage;

/**
 * Model for Image Processing with basis methods for an image processing model.
 */
public interface ImageProcessing extends ImageProcessingWithApplications {

  /**
   * Adds the given image to our collection of images.
   *
   * @param key   String representation of an image
   * @param image Image object to add
   */
  void addImage(String key, IImage image);

  /**
   * Removes the given image from our collection of images.
   *
   * @param key String representation of an image
   */
  void removeImage(String key);

  /**
   * Gets the image associated with the specified key.
   *
   * @param key String representation of an image
   * @return a new instance of the image associated with the given key
   */
  IImage getImage(String key);

  /**
   * Replace the image associated with the given key with the new image.
   *
   * @param key   String representation of an image
   * @param image image to replace with
   */
  void replaceImage(String key, IImage image);

  /**
   * Gets the height of the image with the associated key.
   *
   * @param key String representation of an image
   * @return height of image
   */
  int getImageHeight(String key);

  /**
   * Gets the width of the image with the associated key.
   *
   * @param key String representation of an image
   * @return width of image
   */
  int getImageWidth(String key);

  /**
   * Gets the number of pixels in the image with the associated key.
   *
   * @param key String representation of an image
   * @return number of pixels
   */
  int getNumberOfPixels(String key);

  /**
   * Gets the max rgb value of the image with the associated key.
   *
   * @param key String representation of an image
   * @return max rgb value of image
   */
  int getMaxRGB(String key);
}
