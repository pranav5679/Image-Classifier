package model.pixel;

/**
 * Interface representing a Pixel.
 */
public interface IPixel {

  /**
   * Returns the x position of a pixel.
   *
   * @return x position
   */
  int getColumnPosition();

  /**
   * Returns the y position of a pixel.
   *
   * @return y position
   */
  int getRowPosition();

  /**
   * Gets the value associated with the given channel.
   *
   * @param channel channel 0,1,2
   * @return value of channel
   */
  int getChannel(int channel);

  /**
   * Returns the max rgb color of a pixel.
   *
   * @return max rgb value of a pixel.
   */
  int maxColor();
}
