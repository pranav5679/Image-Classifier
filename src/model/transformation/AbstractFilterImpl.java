package model.transformation;

import model.image.IImage;
import model.image.ImageImpl;
import model.matrix.IMatrix;
import model.matrix.MatrixImpl;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Abstract class for filter transformations.
 */
public abstract class AbstractFilterImpl implements ITransformation {

  protected static IMatrix matrix;


  @Override
  public IImage applyTransformation(IImage image) {
    Objects.requireNonNull(image);
    return new ImageImpl(image.getHeight(), image.getWidth(), this.overlapMatrix(image));
  }

  /**
   * Return the list of pixels for new image.
   * @param image image to transform
   * @return list of list of pixels for image
   */
  protected List<List<IPixel>> overlapMatrix(IImage image) {
    List<List<IPixel>> originalPixels = image.getPixels();
    int height = image.getHeight();
    int width = image.getWidth();
    List<List<IPixel>> listToReturn = new ArrayList<List<IPixel>>();

    for (List<IPixel> row : image.getPixels()) {
      List<IPixel> newRow = new ArrayList<IPixel>();

      for (IPixel pixel : row) {
        int rowPosition = pixel.getRowPosition();
        int columnPosition = pixel.getColumnPosition();

        IPixel newPixel = this.overlapNewPixel(rowPosition, columnPosition,
            originalPixels, height, width);
        newRow.add(newPixel);
      }
      listToReturn.add(newRow);
    }
    return listToReturn;
  }

  /**
   * Create new pixel for the new Image.
   *
   * @param rowPosition    row position of pixel
   * @param columnPosition column position of pixel
   * @param originalPixels original pixels of image
   * @param height         height of image
   * @param width          width of image
   * @return new pixel for new image
   */
  protected IPixel overlapNewPixel(int rowPosition, int columnPosition, List<List<IPixel>>
      originalPixels, int height, int width) {
    int newRedValue = clampValues(matrix.overlapMatrixMultiplication(this.overlapCreateMatrix(
        rowPosition, columnPosition, 0, originalPixels, height, width)));
    int newGreenValue = clampValues(matrix.overlapMatrixMultiplication(this.overlapCreateMatrix(
        rowPosition, columnPosition, 1, originalPixels, height, width)));
    int newBlueValue = clampValues(matrix.overlapMatrixMultiplication(this.overlapCreateMatrix(
        rowPosition, columnPosition, 2, originalPixels, height, width)));
    return new PixelImpl(rowPosition, columnPosition, newRedValue, newGreenValue, newBlueValue);
  }


  /**
   * Create a matrix around the pixel.
   *
   * @param rowPosition    row position of pixel
   * @param columnPosition column position of pixel
   * @param channel        channel of pixel
   * @param originalPixels original images pixel
   * @param height         height of image
   * @param width          width of image
   * @return matrix surrounding pixel
   */
  protected IMatrix overlapCreateMatrix(int rowPosition, int columnPosition,
      int channel, List<List<IPixel>> originalPixels, int height, int width) {

    int matrixNumberOfRows = this.matrix.getNumberOfRows();
    int matrixNumberOfColumns = this.matrix.getNumberOfColumns();
    int howManyUpOrDown = (matrixNumberOfRows - 1) / 2;
    int howManyLeftOrRight = (matrixNumberOfColumns - 1) / 2;
    int topLeftRow = rowPosition - howManyLeftOrRight;
    int topLeftColumn = columnPosition - howManyUpOrDown;
    int bottomRightRow = rowPosition + howManyLeftOrRight;
    int bottomRightColumn = columnPosition + howManyUpOrDown;

    List<List<Double>> matrixLists = new ArrayList<List<Double>>();
    for (int i = topLeftRow; i < bottomRightRow + 1; i++) {
      List<Double> matrixRow = new ArrayList<Double>();

      for (int j = topLeftColumn; j < bottomRightColumn + 1; j++) {
        if (i < 0 || j < 0 || i > height - 1 || j > width - 1) {
          matrixRow.add(0.0);
        } else {
          matrixRow.add((double) originalPixels.get(i).get(j).getChannel(channel));
        }
      }
      matrixLists.add(matrixRow);
    }
    return new MatrixImpl(matrixNumberOfRows, matrixNumberOfColumns, matrixLists);
  }

  /**
   * If the values are negative clamp to 0, if they are over 255 clamp to 255.
   *
   * @param originalValue original value of rgb color
   * @return clamped value
   */
  private int clampValues(int originalValue) {
    if (originalValue > 255) {
      return 255;
    }
    if (originalValue < 0) {
      return 0;
    } else {
      return originalValue;
    }
  }


}
