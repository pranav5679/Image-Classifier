package model.imageexporter;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Interface for exporting images with different file types.
 */
public interface ImageExporter {

  /**
   * Creates a file to be exported.
   *
   * @param fileName Location/name of file
   * @return export file created
   */
  File export(String fileName);

  /**
   * Create string to write to file.
   *
   * @return string that can write to file
   */
  String stringWriteToFile();

  /**
   * Gets the image after building it from the pixel data.
   * @return a buffered version of this image
   */
  BufferedImage exportImage();
}
