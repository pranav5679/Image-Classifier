package model.imageexporter;

import model.image.IImage;

/**
 * The representation of a jpg exporter.
 */
public class JPGImageIOExporter extends ImageIOExporter {

  /**
   * Constructs an exporter for images with a jpg extension.
   * @param image the image that is being exported
   */
  public JPGImageIOExporter(IImage image) {
    super(image);
    format = "jpg";
  }
}
