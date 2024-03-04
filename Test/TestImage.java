import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import model.image.IImage;
import model.image.ImageImpl;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Tests for IImage methods.
 */
public class TestImage {

  IPixel pixel_0_0_Red = new PixelImpl(0, 0, 255, 0, 0);
  IPixel pixel_0_1_Green = new PixelImpl(0, 1, 0, 255, 0);
  IPixel pixel_0_2_Blue = new PixelImpl(0, 2, 0, 0, 255);
  IPixel pixel_1_0_Yellow = new PixelImpl(1, 0, 255, 255, 0);
  IPixel pixel_1_1_White = new PixelImpl(1, 1, 255, 255, 255);
  IPixel pixel_1_2_Black = new PixelImpl(1, 2, 0, 0, 0);
  List<IPixel> image_3x2_first_row =
      new ArrayList<IPixel>(Arrays.asList(pixel_0_0_Red, pixel_0_1_Green, pixel_0_2_Blue));
  List<IPixel> image_3x2_second_row =
      new ArrayList<IPixel>(Arrays.asList(pixel_1_0_Yellow, pixel_1_1_White, pixel_1_2_Black));
  List<List<IPixel>> image_3x2_pixels =
      new ArrayList<List<IPixel>>(Arrays.asList(image_3x2_first_row, image_3x2_second_row));
  IImage image_3x2 = new ImageImpl(2, 3, image_3x2_pixels);


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHeight() {
    new ImageImpl(0, 3, image_3x2_pixels);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWidth() {
    new ImageImpl(3, 0, image_3x2_pixels);
  }

  @Test(expected = NullPointerException.class)
  public void testNullPixels() {
    new ImageImpl(3, 0, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPixelsDoesNotMatchParametersGiven() {
    List<List<IPixel>> image_3x1_pixels =
        new ArrayList<List<IPixel>>(Arrays.asList(image_3x2_first_row));
    new ImageImpl(3, 0, image_3x1_pixels);
  }

  @Test
  public void testGetHeight() {
    assertEquals(2, image_3x2.getHeight());
  }

  @Test
  public void testGetWidth() {
    assertEquals(3, image_3x2.getWidth());
  }

  @Test
  public void testGetPixels() {
    IPixel pixel_0_0_Red_Copy =
        new PixelImpl(0, 0, 255, 0, 0);
    IPixel pixel_0_1_Green_Copy =
        new PixelImpl(0, 1, 0, 255, 0);
    IPixel pixel_0_2_Blue_Copy =
        new PixelImpl(0, 2, 0, 0, 255);
    IPixel pixel_1_0_Yellow_Copy =
        new PixelImpl(1, 0, 255, 255, 0);
    IPixel pixel_1_1_White_Copy =
        new PixelImpl(1, 1, 255, 255, 255);
    IPixel pixel_1_2_Black_Copy =
        new PixelImpl(1, 2, 0, 0, 0);
    List<IPixel> image_3x2_first_row_Copy =
        new ArrayList<IPixel>(Arrays.asList(pixel_0_0_Red_Copy,
            pixel_0_1_Green_Copy, pixel_0_2_Blue_Copy));
    List<IPixel> image_3x2_second_row_Copy =
        new ArrayList<IPixel>(Arrays.asList(pixel_1_0_Yellow_Copy,
            pixel_1_1_White_Copy, pixel_1_2_Black_Copy));
    List<List<IPixel>> image_3x2_pixels_Copy =
        new ArrayList<List<IPixel>>(
            Arrays.asList(image_3x2_first_row_Copy, image_3x2_second_row_Copy));
    assertEquals(image_3x2_pixels_Copy, image_3x2.getPixels());
  }

  @Test
  public void testMaxColor() {
    assertEquals(255, image_3x2.maxColor());
  }


  @Test
  public void testToString() {
    assertEquals("\n"
        + "255\n"
        + "0\n"
        + "0\n"
        + "0\n"
        + "255\n"
        + "0\n"
        + "0\n"
        + "0\n"
        + "255\n"
        + "255\n"
        + "255\n"
        + "0\n"
        + "255\n"
        + "255\n"
        + "255\n"
        + "0\n"
        + "0\n"
        + "0", image_3x2.toString());
  }

  @Test
  public void testEqualsSameObject() {

    assertTrue(image_3x2.equals(image_3x2));
  }

  @Test
  public void testEqualsSameFields() {
    IPixel pixel_0_0_Red_Copy =
        new PixelImpl(0, 0, 255, 0, 0);
    IPixel pixel_0_1_Green_Copy =
        new PixelImpl(0, 1, 0, 255, 0);
    IPixel pixel_0_2_Blue_Copy =
        new PixelImpl(0, 2, 0, 0, 255);
    IPixel pixel_1_0_Yellow_Copy =
        new PixelImpl(1, 0, 255, 255, 0);
    IPixel pixel_1_1_White_Copy =
        new PixelImpl(1, 1, 255, 255, 255);
    IPixel pixel_1_2_Black_Copy =
        new PixelImpl(1, 2, 0, 0, 0);
    List<IPixel> image_3x2_first_row_Copy =
        new ArrayList<IPixel>(Arrays.asList(pixel_0_0_Red_Copy,
            pixel_0_1_Green_Copy, pixel_0_2_Blue_Copy));
    List<IPixel> image_3x2_second_row_Copy =
        new ArrayList<IPixel>(Arrays.asList(pixel_1_0_Yellow_Copy,
            pixel_1_1_White_Copy, pixel_1_2_Black_Copy));
    List<List<IPixel>> image_3x2_pixels_Copy =
        new ArrayList<List<IPixel>>(
            Arrays.asList(image_3x2_first_row_Copy, image_3x2_second_row_Copy));
    IImage image_3_2_Copy = new ImageImpl(2, 3, image_3x2_pixels_Copy);
    assertTrue(image_3_2_Copy.equals(image_3x2));
  }

  @Test
  public void testEqualsDifferentObject() {
    IPixel pixel = new PixelImpl(0, 350, 0, 255, 4);
    assertFalse(image_3x2.equals(pixel));
  }


  @Test
  public void testEqualsDifferentHeight() {
    IPixel pixel_0_0_Red_Copy = new PixelImpl(0, 0, 255, 0, 0);
    IPixel pixel_0_1_Green_Copy = new PixelImpl(0, 1, 0, 255, 0);
    IPixel pixel_0_2_Blue_Copy = new PixelImpl(0, 2, 0, 0, 255);
    List<IPixel> image_3x1_first_row_Copy =
        new ArrayList<IPixel>(Arrays.asList(pixel_0_0_Red_Copy,
            pixel_0_1_Green_Copy, pixel_0_2_Blue_Copy));

    List<List<IPixel>> image_3x1_pixels_Copy =
        new ArrayList<List<IPixel>>(Arrays.asList(image_3x1_first_row_Copy));
    IImage image_3_1_Copy = new ImageImpl(1, 3, image_3x1_pixels_Copy);
    assertFalse(image_3_1_Copy.equals(image_3x2));
  }

  @Test
  public void testEqualsDifferentRed() {
    IPixel pixel_0_0_Red_Copy =
        new PixelImpl(0, 0, 255, 0, 0);
    IPixel pixel_0_1_Green_Copy =
        new PixelImpl(0, 1, 0, 255, 0);
    IPixel pixel_0_2_Blue_Copy =
        new PixelImpl(0, 2, 0, 0, 255);
    IPixel pixel_1_0_Yellow_Copy =
        new PixelImpl(1, 0, 255, 255, 0);
    IPixel pixel_1_1_White_Copy =
        new PixelImpl(1, 1, 255, 255, 255);
    IPixel pixel_1_2_Black_Copy =
        new PixelImpl(1, 2, 6, 0, 0);
    List<IPixel> image_3x2_first_row_Copy =
        new ArrayList<IPixel>(
            Arrays.asList(pixel_0_0_Red_Copy, pixel_0_1_Green_Copy, pixel_0_2_Blue_Copy));
    List<IPixel> image_3x2_second_row_Copy =
        new ArrayList<IPixel>(
            Arrays.asList(pixel_1_0_Yellow_Copy, pixel_1_1_White_Copy, pixel_1_2_Black_Copy));
    List<List<IPixel>> image_3x2_pixels_Copy =
        new ArrayList<List<IPixel>>(
            Arrays.asList(image_3x2_first_row_Copy, image_3x2_second_row_Copy));
    IImage image_3_2_CopyWithTinyChange = new ImageImpl(2, 3, image_3x2_pixels_Copy);
    assertFalse(image_3_2_CopyWithTinyChange.equals(image_3x2));
  }

  @Test
  public void testHashCode() {
    assertEquals(5046, image_3x2.hashCode());
  }

}
