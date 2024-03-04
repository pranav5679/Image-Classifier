package model.imageimporter;

import model.image.IImage;
import model.image.ImageImpl;
import model.pixel.IPixel;
import model.pixel.PixelImpl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class to read ppm files.
 */
public class PPMImporter implements ImageImporter {

  private final String filepath;

  /**
   * Constructs a PPMManager from the string of the file.
   *
   * @param filepath String of the filepath
   */
  public PPMImporter(String filepath, String extension) {
    this.filepath = Objects.requireNonNull(filepath);
  }

  @Override
  public IImage readFile() {

    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filepath));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found!");
    }

    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!(token.equals("P3"))) {
      throw new IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
    }

    int width = sc.nextInt();

    int height = sc.nextInt();

    int maxValue = sc.nextInt();

    if (maxValue > 255) {
      throw new IllegalArgumentException("Max value is higher than 255!");
    }

    List<List<IPixel>> pixelList = new ArrayList<List<IPixel>>();

    for (int i = 0; i < height; i++) {
      List<IPixel> pixelRow = new ArrayList<IPixel>();
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        pixelRow.add(new PixelImpl(i,
            j, r, g, b));
      }
      pixelList.add(pixelRow);
    }
    return new ImageImpl(height, width, pixelList);
  }

}



