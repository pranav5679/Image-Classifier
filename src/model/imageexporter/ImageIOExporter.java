package model.imageexporter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import model.image.IImage;
import model.pixel.IPixel;

/**
 * Class that represents an image IO exporter.
 */
public class ImageIOExporter implements ImageExporter {

  private final IImage image;
  protected String format;

  /**
   * Constructs an image IO exporter with the given image.
   *
   * @param image the image that is going to be exported in a image IO file
   */
  public ImageIOExporter(IImage image) {
    this.image = image;
    this.format = "png";
  }

  @Override
  public File export(String string) {
    BufferedImage bufferedImage = exportImage();
    File fileToExport = new File(string);
    if (fileToExport.exists()) {
      throw new IllegalArgumentException("File already exists");
    }
    try {
      ImageIO.write(bufferedImage, this.format, fileToExport);
    } catch (IOException e) {
      throw new IllegalArgumentException("Something went wrong");
    }
    return fileToExport;
  }

  @Override
  public String stringWriteToFile() {
    return null;
  }

  @Override
  public BufferedImage exportImage() {
    int width = this.image.getWidth();
    int height = this.image.getHeight();
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
    List<List<IPixel>> pixels = this.image.getPixels();
    for (List<IPixel> row : pixels) {
      for (IPixel pixel : row) {
        int x = pixel.getColumnPosition();
        int y = pixel.getRowPosition();
        int rgb = (pixel.getChannel(0) << 16)  + (pixel.getChannel(1) << 8) + (pixel.getChannel(2));
        bufferedImage.setRGB(x, y, rgb);
      }
    }
    return bufferedImage;
  }
}
