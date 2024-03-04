package model.imageexporter;

import model.image.IImage;

/**
 * The representation of a png exporter.
 */
public class PNGImageIOExporter extends ImageIOExporter {

  /**
   * Constructs an exporter for images with a png extension.
   * @param image the image that is being exported
   */
  public PNGImageIOExporter(IImage image) {
    super(image);
    format = "png";
  }

}
