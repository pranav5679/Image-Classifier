package model.imageexporter;


import java.awt.image.BufferedImage;
import model.image.IImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Class to export PPM images.
 */
public class PPMExporter implements ImageExporter {

  private final IImage image;

  /**
   * Constructs a ppm exporter with the given image.
   *
   * @param image the image that is going to exported in a ppm file
   */
  public PPMExporter(IImage image) {
    this.image = image;
  }

  @Override
  public File export(String string) {
    // File to make
    File fileToExport = new File(string);
    if (fileToExport.exists()) {
      throw new IllegalArgumentException("File already exists");
    }
    try {
      FileOutputStream fout = new FileOutputStream(fileToExport);
      String fileString = this.stringWriteToFile();
      byte[] b = fileString.getBytes();
      fout.write(b);
      fout.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Something went wrong");
    }
    return fileToExport;
  }

  @Override
  public String stringWriteToFile() {
    StringBuilder header = new StringBuilder("P3" + '\n' + this.image.getWidth() + " "
        + this.image.getHeight() + '\n' + (this.image.maxColor()));

    return header.append(this.image.toString() + '\n').toString();
  }

  public BufferedImage exportImage() {
    return null;
  }

}
