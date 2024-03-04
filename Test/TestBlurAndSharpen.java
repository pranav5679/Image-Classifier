import static org.junit.Assert.assertEquals;

import model.image.IImage;
import model.image.ImageImpl;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import model.transformation.BlurImpl;
import model.transformation.ITransformation;
import model.transformation.SharpenImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Class to test the ITransformations for filtering: blurring and sharpening images.
 */
public class TestBlurAndSharpen {

  IPixel pixel_0_0_Black =
      new PixelImpl(0, 0, 0, 0, 0);
  IPixel pixel_0_1_White =
      new PixelImpl(0, 1, 255, 255, 255);
  IPixel pixel_0_2_Gray =
      new PixelImpl(0, 2, 128, 128, 128);
  IPixel pixel_0_3_Red =
      new PixelImpl(0, 3, 255, 0, 0);
  IPixel pixel_1_0_Orange =
      new PixelImpl(1, 0, 255, 165, 0);
  IPixel pixel_1_1_Yellow =
      new PixelImpl(1, 1, 255, 255, 0);
  IPixel pixel_1_2_Green =
      new PixelImpl(1, 2, 0, 255, 0);
  IPixel pixel_1_3_Blue =
      new PixelImpl(1, 3, 0, 0, 255);
  IPixel pixel_2_0_Black =
      new PixelImpl(2, 0, 0, 0, 0);
  IPixel pixel_2_1_White =
      new PixelImpl(2, 1, 255, 255, 255);
  IPixel pixel_2_2_Gray =
      new PixelImpl(2, 2, 128, 128, 128);
  IPixel pixel_2_3_Red =
      new PixelImpl(2, 3, 255, 0, 0);
  IPixel pixel_3_0_Orange =
      new PixelImpl(3, 0, 255, 165, 0);
  IPixel pixel_3_1_Yellow =
      new PixelImpl(3, 1, 255, 255, 0);
  IPixel pixel_3_2_Green =
      new PixelImpl(3, 2, 0, 255, 0);
  IPixel pixel_3_3_Blue =
      new PixelImpl(3, 3, 0, 0, 255);

  List<IPixel> image_4x4_first_row =
      new ArrayList<IPixel>(Arrays.asList(pixel_0_0_Black, pixel_0_1_White,
          pixel_0_2_Gray, pixel_0_3_Red));
  List<IPixel> image_4x4_second_row =
      new ArrayList<IPixel>(Arrays.asList(pixel_1_0_Orange, pixel_1_1_Yellow,
          pixel_1_2_Green, pixel_1_3_Blue));
  List<IPixel> image_4x4_third_row =
      new ArrayList<IPixel>(Arrays.asList(pixel_2_0_Black, pixel_2_1_White,
          pixel_2_2_Gray, pixel_2_3_Red));
  List<IPixel> image_4x4_fourth_row =
      new ArrayList<IPixel>(Arrays.asList(pixel_3_0_Orange, pixel_3_1_Yellow,
          pixel_3_2_Green, pixel_3_3_Blue));
  List<List<IPixel>> image_4x4_pixels =
      new ArrayList<List<IPixel>>(Arrays.asList(image_4x4_first_row, image_4x4_second_row,
          image_4x4_third_row, image_4x4_fourth_row));
  IImage image_4x4 = new ImageImpl(4, 4, image_4x4_pixels);

  @Test(expected = NullPointerException.class)
  public void testNullImageBlur() {
    ITransformation transformation = new BlurImpl();
    transformation.applyTransformation(null);
  }

  @Test(expected = NullPointerException.class)
  public void testNullImageSharpen() {
    ITransformation transformation = new SharpenImpl();
    transformation.applyTransformation(null);
  }

