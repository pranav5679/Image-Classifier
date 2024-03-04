package model.transformation;

import model.matrix.IMatrix;
import model.matrix.MatrixImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to apply the gray scale transformation to an image.
 */
public class GrayScaleImpl extends AbstractColorImpl {

  private static List<Double> row1 = new ArrayList<Double>(Arrays.asList(0.2126, 0.7152, 0.0722));
  private static List<Double> row2 = new ArrayList<Double>(Arrays.asList(0.2126, 0.7152, 0.0722));
  private static List<Double> row3 = new ArrayList<Double>(Arrays.asList(0.2126, 0.7152, 0.0722));
  private static List<List<Double>> matrixAsLists =
      new ArrayList<List<Double>>(Arrays.asList(row1, row2, row3));
  private static IMatrix matrix = new MatrixImpl(3, 3, matrixAsLists);

  /**
   * Construct a gray scale with the matrix needed.
   */
  public GrayScaleImpl() {
    super.matrix = matrix;
  }
}
