package model.imageimporter;

import model.image.IImage;

/**
 * Interface for different types of files to be converted to our image representation.
 */
public interface ImageImporter {

  /**
   * Creates an image from the file type.
   *
   * @return the file in our representation of an image
   */
  IImage readFile();


}
