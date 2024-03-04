package model.transformation;

import model.matrix.IMatrix;
import model.matrix.MatrixImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for sharpening images.
 */
public class SharpenImpl extends AbstractFilterImpl {

  private static List<Double> row1 =
      new ArrayList<Double>(Arrays.asList(-0.125, -0.125, -0.125, -0.125, -0.125));
  private static List<Double> row2 =
      new ArrayList<Double>(Arrays.asList(-0.125, 0.25, 0.25, 0.25, -0.125));
  private static List<Double> row3 =
      new ArrayList<Double>(Arrays.asList(-0.125, 0.25, 1., 0.25, -0.125));
  private static List<Double> row4 =
      new ArrayList<Double>(Arrays.asList(-0.125, 0.25, 0.25, 0.25, -0.125));
  private static List<Double> row5 =
      new ArrayList<Double>(Arrays.asList(-0.125, -0.125, -0.125, -0.125, -0.125));
  private static List<List<Double>>
      matrixAsLists = new ArrayList<List<Double>>(Arrays.asList(row1, row2, row3, row4, row5));
  private static IMatrix matrix =
      new MatrixImpl(5, 5, matrixAsLists);

  /**
   * Construct a sharpen image with the matrix needed.
   */
  public SharpenImpl() {
    super.matrix = matrix;
  }

}
