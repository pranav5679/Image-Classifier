package model;

import model.image.IImage;
import model.image.ImageImpl;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class to create a checkerboard image.
 */
public class CheckerBoardCreator {

  /**
   * Create a checker board with from the given parameters.
   * @param sizeOfSquare size of each square
   * @param numberOfRows number of rows
   * @param numberOfColumns number of columns
   * @param color1 color of first square
   * @param color2 color of second square
   * @return checkerboard image
   */
  public IImage createCheckerBoard(int sizeOfSquare, int numberOfRows,
      int numberOfColumns, SupportedColors color1, SupportedColors color2) {

    // These parameters cannot be null
    Objects.requireNonNull(color1);
    Objects.requireNonNull(color2);

    // The size of a square, number of rows, and number of columns cannot be less than 1
    if (sizeOfSquare < 1 || numberOfColumns < 1 || numberOfRows < 1) {
      throw new IllegalArgumentException("Cannot have these inputs be less than 1.");
    }

    // The checker board must be made of two different colors
    if (color1.equals(color2)) {
      throw new IllegalArgumentException("Colors cannot be the same in a checker board.");
    }

    // Number of rows and columns of the image in terms of pixels
    int numberOfNewRows = sizeOfSquare * numberOfRows;
    int numberOfNewColumns = sizeOfSquare * numberOfColumns;

    // Basic code to create image
    List<List<IPixel>> pixelList = new ArrayList<List<IPixel>>();
    for (int i = 0; i < numberOfNewRows; i++) {
      List<IPixel> row = new ArrayList<IPixel>();
      pixelList.add(row);
      for (int j = 0; j < numberOfNewColumns; j++) {

        // Pattern to create pixels with different colors based on checker board layout
        if ((i / sizeOfSquare) % 2 == 0) {
          if ((j / sizeOfSquare) % 2 == 0) {
            row.add(this.createPixel(i, j, color1));
          }
          if ((j / sizeOfSquare) % 2 == 1) {
            row.add(this.createPixel(i, j, color2));
          }
        }
        if ((i / sizeOfSquare) % 2 == 1) {
          if ((j / sizeOfSquare) % 2 == 0) {
            row.add(this.createPixel(i, j, color2));
          }
          if ((j / sizeOfSquare) % 2 == 1) {
            row.add(this.createPixel(i, j, color1));
          }
        }
      }
    }

    // Image of checker board
    IImage checkerboard = new ImageImpl(numberOfNewRows, numberOfNewColumns, pixelList);
    return checkerboard;
  }

  // Helpers to create a checkerboard

  /**
   * Create a pixel from the row, column and color given.
   *
   * @param row    row number
   * @param column column number
   * @param color  color of pixel
   * @return new pixel with given parameters
   */
  private IPixel createPixel(int row, int column, SupportedColors color) {
    int redChannel = this.whichColor(color).get(0);
    int greenChannel = this.whichColor(color).get(1);
    int blueChannel = this.whichColor(color).get(2);
    return new PixelImpl(row, column, redChannel, greenChannel, blueChannel);
  }

  /**
   * Gets the IColor associated with the given color.
   *
   * @param color color given
   * @return the IColor with the correct channels associated with the given color
   */
  private List<Integer> whichColor(SupportedColors color) {
    List<Integer> listToReturn = new ArrayList<Integer>();
    int redChannel;
    int greenChannel;
    int blueChannel;

    switch (color) {
      case BLACK:
        listToReturn.add(0);
        listToReturn.add(0);
        listToReturn.add(0);
        break;
      case BLUE:
        listToReturn.add(0);
        listToReturn.add(0);
        listToReturn.add(255);
        break;
      case GREEN:
        listToReturn.add(0);
        listToReturn.add(255);
        listToReturn.add(0);
        break;
      case RED:
        listToReturn.add(255);
        listToReturn.add(0);
        listToReturn.add(0);
        break;
      case WHITE:
        listToReturn.add(255);
        listToReturn.add(255);
        listToReturn.add(255);
        break;
      default:
        throw new IllegalArgumentException("Not a supported color!");
    }
    return listToReturn;
  }

}
