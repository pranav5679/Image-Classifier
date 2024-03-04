import static org.junit.Assert.assertEquals;

import model.CheckerBoardCreator;
import model.SupportedColors;
import model.image.IImage;
import model.imageimporter.ImageIOImporter;
import model.imageimporter.ImageImporter;
import org.junit.Test;

/**
 * Class to test PNGImageIOImporter methods.
 */
public class TestPNGImageIOImporter {

  @Test
  public void testImportSucessfully() {
    ImageImporter importer = new ImageIOImporter("res/blackwhite.png", "png");
    CheckerBoardCreator checkerBoardCreator = new CheckerBoardCreator();
    IImage checkerboard = checkerBoardCreator.createCheckerBoard(2, 2, 2,
        SupportedColors.BLACK, SupportedColors.WHITE);
    assertEquals(checkerboard, importer.readFile());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCanNotFindFile() {
    ImageImporter importer = new ImageIOImporter("res/badfile.png", "png");
    IImage image = importer.readFile();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNotP3() {
    ImageImporter importer = new ImageIOImporter("res/blackwhitenotp3.png", "png");
    IImage image = importer.readFile();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooLargeMaxRGB() {
    ImageImporter importer = new ImageIOImporter("res/blackwhite256.png", "png");
    IImage image = importer.readFile();
  }
}
