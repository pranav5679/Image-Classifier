package model.transformation;

import model.matrix.IMatrix;
import model.matrix.MatrixImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to apply the sepia tone transformation to an image.
 */
public class SepiaToneImpl extends AbstractColorImpl {

  // Since these belong to the class, they are static
  private static List<Double> row1 = new ArrayList<Double>(Arrays.asList(0.393, 0.769, 0.189));
  private static List<Double> row2 = new ArrayList<Double>(Arrays.asList(0.349, 0.686, 0.168));
  private static List<Double> row3 = new ArrayList<Double>(Arrays.asList(0.272, 0.534, 0.131));
  private static List<List<Double>> matrixAsLists =
      new ArrayList<List<Double>>(Arrays.asList(row1, row2, row3));
  private static IMatrix matrix =
      new MatrixImpl(3, 3, matrixAsLists);

  /**
   * Construct a sepia tone with the matrix needed.
   */
  public SepiaToneImpl() {
    super.matrix = matrix;
  }
}
