package model.imageimporter;

/**
 * The representation of a importer factory.
 */
public class ImporterFactory {

  /**
   * Gets the correct importer for importing an image file.
   * @param filepath the filepath that can get the image
   * @param extension the extension that the image is associated with
   * @return the importer that can import the image
   */
  public static ImageImporter instantiate(String filepath, String extension) {
    ImageImporter importer = null;
    if (extension.compareTo("png") == 0) {
      importer = new ImageIOImporter(filepath, extension);
    } else if (extension.compareTo("jpg") == 0) {
      importer = new ImageIOImporter(filepath, extension);
    } else if (extension.compareTo("ppm") == 0) {
      importer = new PPMImporter(filepath, extension);
    }
    return importer;
  }
}
