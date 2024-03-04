package model.transformation;

import model.image.IImage;
import model.image.ImageImpl;
import model.matrix.IMatrix;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Abstract class for color transformations.
 */
public abstract class AbstractColorImpl implements ITransformation {

  protected static IMatrix matrix;

  @Override
  public IImage applyTransformation(IImage image) {
    Objects.requireNonNull(image);
    List<List<IPixel>> newListOfPixels = new ArrayList<List<IPixel>>();

    for (List<IPixel> row : image.getPixels()) {
      List<IPixel> newRow = new ArrayList<IPixel>();
      newListOfPixels.add(newRow);
      for (IPixel pixel : row) {
        newRow.add(this.multiplyByMatrix(pixel));
      }
    }
    IImage imageToReturn = new ImageImpl(image.getHeight(), image.getWidth(), newListOfPixels);
    return imageToReturn;
  }


  /**
   * Multiply the pixel by the matrix.
   * @param pixel pixel to mulitply
   * @return new pixel
   */
  protected IPixel multiplyByMatrix(IPixel pixel) {

    // Multiply the respective row by the respective color for matrix vector multiplication
    int newRed = this.multiplyElementByRow(matrix.getRow(0), pixel);
    int newGreen = this.multiplyElementByRow(matrix.getRow(1), pixel);
    int newBlue = this.multiplyElementByRow(matrix.getRow(2), pixel);

    IPixel newPixel = new PixelImpl(pixel.getRowPosition(), pixel.getColumnPosition(),
        newRed, newGreen, newBlue);

    return newPixel;
  }


  /**
   * Multiply element by another row of matrix.
   *
   * @param row vector to multiply by
   * @return new value of element
   */
  protected int multiplyElementByRow(List<Double> row, IPixel pixel) {
    double newValue = 0;

    for (int i = 0; i < row.size(); i++) {
      newValue += this.multiplyChannelNumber(i, row.get(i), pixel);
    }

    if (newValue > 255) {
      return 255;
    }
    if (newValue < 0) {
      return 0;
    } else {
      return (int) Math.round(newValue);
    }
  }

  /**
   * Multiply channel by double.
   * @param channel what channel
   * @param multiplicity multiplicity factor
   * @param pixel pixel to multiply channel
   * @return double of result of channel given times multiplicity
   */
  protected double multiplyChannelNumber(int channel, double multiplicity, IPixel pixel) {
    return pixel.getChannel(channel) * multiplicity;
  }


}
