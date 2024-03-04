import static org.junit.Assert.assertEquals;

import model.image.IImage;
import model.image.ImageImpl;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import model.transformation.GrayScaleImpl;
import model.transformation.ITransformation;
import model.transformation.SepiaToneImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Test for grayscaling an image.
 */
public class TestGrayScaleAndSepiaTone {

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


  @Test
  public void testGrayScale() {

    // Expected new image after multiplying each pixel by the gray scale matrix
    IPixel new_pixel_0_0_Red = new PixelImpl(0, 0,
        54, 54, 54);
    IPixel new_pixel_0_1_Green = new PixelImpl(0, 1,
        182, 182, 182);
    IPixel new_pixel_0_2_Blue = new PixelImpl(0, 2,
        18, 18, 18);
    IPixel new_pixel_1_0_Yellow = new PixelImpl(1, 0,
        237, 237, 237);
    IPixel new_pixel_1_1_White = new PixelImpl(1, 1,
        255, 255, 255);
    IPixel new_pixel_1_2_Black = new PixelImpl(1, 2,
        0, 0, 0);
    List<IPixel> new_image_3x2_first_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_0_0_Red,
            new_pixel_0_1_Green, new_pixel_0_2_Blue));
    List<IPixel> new_image_3x2_second_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_1_0_Yellow,
            new_pixel_1_1_White, new_pixel_1_2_Black));
    List<List<IPixel>> new_image_3x2_pixels =
        new ArrayList<List<IPixel>>(
            Arrays.asList(new_image_3x2_first_row, new_image_3x2_second_row));
    IImage new_image_3x2 = new ImageImpl(2, 3, new_image_3x2_pixels);

    ITransformation transformation = new GrayScaleImpl();

    assertEquals(new_image_3x2, transformation.applyTransformation(image_3x2));
  }

  @Test
  public void testSepiaTone() {

    // Expected new image after multiplying each pixel by the gray scale matrix
    IPixel new_pixel_0_0_Red = new PixelImpl(0, 0,
        100, 89, 69);
    IPixel new_pixel_0_1_Green = new PixelImpl(0, 1,
        196, 175, 136);
    IPixel new_pixel_0_2_Blue = new PixelImpl(0, 2,
        48, 43, 33);
    IPixel new_pixel_1_0_Yellow = new PixelImpl(1, 0,
        255, 255, 206);
    IPixel new_pixel_1_1_White = new PixelImpl(1, 1,
        255, 255, 239);
    IPixel new_pixel_1_2_Black = new PixelImpl(1, 2,
        0, 0, 0);
    List<IPixel> new_image_3x2_first_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_0_0_Red,
            new_pixel_0_1_Green, new_pixel_0_2_Blue));
    List<IPixel> new_image_3x2_second_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_1_0_Yellow,
            new_pixel_1_1_White, new_pixel_1_2_Black));
    List<List<IPixel>> new_image_3x2_pixels =
        new ArrayList<List<IPixel>>(
            Arrays.asList(new_image_3x2_first_row, new_image_3x2_second_row));
    IImage new_image_3x2 = new ImageImpl(2, 3, new_image_3x2_pixels);

    ITransformation transformation = new SepiaToneImpl();

    assertEquals(new_image_3x2, transformation.applyTransformation(image_3x2));
  }

  @Test(expected = NullPointerException.class)
  public void testNullImageGrayScale() {
    ITransformation transformation = new GrayScaleImpl();
    transformation.applyTransformation(null);
  }

  @Test(expected = NullPointerException.class)
  public void testNullImageSepiaTone() {
    ITransformation transformation = new SepiaToneImpl();
    transformation.applyTransformation(null);
  }
}
