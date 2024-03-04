package model.image;

import model.pixel.IPixel;
import java.util.List;

/**
 * Interface representing an Image.
 */
public interface IImage {

  /**
   * Get the height of an image.
   *
   * @return height
   */
  int getHeight();

  /**
   * Get the width of an image.
   *
   * @return width
   */
  int getWidth();

  /**
   * Get the list of rows of pixels.
   *
   * @return the list of rows of pixels
   */
  List<List<IPixel>> getPixels();

  /**
   * Get the maximum color of the pixels in an image.
   *
   * @return maximum color
   */
  int maxColor();
}
