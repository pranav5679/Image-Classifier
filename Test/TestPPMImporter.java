import static org.junit.Assert.assertEquals;

import model.CheckerBoardCreator;
import model.image.IImage;
import model.imageimporter.ImageImporter;
import model.imageimporter.PPMImporter;
import model.SupportedColors;
import org.junit.Test;

/**
 * Test for importing a ppm file.
 */
public class TestPPMImporter {


  @Test
  public void testImportSucessfully() {
    ImageImporter importer = new PPMImporter("res/blackwhite.ppm", "ppm");
    CheckerBoardCreator checkerBoardCreator = new CheckerBoardCreator();
    IImage checkerboard = checkerBoardCreator.createCheckerBoard(2, 2, 2,
        SupportedColors.BLACK, SupportedColors.WHITE);
    assertEquals(checkerboard, importer.readFile());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCanNotFindFile() {
    ImageImporter importer = new PPMImporter("res/badfile.ppm", "ppm");
    IImage image = importer.readFile();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNotP3() {
    ImageImporter importer = new PPMImporter("res/blackwhitenotp3.ppm", "ppm");
    IImage image = importer.readFile();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooLargeMaxRGB() {
    ImageImporter importer = new PPMImporter("res/blackwhite256.ppm", "ppm");
    IImage image = importer.readFile();
  }


}
