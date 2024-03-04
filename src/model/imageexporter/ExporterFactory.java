package model.imageexporter;

import model.image.IImage;

/**
 * The representation of an ExporterFactory.
 */
public class ExporterFactory {

  /**
   * Gets the correct type of exporter needed to export an image with an extension.
   * @param extension the file type that the image is going to be exported as
   * @param image the image that is going to be exported
   * @return the exporter that can export the image
   */
  public static ImageExporter instantiate(String extension, IImage image) {
    ImageExporter exporter = null;
    if (extension.compareTo("png") == 0) {
      exporter = new PNGImageIOExporter(image);
    } else if (extension.compareTo("jpg") == 0) {
      exporter = new JPGImageIOExporter(image);
    } else if (extension.compareTo("ppm") == 0) {
      exporter = new PPMExporter(image);
    }
    return exporter;
  }
}