  @Test
  public void testBlurImage() {
    IPixel new_pixel_0_0_Black =
        new PixelImpl(0, 0, 80, 68, 32);
    IPixel new_pixel_0_1_White =
        new PixelImpl(0, 1, 128, 138, 80);
    IPixel new_pixel_0_2_Gray =
        new PixelImpl(0, 2, 112, 112, 80);
    IPixel new_pixel_0_3_Red =
        new PixelImpl(0, 3, 80, 32, 48);
    IPixel new_pixel_1_0_Orange =
        new PixelImpl(1, 0, 128, 105, 32);
    IPixel new_pixel_1_1_Yellow =
        new PixelImpl(1, 1, 175, 196, 80);
    IPixel new_pixel_1_2_Green =
        new PixelImpl(1, 2, 128, 160, 96);
    IPixel new_pixel_1_3_Blue =
        new PixelImpl(1, 3, 80, 48, 80);
    IPixel new_pixel_2_0_Black =
        new PixelImpl(2, 0, 128, 105, 32);
    IPixel new_pixel_2_1_White =
        new PixelImpl(2, 1, 175, 196, 80);
    IPixel new_pixel_2_2_Gray =
        new PixelImpl(2, 2, 128, 160, 96);
    IPixel new_pixel_2_3_Red =
        new PixelImpl(2, 3, 80, 48, 80);
    IPixel new_pixel_3_0_Orange =
        new PixelImpl(3, 0, 112, 89, 16);
    IPixel new_pixel_3_1_Yellow =
        new PixelImpl(3, 1, 136, 156, 40);
    IPixel new_pixel_3_2_Green =
        new PixelImpl(3, 2, 80, 128, 64);
    IPixel new_pixel_3_3_Blue =
        new PixelImpl(3, 3, 40, 40, 72);

    List<IPixel> new_image_4x4_first_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_0_0_Black, new_pixel_0_1_White,
            new_pixel_0_2_Gray, new_pixel_0_3_Red));
    List<IPixel> new_image_4x4_second_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_1_0_Orange, new_pixel_1_1_Yellow,
            new_pixel_1_2_Green, new_pixel_1_3_Blue));
    List<IPixel> new_image_4x4_third_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_2_0_Black, new_pixel_2_1_White,
            new_pixel_2_2_Gray, new_pixel_2_3_Red));
    List<IPixel> new_image_4x4_fourth_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_3_0_Orange, new_pixel_3_1_Yellow,
            new_pixel_3_2_Green, new_pixel_3_3_Blue));
    List<List<IPixel>> new_image_4x4_pixels =
        new ArrayList<List<IPixel>>(Arrays.asList(new_image_4x4_first_row, new_image_4x4_second_row,
            new_image_4x4_third_row, new_image_4x4_fourth_row));
    IImage new_image_4x4 = new ImageImpl(4, 4, new_image_4x4_pixels);
    ITransformation transformation = new BlurImpl();
    assertEquals(new_image_4x4, transformation.applyTransformation(image_4x4));

  }

  @Test
  public void testSharpenImage() {
    IPixel new_pixel_0_0_Black =
        new PixelImpl(0, 0, 127, 73, 0);
    IPixel new_pixel_0_1_White =
        new PixelImpl(0, 1, 255, 255, 207);
    IPixel new_pixel_0_2_Gray =
        new PixelImpl(0, 2, 208, 251, 208);
    IPixel new_pixel_0_3_Red =
        new PixelImpl(0, 3, 144, 0, 16);
    IPixel new_pixel_1_0_Orange =
        new PixelImpl(1, 0, 255, 208, 96);
    IPixel new_pixel_1_1_Yellow =
        new PixelImpl(1, 1, 255, 255, 128);
    IPixel new_pixel_1_2_Green =
        new PixelImpl(1, 2, 255, 255, 223);
    IPixel new_pixel_1_3_Blue =
        new PixelImpl(1, 3, 64, 0, 223);
    IPixel new_pixel_2_0_Black =
        new PixelImpl(2, 0, 255, 146, 0);
    IPixel new_pixel_2_1_White =
        new PixelImpl(2, 1, 255, 255, 175);
    IPixel new_pixel_2_2_Gray =
        new PixelImpl(2, 2, 240, 255, 255);
    IPixel new_pixel_2_3_Red =
        new PixelImpl(2, 3, 112, 16, 80);
    IPixel new_pixel_3_0_Orange =
        new PixelImpl(3, 0, 255, 160, 48);
    IPixel new_pixel_3_1_Yellow =
        new PixelImpl(3, 1, 255, 255, 32);
    IPixel new_pixel_3_2_Green =
        new PixelImpl(3, 2, 128, 255, 128);
    IPixel new_pixel_3_3_Blue =
        new PixelImpl(3, 3, 0, 0, 223);

    List<IPixel> new_image_4x4_first_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_0_0_Black, new_pixel_0_1_White,
            new_pixel_0_2_Gray, new_pixel_0_3_Red));
    List<IPixel> new_image_4x4_second_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_1_0_Orange, new_pixel_1_1_Yellow,
            new_pixel_1_2_Green, new_pixel_1_3_Blue));
    List<IPixel> new_image_4x4_third_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_2_0_Black, new_pixel_2_1_White,
            new_pixel_2_2_Gray, new_pixel_2_3_Red));
    List<IPixel> new_image_4x4_fourth_row =
        new ArrayList<IPixel>(Arrays.asList(new_pixel_3_0_Orange, new_pixel_3_1_Yellow,
            new_pixel_3_2_Green, new_pixel_3_3_Blue));
    List<List<IPixel>> new_image_4x4_pixels =
        new ArrayList<List<IPixel>>(Arrays.asList(new_image_4x4_first_row, new_image_4x4_second_row,
            new_image_4x4_third_row, new_image_4x4_fourth_row));
    IImage new_image_4x4 = new ImageImpl(4, 4, new_image_4x4_pixels);
    ITransformation transformation = new SharpenImpl();
    assertEquals(new_image_4x4, transformation.applyTransformation(image_4x4));
  }
}
