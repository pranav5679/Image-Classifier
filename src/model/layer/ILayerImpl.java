package model.layer;

import java.util.List;
import model.image.IImage;
import model.pixel.IPixel;
import model.pixel.PixelImpl;

/**
 * Represents an implementation of a Layer.
 */
public class ILayerImpl implements ILayer {
  IImage image;
  boolean isOn;

  /**
   * Constructs an default implementation of a Layer.
   */
  public ILayerImpl() {
    this.image = null;
    this.isOn = true;
  }

  /**
   * Constructs a Layer with a white-out image.
   * @param image the image that is being whited out
   */
  public ILayerImpl(IImage image) {
    List<List<IPixel>> pixels;
    pixels = image.getPixels();
    int i = 0;
    int j = 0;
    for (i = 0; i < pixels.size(); i++) {
      List<IPixel> rowOfPixels = pixels.get(i);
      for (j = 0; i < rowOfPixels.size(); j++) {
        IPixel pixel = rowOfPixels.get(j);
        pixel = new PixelImpl(i, j, 0, 0, 0);
      }
    }
    //apply the white pixels into this image
    this.image = image;
    this.isOn = true;
  }

  @Override
  public void turnOnLayer() {
    this.isOn = true;
  }

  @Override
  public void turnOffLayer() {
    this.isOn = false;
  }

  @Override
  public void addImageToLayer(IImage image) {
    this.image = image;
  }

  @Override
  public void setImage(IImage image) {
    this.image = image;
  }

  @Override
  public IImage getImage() {
    return image;
  }

  @Override
  public boolean getVisibility() {
    return isOn;
  }

}
