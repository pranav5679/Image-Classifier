package model.imageimporter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;
import model.image.IImage;
import model.image.ImageImpl;
import model.pixel.IPixel;
import model.pixel.PixelImpl;

/**
 * Class that represents an image IO importer.
 */
public class ImageIOImporter implements ImageImporter {

  private final String filepath;

  /**
   * Constructs a ImageIOManager from the string of the file.
   *
   * @param filepath String of the filepath
   */
  public ImageIOImporter(String filepath, String extension) {
    this.filepath = Objects.requireNonNull(filepath);
  }

  /**
   * Extracts the image from a file.
   * @return the image contained in the file
   */
  public IImage readFile() {
    BufferedImage bufferedImage = null;
    IImage image = null;
    Color color = null;
    int colors = 0;
    int width = 0;
    int height = 0;
    try {
      File imagefile = new File(filepath);
      bufferedImage = ImageIO.read(imagefile);
      width = bufferedImage.getWidth();
      height = bufferedImage.getHeight();

      List<List<IPixel>> pixelList = new ArrayList<List<IPixel>>();

      for (int i = 0; i < height; i++) {
        List<IPixel> pixelRow = new ArrayList<IPixel>();
        for (int j = 0; j < width; j++) {
          colors = bufferedImage.getRGB(j, i);
          color = new Color(colors);
          pixelRow.add(new PixelImpl(i,
              j, color.getRed(), color.getGreen(), color.getBlue()));
        }
        pixelList.add(pixelRow);
      }
      image = new ImageImpl(height, width, pixelList);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return image;
  }
}
