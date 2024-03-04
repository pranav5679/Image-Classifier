import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.image.IImage;
import model.image.ImageImpl;
import model.imageexporter.ImageExporter;
import model.imageexporter.JPGImageIOExporter;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import org.junit.Test;

/**
 * Class to test PNGImageIOExporter methods.
 */
public class TestPNGImageIOExporter {

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

  // Here is a text to show that what we write to a file is correct.
  @Test
  public void testFileString() {
    ImageExporter exporter = new JPGImageIOExporter(new_image_3x2);
    assertEquals(null, exporter.stringWriteToFile());
  }
}
