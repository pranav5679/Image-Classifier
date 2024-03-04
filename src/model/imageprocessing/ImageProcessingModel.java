package model.imageprocessing;

import model.image.IImage;
import model.image.ImageImpl;
import model.transformation.ITransformation;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Model for image processing using a hashmap to map strings to images.
 */
public class ImageProcessingModel implements ImageProcessing {

  protected final Map<String, IImage> images;

  /**
   * Constructs an ImageProcessingModel with a hashmap of strings to images.
   */
  public ImageProcessingModel() {
    this.images = new HashMap<String, IImage>();
  }

  /**
   * Constructs an ImageProcessingModel from a map.
   */
  public ImageProcessingModel(Map map) {
    this.images = Objects.requireNonNull(map);
  }


  @Override
  public void addImage(String key, IImage image) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(image);

    if (images.containsKey(key)) {
      throw new IllegalArgumentException("Already have image associated with the key");
    }
    // Put the image in the hashmap associated with the given key
    images.put(key, image);
  }

  @Override
  public void removeImage(String key) {
    Objects.requireNonNull(key);

    if (!images.containsKey(key)) {
      throw new IllegalArgumentException("Does not have image associated with key.");
    }

    images.remove(key);
  }

  @Override
  public IImage getImage(String key) {
    Objects.requireNonNull(key);
    if (!images.containsKey(key)) {
      throw new IllegalArgumentException("Does not have image associated with key.");
    }

    // Return a copy of the image not the actual image.
    IImage image = images.get(key);
    return new ImageImpl(image.getHeight(), image.getWidth(), image.getPixels());
  }

  @Override
  public void replaceImage(String key, IImage image) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(image);
    if (!images.containsKey(key)) {
      throw new IllegalArgumentException("Does not have image associated with key.");
    }
    images.replace(key, image);
  }

  @Override
  public int getImageHeight(String key) {
    Objects.requireNonNull(key);
    if (!images.containsKey(key)) {
      throw new IllegalArgumentException("Does not have image associated with key.");
    }
    return images.get(key).getHeight();
  }

  @Override
  public int getImageWidth(String key) {
    Objects.requireNonNull(key);
    if (!images.containsKey(key)) {
      throw new IllegalArgumentException("Does not have image associated with key.");
    }
    return images.get(key).getWidth();
  }

  @Override
  public int getNumberOfPixels(String key) {
    Objects.requireNonNull(key);
    if (!images.containsKey(key)) {
      throw new IllegalArgumentException("Does not have image associated with key.");
    }
    IImage image = images.get(key);
    return image.getHeight() * image.getWidth();
  }

  @Override
  public int getMaxRGB(String key) {
    Objects.requireNonNull(key);
    if (!images.containsKey(key)) {
      throw new IllegalArgumentException("Does not have image associated with key.");
    }
    return images.get(key).maxColor();
  }

  @Override
  public IImage applyTransformation(String key, ITransformation transformation) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(transformation);
    return transformation.applyTransformation(this.getImage(key));
  }
}
