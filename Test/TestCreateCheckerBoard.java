import static org.junit.Assert.assertEquals;

import model.CheckerBoardCreator;
import model.image.IImage;
import model.image.ImageImpl;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import model.SupportedColors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Class to test test checker board creator.
 */
public class TestCreateCheckerBoard {

  CheckerBoardCreator creator = new CheckerBoardCreator();

  @Test(expected = NullPointerException.class)
  public void testNullColors() {
    creator.createCheckerBoard(1, 1, 1, null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLessThanOneSizeOfSquare() {
    creator.createCheckerBoard(0, 1, 1,
        SupportedColors.WHITE, SupportedColors.BLUE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLessThanOneRow() {
    creator.createCheckerBoard(1, 0, 1,
        SupportedColors.WHITE, SupportedColors.BLUE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLessThanOneColumn() {
    creator.createCheckerBoard(0, 1, 1,
        SupportedColors.WHITE, SupportedColors.BLUE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSameColor() {
    creator.createCheckerBoard(1, 1, 1,
        SupportedColors.BLACK, SupportedColors.BLACK);
  }

  @Test
  public void testCreateCheckerBoard() {
    IPixel pixel_0_0 =
        new PixelImpl(0, 0, 0, 0, 0);
    IPixel pixel_0_1 =
        new PixelImpl(0, 1, 0, 0, 0);
    IPixel pixel_0_2 =
        new PixelImpl(0, 2, 255, 255, 255);
    IPixel pixel_0_3 =
        new PixelImpl(0, 3, 255, 255, 255);
    IPixel pixel_0_4 =
        new PixelImpl(0, 4, 0, 0, 0);
    IPixel pixel_0_5 =
        new PixelImpl(0, 5, 0, 0, 0);
    IPixel pixel_0_6 =
        new PixelImpl(0, 6, 255, 255, 255);
    IPixel pixel_0_7 =
        new PixelImpl(0, 7, 255, 255, 255);

    IPixel pixel_1_0 =
        new PixelImpl(1, 0, 0, 0, 0);
    IPixel pixel_1_1 =
        new PixelImpl(1, 1, 0, 0, 0);
    IPixel pixel_1_2 =
        new PixelImpl(1, 2, 255, 255, 255);
    IPixel pixel_1_3 =
        new PixelImpl(1, 3, 255, 255, 255);
    IPixel pixel_1_4 =
        new PixelImpl(1, 4, 0, 0, 0);
    IPixel pixel_1_5 =
        new PixelImpl(1, 5, 0, 0, 0);
    IPixel pixel_1_6 =
        new PixelImpl(1, 6, 255, 255, 255);
    IPixel pixel_1_7 =
        new PixelImpl(1, 7, 255, 255, 255);

    IPixel pixel_2_0 =
        new PixelImpl(2, 0, 255, 255, 255);
    IPixel pixel_2_1 =
        new PixelImpl(2, 1, 255, 255, 255);
    IPixel pixel_2_2 =
        new PixelImpl(2, 2, 0, 0, 0);
    IPixel pixel_2_3 =
        new PixelImpl(2, 3, 0, 0, 0);
    IPixel pixel_2_4 =
        new PixelImpl(2, 4, 255, 255, 255);
    IPixel pixel_2_5 =
        new PixelImpl(2, 5, 255, 255, 255);
    IPixel pixel_2_6 =
        new PixelImpl(2, 6, 0, 0, 0);
    IPixel pixel_2_7 =
        new PixelImpl(2, 7, 0, 0, 0);

    IPixel pixel_3_0 =
        new PixelImpl(3, 0, 255, 255, 255);
    IPixel pixel_3_1 =
        new PixelImpl(3, 1, 255, 255, 255);
    IPixel pixel_3_2 =
        new PixelImpl(3, 2, 0, 0, 0);
    IPixel pixel_3_3 =
        new PixelImpl(3, 3, 0, 0, 0);
    IPixel pixel_3_4 =
        new PixelImpl(3, 4, 255, 255, 255);
    IPixel pixel_3_5 =
        new PixelImpl(3, 5, 255, 255, 255);
    IPixel pixel_3_6 =
        new PixelImpl(3, 6, 0, 0, 0);
    IPixel pixel_3_7 =
        new PixelImpl(3, 7, 0, 0, 0);

    IPixel pixel_4_0 =
        new PixelImpl(4, 0, 0, 0, 0);
    IPixel pixel_4_1 =
        new PixelImpl(4, 1, 0, 0, 0);
    IPixel pixel_4_2 =
        new PixelImpl(4, 2, 255, 255, 255);
    IPixel pixel_4_3 =
        new PixelImpl(4, 3, 255, 255, 255);
    IPixel pixel_4_4 =
        new PixelImpl(4, 4, 0, 0, 0);
    IPixel pixel_4_5 =
        new PixelImpl(4, 5, 0, 0, 0);
    IPixel pixel_4_6 =
        new PixelImpl(4, 6, 255, 255, 255);
    IPixel pixel_4_7 =
        new PixelImpl(4, 7, 255, 255, 255);

    IPixel pixel_5_0 =
        new PixelImpl(5, 0, 0, 0, 0);
    IPixel pixel_5_1 =
        new PixelImpl(5, 1, 0, 0, 0);
    IPixel pixel_5_2 =
        new PixelImpl(5, 2, 255, 255, 255);
    IPixel pixel_5_3 =
        new PixelImpl(5, 3, 255, 255, 255);
    IPixel pixel_5_4 =
        new PixelImpl(5, 4, 0, 0, 0);
    IPixel pixel_5_5 =
        new PixelImpl(5, 5, 0, 0, 0);
    IPixel pixel_5_6 =
        new PixelImpl(5, 6, 255, 255, 255);
    IPixel pixel_5_7 =
        new PixelImpl(5, 7, 255, 255, 255);

    IPixel pixel_6_0 =
        new PixelImpl(6, 0, 255, 255, 255);
    IPixel pixel_6_1 =
        new PixelImpl(6, 1, 255, 255, 255);
    IPixel pixel_6_2 =
        new PixelImpl(6, 2, 0, 0, 0);
    IPixel pixel_6_3 =
        new PixelImpl(6, 3, 0, 0, 0);
    IPixel pixel_6_4 =
        new PixelImpl(6, 4, 255, 255, 255);
    IPixel pixel_6_5 =
        new PixelImpl(6, 5, 255, 255, 255);
    IPixel pixel_6_6 =
        new PixelImpl(6, 6, 0, 0, 0);
    IPixel pixel_6_7 =
        new PixelImpl(6, 7, 0, 0, 0);

    IPixel pixel_7_0 =
        new PixelImpl(7, 0, 255, 255, 255);
    IPixel pixel_7_1 =
        new PixelImpl(7, 1, 255, 255, 255);
    IPixel pixel_7_2 =
        new PixelImpl(7, 2, 0, 0, 0);
    IPixel pixel_7_3 =
        new PixelImpl(7, 3, 0, 0, 0);
    IPixel pixel_7_4 =
        new PixelImpl(7, 4, 255, 255, 255);
    IPixel pixel_7_5 =
        new PixelImpl(7, 5, 255, 255, 255);
    IPixel pixel_7_6 =
        new PixelImpl(7, 6, 0, 0, 0);
    IPixel pixel_7_7 =
        new PixelImpl(7, 7, 0, 0, 0);

    List<IPixel> first_row =
        new ArrayList<IPixel>(Arrays.asList(pixel_0_0, pixel_0_1, pixel_0_2, pixel_0_3,
            pixel_0_4, pixel_0_5, pixel_0_6, pixel_0_7));
    List<IPixel> second_row =
        new ArrayList<IPixel>(Arrays.asList(pixel_1_0, pixel_1_1, pixel_1_2, pixel_1_3,
            pixel_1_4, pixel_1_5, pixel_1_6, pixel_1_7));
    List<IPixel> third_row =
        new ArrayList<IPixel>(Arrays.asList(pixel_2_0, pixel_2_1, pixel_2_2, pixel_2_3,
            pixel_2_4, pixel_2_5, pixel_2_6, pixel_2_7));
    List<IPixel> fourth_row =
        new ArrayList<IPixel>(Arrays.asList(pixel_3_0, pixel_3_1, pixel_3_2, pixel_3_3,
            pixel_3_4, pixel_3_5, pixel_3_6, pixel_3_7));
    List<IPixel> fifth_row =
        new ArrayList<IPixel>(Arrays.asList(pixel_4_0, pixel_4_1, pixel_4_2, pixel_4_3,
            pixel_4_4, pixel_4_5, pixel_4_6, pixel_4_7));
    List<IPixel> sixth_row =
        new ArrayList<IPixel>(Arrays.asList(pixel_5_0, pixel_5_1, pixel_5_2, pixel_5_3,
            pixel_5_4, pixel_5_5, pixel_5_6, pixel_5_7));
    List<IPixel> seventh_row =
        new ArrayList<IPixel>(Arrays.asList(pixel_6_0, pixel_6_1, pixel_6_2, pixel_6_3,
            pixel_6_4, pixel_6_5, pixel_6_6, pixel_6_7));
    List<IPixel> eighth_row =
        new ArrayList<IPixel>(Arrays.asList(pixel_7_0, pixel_7_1, pixel_7_2, pixel_7_3,
            pixel_7_4, pixel_7_5, pixel_7_6, pixel_7_7));
    List<List<IPixel>> image_8x8_pixels =
        new ArrayList<List<IPixel>>(Arrays.asList(first_row, second_row,
            third_row, fourth_row, fifth_row, sixth_row,
            seventh_row, eighth_row));
    IImage image_4x4 = new ImageImpl(8, 8, image_8x8_pixels);
    IImage image = creator.createCheckerBoard(2, 4, 4,
        SupportedColors.BLACK, SupportedColors.WHITE);

    assertEquals(image_4x4, image);

  }


}
