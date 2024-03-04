package model.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class representing a matrix of doubles, using a list of rows to represent them.
 */
public class MatrixImpl implements IMatrix {

  private final int numOfRows;
  private final int numOfColumns;
  private final List<List<Double>> matrix;

  /**
   * Constructs a matrix from a list of list of doubles.
   *
   * @param numOfRows    number of rows in the matrix
   * @param numOfColumns number of columns in the matrix
   * @param matrix       a list of list of integers
   */
  public MatrixImpl(int numOfRows, int numOfColumns, List<List<Double>> matrix) {
    if (numOfColumns < 1 || numOfRows < 1) {
      throw new IllegalArgumentException("Cannot have rows or columns less than 1.");
    }
    this.numOfRows = numOfRows;
    this.numOfColumns = numOfColumns;
    this.matrix = Objects.requireNonNull(matrix);
    if (!this.validMatrix()) {
      throw new IllegalArgumentException("This matrix is invalid!");
    }
  }

  /**
   * Checks if the matrix is a valid matrix based on it's parameters.
   *
   * @return
   */
  private boolean validMatrix() {
    if (this.matrix.size() != numOfRows) {
      return false;
    }

    for (List<Double> list : this.matrix) {
      return list.size() == numOfColumns;
    }

    return true;
  }

  @Override
  public int getNumberOfRows() {
    return numOfRows;
  }

  @Override
  public int getNumberOfColumns() {
    return numOfColumns;
  }


  @Override
  public List<Double> getRow(int row) {
    if (row > numOfRows - 1 || row < 0) {
      throw new IllegalArgumentException("Row is out of bounds.");
    }

    List<Double> rowCopy = new ArrayList<Double>();
    for (Double number : matrix.get(row)) {
      rowCopy.add(number);
    }
    return rowCopy;
  }

  @Override
  public int overlapMatrixMultiplication(IMatrix matrixToOverlap) {
    Objects.requireNonNull(matrixToOverlap);

    if (matrixToOverlap.getNumberOfRows() != this.numOfRows) {
      throw new IllegalArgumentException("Wrong Number Of rows");
    }
    if (matrixToOverlap.getNumberOfColumns() != this.numOfColumns) {
      throw new IllegalArgumentException("Wrong Number Of rows");
    }

    double value = 0;

    for (int i = 0; i < this.numOfRows; i++) {
      for (int j = 0; j < this.numOfColumns; j++) {
        value += this.matrix.get(i).get(j) * matrixToOverlap.getRow(i).get(j);
      }
    }
    return ((int) Math.round(value));
  }
}
