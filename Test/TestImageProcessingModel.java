import static org.junit.Assert.assertEquals;

import model.image.IImage;
import model.image.ImageImpl;
import model.imageprocessing.ImageProcessing;
import model.imageprocessing.ImageProcessingModel;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import model.transformation.BlurImpl;
import model.transformation.GrayScaleImpl;
import model.transformation.ITransformation;
import model.transformation.SepiaToneImpl;
import model.transformation.SharpenImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test ImageProcessingModel Methods.
 */
public class TestImageProcessingModel {

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


  ImageProcessing model;

  @Before
  public void setUp() {
    model = new ImageProcessingModel();
  }

  @Test(expected = NullPointerException.class)
  public void testNullMap() {
    ImageProcessing modelNull = new ImageProcessingModel(null);
  }

  @Test(expected = NullPointerException.class)
  public void testAddImageNullKey() {
    model.addImage(null, image_4x4);
  }

  @Test(expected = NullPointerException.class)
  public void testAddImageNullImage() {
    model.addImage("image of eight colors", null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddImageKeyUsed() {

    model.addImage("image of six color", image_3x2);
    model.addImage("image of six color", image_4x4);
  }

  @Test
  public void testAddImage() {
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
        new ArrayList<IPixel>(
            Arrays.asList(pixel_0_0_Red_Copy, pixel_0_1_Green_Copy, pixel_0_2_Blue_Copy));
    List<IPixel> image_3x2_second_row_Copy =
        new ArrayList<IPixel>(
            Arrays.asList(pixel_1_0_Yellow_Copy, pixel_1_1_White_Copy, pixel_1_2_Black_Copy));
    List<List<IPixel>> image_3x2_pixels_Copy =
        new ArrayList<List<IPixel>>(
            Arrays.asList(image_3x2_first_row_Copy, image_3x2_second_row_Copy));
    IImage image_3_2_Copy = new ImageImpl(2, 3, image_3x2_pixels_Copy);

    model.addImage("image of six colors", image_3x2);
    assertEquals(image_3_2_Copy, model.getImage("image of six colors"));
  }

  @Test(expected = NullPointerException.class)
  public void testRemoveImageNullKey() {
    model.removeImage(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveImageKeyNotInModel() {
    model.removeImage("hey");
  }

  @Test
  public void testRemoveImage() {
    model.addImage("image with eight colors", image_4x4);
    model.removeImage("image with eight colors");
    try {
      model.getImage("image with eight colors");
    } catch (IllegalArgumentException e) {
      assertEquals("Does not have image associated with key.", e.getMessage());
    }
  }

  @Test(expected = NullPointerException.class)
  public void testGetImageNullKey() {
    model.getImage(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetImageKeyNotInModel() {
    model.getImage("hey");
  }

  @Test
  public void testGetImage() {
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
        new ArrayList<IPixel>(
            Arrays.asList(pixel_0_0_Red_Copy, pixel_0_1_Green_Copy, pixel_0_2_Blue_Copy));
    List<IPixel> image_3x2_second_row_Copy =
        new ArrayList<IPixel>(
            Arrays.asList(pixel_1_0_Yellow_Copy, pixel_1_1_White_Copy, pixel_1_2_Black_Copy));
    List<List<IPixel>> image_3x2_pixels_Copy =
        new ArrayList<List<IPixel>>(
            Arrays.asList(image_3x2_first_row_Copy, image_3x2_second_row_Copy));
    IImage image_3_2_Copy = new ImageImpl(2, 3, image_3x2_pixels_Copy);

    model.addImage("image of six colors", image_3x2);
    assertEquals(image_3_2_Copy, model.getImage("image of six colors"));
  }

  @Test(expected = NullPointerException.class)
  public void testReplaceImageNull() {
    model.replaceImage(null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testReplaceImageKeyNotInModel() {
    model.replaceImage("hey", image_4x4);
  }

  @Test
  public void testReplaceImage() {
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
        new ArrayList<IPixel>(
            Arrays.asList(pixel_0_0_Red_Copy, pixel_0_1_Green_Copy, pixel_0_2_Blue_Copy));
    List<IPixel> image_3x2_second_row_Copy =
        new ArrayList<IPixel>(
            Arrays.asList(pixel_1_0_Yellow_Copy, pixel_1_1_White_Copy, pixel_1_2_Black_Copy));
    List<List<IPixel>> image_3x2_pixels_Copy =
        new ArrayList<List<IPixel>>(
            Arrays.asList(image_3x2_first_row_Copy, image_3x2_second_row_Copy));
    IImage image_3_2_Copy = new ImageImpl(2, 3, image_3x2_pixels_Copy);
    model.addImage("image of six colors", image_4x4);
    model.replaceImage("image of six colors", image_3x2);
    assertEquals(image_3_2_Copy, model.getImage("image of six colors"));
  }

  @Test(expected = NullPointerException.class)
  public void testGetHeightImageNull() {
    model.getImageHeight(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetHeightImageKeyNotInModel() {
    model.getImageHeight("hey");
  }

  @Test
  public void testGetHeight() {
    model.addImage("image of six colors", image_3x2);
    assertEquals(2, model.getImageHeight("image of six colors"));
  }

  @Test(expected = NullPointerException.class)
  public void testGetWidthImageNull() {
    model.getImageWidth(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetWidthImageKeyNotInModel() {
    model.getImageWidth("hey");
  }

  @Test
  public void testGetWidth() {
    model.addImage("image of six colors", image_3x2);
    assertEquals(3, model.getImageWidth("image of six colors"));
  }

  @Test(expected = NullPointerException.class)
  public void testGetPixelsNumberImageNull() {
    model.getNumberOfPixels(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetPixelsNumberImageKeyNotInModel() {
    model.getNumberOfPixels("hey");
  }

  @Test
  public void testGetNumberOfPixels() {
    model.addImage("image of six colors", image_3x2);
    assertEquals(6, model.getNumberOfPixels("image of six colors"));
  }

  @Test(expected = NullPointerException.class)
  public void testGetMaxRGBImageNull() {
    model.getMaxRGB(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetMaxRGBImageKeyNotInModel() {
    model.getMaxRGB("hey");
  }

  @Test
  public void testGetMaxRGB() {
    model.addImage("image of six colors", image_3x2);
    assertEquals(255, model.getMaxRGB("image of six colors"));
  }

  @Test(expected = NullPointerException.class)
  public void testApplyTransformationNull() {
    model.applyTransformation(null, null);
  }

  @Test
  public void testApplyTransformationBlur() {
    model.addImage("blur", image_4x4);
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
    assertEquals(new_image_4x4, model.applyTransformation("blur", transformation));
  }

  @Test
  public void testApplyTransformationSharpen() {
    model.addImage("sharpen", image_4x4);
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
    assertEquals(new_image_4x4, model.applyTransformation("sharpen", transformation));
  }

  @Test
  public void testApplyTransformationGrayScale() {
    model.addImage("gray", image_3x2);
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
    assertEquals(new_image_3x2, model.applyTransformation("gray", transformation));
  }

  @Test
  public void testApplyTransformationSepiaTone() {
    model.addImage("sepia", image_3x2);
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
    assertEquals(new_image_3x2, model.applyTransformation("sepia", transformation));
  }


}
