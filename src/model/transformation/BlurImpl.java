package model.transformation;

import model.matrix.IMatrix;
import model.matrix.MatrixImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for blurring images.
 */
public class BlurImpl extends AbstractFilterImpl {

  private static List<Double> row1 =
      new ArrayList<Double>(Arrays.asList(0.0625, 0.125, 0.0625));
  private static List<Double> row2 =
      new ArrayList<Double>(Arrays.asList(0.125, 0.25, 0.125));
  private static List<Double> row3 =
      new ArrayList<Double>(Arrays.asList(0.0625, 0.125, 0.0625));
  private static List<List<Double>> matrixAsLists =
      new ArrayList<List<Double>>(Arrays.asList(row1, row2, row3));
  private static IMatrix matrix =
      new MatrixImpl(3, 3, matrixAsLists);

  /**
   * Construct a blur image with the matrix needed.
   */
  public BlurImpl() {
    super.matrix = matrix;
  }

}
