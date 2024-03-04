import static org.junit.Assert.assertEquals;

import model.matrix.IMatrix;
import model.matrix.MatrixImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Class to test matrix methods.
 */
public class TestMatrix {

  List<Double> row1 = new ArrayList<Double>(Arrays.asList(1., 2., 3.));
  List<Double> row2 = new ArrayList<Double>(Arrays.asList(4., 5., 6.));
  List<Double> row3 = new ArrayList<Double>(Arrays.asList(7., 8., 9.));
  List<List<Double>> matrixAsLists = new ArrayList<List<Double>>(Arrays.asList(row1, row2, row3));
  IMatrix matrix3x3 = new MatrixImpl(3, 3, matrixAsLists);

  List<Double> row11 = new ArrayList<Double>(Arrays.asList(128., 0.0, 0.0));
  List<Double> row21 = new ArrayList<Double>(Arrays.asList(0.0, 255., 0.));
  List<Double> row31 = new ArrayList<Double>(Arrays.asList(0.0, 0., 0.));
  List<List<Double>> matrixAsLists1 = new ArrayList<List<Double>>(
      Arrays.asList(row11, row21, row31));
  IMatrix matrix1 = new MatrixImpl(3, 3, matrixAsLists1);

  @Test(expected = IllegalArgumentException.class)
  public void testMatrixWithRowsLessThan1() {
    IMatrix matrix = new MatrixImpl(0, 3, matrixAsLists);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMatrixWithColumnsLessThan1() {
    IMatrix matrix = new MatrixImpl(3, 0, matrixAsLists);
  }

  @Test(expected = NullPointerException.class)
  public void testMatrixWithNullMatrixList() {
    IMatrix matrix = new MatrixImpl(3, 3, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMatrixWithRowsBeingWrongThanRowsOfGivenList() {
    IMatrix matrix = new MatrixImpl(2, 3, matrixAsLists);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMatrixWithColumnsBeingWrongThanRowsOfGivenList() {
    IMatrix matrix = new MatrixImpl(3, 2, matrixAsLists);
  }

  @Test
  public void testMatrixGetNumberOfRows() {
    assertEquals(3, matrix3x3.getNumberOfRows());
  }

  @Test
  public void testMatrixGetNumberOfColumns() {
    assertEquals(3, matrix3x3.getNumberOfColumns());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMatrixGetRowNegativeRow() {
    matrix3x3.getRow(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMatrixGetRowTooLargeRow() {
    matrix3x3.getRow(3);
  }

  @Test
  public void testMatrixGetRow() {
    List<Double> row = new ArrayList<Double>(Arrays.asList(4., 5., 6.));
    assertEquals(row, matrix3x3.getRow(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMatrixOverlapMatrixWrongNumberOfRows() {
    List<Double> row1 =
        new ArrayList<Double>(Arrays.asList(-0.125, -0.125, -0.125, -0.125, -0.125));
    List<Double> row2 =
        new ArrayList<Double>(Arrays.asList(-0.125, 0.25, 0.25, 0.25, -0.125));
    List<Double> row3 =
        new ArrayList<Double>(Arrays.asList(-0.125, 0.25, 0.0625, 0.25, -0.125));
    List<Double> row4 =
        new ArrayList<Double>(Arrays.asList(-0.125, 0.25, -0.25, 0.25, -0.125));
    List<Double> row5 =
        new ArrayList<Double>(Arrays.asList(-0.125, -0.125, -0.125, -0.125, -0.125));
    List<List<Double>>
        matrixAsLists = new ArrayList<List<Double>>(Arrays.asList(row1, row2, row3, row4, row5));
    IMatrix matrixToOverlap =
        new MatrixImpl(5, 5, matrixAsLists);

    matrix3x3.overlapMatrixMultiplication(matrixToOverlap);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMatrixOverlapMatrixWrongNumberOfColumns() {
    List<Double> row1 =
        new ArrayList<Double>(Arrays.asList(-0.125, -0.125, -0.125, -0.125, -0.125));
    List<Double> row2 =
        new ArrayList<Double>(Arrays.asList(-0.125, 0.25, 0.25, 0.25, -0.125));
    List<Double> row3 =
        new ArrayList<Double>(Arrays.asList(-0.125, 0.25, 0.0625, 0.25, -0.125));
    List<List<Double>>
        matrixAsLists = new ArrayList<List<Double>>(Arrays.asList(row1, row2, row3));
    IMatrix matrixToOverlap =
        new MatrixImpl(3, 5, matrixAsLists);

    matrix3x3.overlapMatrixMultiplication(matrixToOverlap);
  }

  @Test
  public void testMatrixOverlap() {
    List<Double> row1 =
        new ArrayList<Double>(Arrays.asList(1., 2., 3.));
    List<Double> row2 =
        new ArrayList<Double>(Arrays.asList(4., 5., 6.));
    List<Double> row3 =
        new ArrayList<Double>(Arrays.asList(7., 8., 9.));
    List<List<Double>>
        matrixAsLists = new ArrayList<List<Double>>(Arrays.asList(row1, row2, row3));
    IMatrix matrixToOverlap =
        new MatrixImpl(3, 3, matrixAsLists);

    assertEquals(285, matrix3x3.overlapMatrixMultiplication(matrixToOverlap));
  }


}
