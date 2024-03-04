package model.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import model.pixel.IPixel;

/**
 * Class representing an image with a series of pixels, a height and width.
 */
public class ImageImpl implements IImage {

  private final int height;
  private final int width;
  private final List<List<IPixel>> pixels;

  /**
   * Constructs an image from a height, width, and list of pixels.
   *
   * @param height height of image
   * @param width  width of image
   * @param pixels pixels in image
   */
  public ImageImpl(int height, int width, List<List<IPixel>> pixels) {
    if (height < 0 || width < 0) {
      throw new IllegalArgumentException("Height/width cannot be negative!");
    }
    this.height = height;
    this.width = width;
    this.pixels = Objects.requireNonNull(pixels);
    if (!this.validImage()) {
      throw new IllegalArgumentException("Invalid image because the number of "
          + "pixels isn't as expected");
    }
  }

  /**
   * Checks if the image is a valid image based on it's parameters.
   *
   * @return if the image is valid
   */
  private boolean validImage() {
    if (this.pixels.size() != height) {
      return false;
    }

    for (List<IPixel> list : this.pixels) {
      return list.size() == width;
    }

    return true;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public List<List<IPixel>> getPixels() {
    List<List<IPixel>> listToReturn = new ArrayList<List<IPixel>>();
    for (List<IPixel> row : pixels) {
      List<IPixel> newRow = new ArrayList<IPixel>();
      listToReturn.add(newRow);
      for (IPixel pixel : row) {
        newRow.add(pixel);
      }
    }
    return listToReturn;
  }

  @Override
  public int maxColor() {
    List<Integer> listToReturn = new ArrayList<Integer>();
    for (List<IPixel> row : pixels) {
      for (IPixel pixel : row) {
        listToReturn.add(pixel.maxColor());
      }
    }
    return Collections.max(listToReturn);
  }

  @Override
  public String toString() {

    StringBuilder body = new StringBuilder("");
    for (List<IPixel> row : this.pixels) {
      for (IPixel pixel : row) {
        body.append('\n' + pixel.toString());
      }
    }
    return body.toString();
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }

    if (!(that instanceof IImage)) {
      return false;
    }

    if (((IImage) that).getHeight() != this.getHeight() ||
        ((IImage) that).getWidth() != this.getWidth()) {
      return false;
    }
    return ((IImage) that).getPixels().equals(this.pixels);
  }

  @Override
  public int hashCode() {
    int value = 0;

    for (List<IPixel> row : this.pixels) {
      for (IPixel pixel : row) {
        value += pixel.hashCode();
      }
    }
    return value;
  }
}
