package model.matrix;

import java.util.List;

/**
 * Interface representing a matrix.
 */
public interface IMatrix {

  /**
   * Returns the number of rows of the matrix.
   *
   * @return number of rows
   */
  int getNumberOfRows();

  /**
   * Returns the number of columns of the matrix.
   *
   * @return number of columns
   */
  int getNumberOfColumns();

  /**
   * Gets the value of the matrix at the specified position.
   *
   * @param row the row number
   * @return value at the given position
   */
  List<Double> getRow(int row);

  /**
   * Multiply the 1st term of one matrix to the 1st of the given, and so on, return the added sum.
   *
   * @param matrix second matrix
   * @return sum of multiplying overlap as an integer after rounding
   */
  int overlapMatrixMultiplication(IMatrix matrix);
}
