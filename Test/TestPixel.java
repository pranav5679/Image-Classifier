import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import model.pixel.IPixel;
import model.pixel.PixelImpl;
import org.junit.Test;

/**
 * Class to test pixel methods.
 */
public class TestPixel {

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeRows() {
    IPixel pixel = new PixelImpl(-1, 0, 0, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeColumns() {
    IPixel pixel = new PixelImpl(0, -1, 0, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeRGB() {
    IPixel pixel = new PixelImpl(0, 0, 0, -1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooLargeRGB() {
    IPixel pixel = new PixelImpl(0, 0, 0, 256, 0);
  }

  @Test
  public void testGetRowPosition() {
    IPixel pixel = new PixelImpl(101, 0, 0, 255, 0);
    assertEquals(101, pixel.getRowPosition());
  }

  @Test
  public void testGetColumnPosition() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 0);
    assertEquals(350, pixel.getColumnPosition());
  }

  @Test
  public void testGetChannel0() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    assertEquals(0, pixel.getChannel(0));
  }

  @Test
  public void testGetChannel1() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    assertEquals(255, pixel.getChannel(1));
  }

  @Test
  public void testGetChannel2() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    assertEquals(4, pixel.getChannel(2));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetChannel4() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    pixel.getChannel(4);
  }

  @Test
  public void testMaxColor() {
    IPixel pixel = new PixelImpl(1, 250, 0, 255, 5);
    assertEquals(255, pixel.maxColor());
  }

  @Test
  public void testToString() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    assertEquals("0" + '\n' + 255 + '\n' + 4, pixel.toString());
  }

  @Test
  public void testEqualsSameObject() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    assertTrue(pixel.equals(pixel));
  }

  @Test
  public void testEqualsSameFields() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    IPixel pixel1 = new PixelImpl(0, 350, 0, 255, 4);
    assertTrue(pixel1.equals(pixel));
  }

  @Test
  public void testEqualsDifferentObject() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    assertFalse(pixel.equals("hey"));
  }

  @Test
  public void testEqualsDifferentRow() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    IPixel pixel1 = new PixelImpl(1, 350, 0, 255, 4);
    assertFalse(pixel.equals(pixel1));
  }

  @Test
  public void testEqualsDifferentColumn() {
    IPixel pixel = new PixelImpl(1, 250, 0, 255, 4);
    IPixel pixel1 = new PixelImpl(1, 350, 0, 255, 4);
    assertFalse(pixel.equals(pixel1));
  }

  @Test
  public void testEqualsDifferentRed() {
    IPixel pixel = new PixelImpl(1, 250, 1, 255, 4);
    IPixel pixel1 = new PixelImpl(1, 350, 0, 255, 4);
    assertFalse(pixel.equals(pixel1));
  }

  @Test
  public void testEqualsDifferentGreen() {
    IPixel pixel = new PixelImpl(1, 250, 0, 254, 4);
    IPixel pixel1 = new PixelImpl(1, 350, 0, 255, 4);
    assertFalse(pixel.equals(pixel1));
  }

  @Test
  public void testEqualsDifferentBlue() {
    IPixel pixel = new PixelImpl(1, 250, 0, 255, 5);
    IPixel pixel1 = new PixelImpl(1, 350, 0, 255, 4);
    assertFalse(pixel.equals(pixel1));
  }

  @Test
  public void testHashcode() {
    IPixel pixel = new PixelImpl(1, 250, 0, 255, 5);
    assertEquals(1510, pixel.hashCode());
  }


}
