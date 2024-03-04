package model.pixel;

/**
 * Class representing a pixel with a position and a color.
 */
public class PixelImpl implements IPixel {

  private final int rowPosition;
  private final int columnPosition;
  private final int red;
  private final int green;
  private final int blue;

  /**
   * Constructs a Pixel given a row, column, and three integers for its colors.
   *
   * @param rowPosition    the position of the pixel in a row
   * @param columnPosition the position of the pixel in a column
   * @param red            the value of red
   * @param green          the value of green
   * @param blue           the value of blue
   */
  public PixelImpl(int rowPosition, int columnPosition, int red, int green, int blue) {
    // The position cannot be negative
    if (rowPosition < 0 || columnPosition < 0) {
      throw new IllegalArgumentException("Row or column position cannot be less than 0.");
    }
    this.rowPosition = rowPosition;
    this.columnPosition = columnPosition;
    // The color values must be between 0 and 255
    if (red < 0 || green < 0 || blue < 0 || red > 255 || green > 255 || blue > 255) {
      throw new IllegalArgumentException("Color values are invalid");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public int getColumnPosition() {
    return columnPosition;
  }

  @Override
  public int getRowPosition() {
    return rowPosition;
  }


  @Override
  public int getChannel(int channel) {
    switch (channel) {
      case 0:
        return red;
      case 1:
        return green;
      case 2:
        return blue;
      default:
        throw new IllegalArgumentException("Value given is not associated with any channel.");
    }
  }

  @Override
  public int maxColor() {
    int maxBetweenRedAndGreen = Math.max(this.red, this.green);
    return Math.max(maxBetweenRedAndGreen, this.blue);
  }

  @Override
  public String toString() {
    return Integer.toString(red) + '\n' +
        Integer.toString(green) + '\n' +
        Integer.toString(blue);
  }


  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }

    if (!(that instanceof IPixel)) {
      return false;
    }

    return ((IPixel) that).getColumnPosition() == this.getColumnPosition() &&
        ((IPixel) that).getRowPosition() == this.getRowPosition() &&
        ((IPixel) that).getChannel(0) == (this.getChannel(0)) &&
        ((IPixel) that).getChannel(1) == (this.getChannel(1)) &&
        ((IPixel) that).getChannel(2) == (this.getChannel(2));
  }

  @Override
  public int hashCode() {
    return (this.rowPosition * 1000) + this.columnPosition + this.red + this.green + this.blue;
  }
}
