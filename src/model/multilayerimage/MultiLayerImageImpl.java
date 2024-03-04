package model.multilayerimage;

import java.awt.image.BufferedImage;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;
import model.layer.ILayer;
import model.layer.ILayerImpl;
import model.image.IImage;
import model.imageexporter.ExporterFactory;
import model.imageexporter.ImageExporter;
import model.imageimporter.ImageImporter;
import model.imageimporter.ImporterFactory;
import model.imageprocessing.ImageProcessing;
import model.imageprocessing.ImageProcessingModel;
import model.transformation.BlurImpl;
import model.transformation.GrayScaleImpl;
import model.transformation.ITransformation;
import model.transformation.SepiaToneImpl;
import model.transformation.SharpenImpl;

/**
 * The representation of a multilayer image.
 */
public class MultiLayerImageImpl implements IMultiLayerImage {
  private SortedMap<Integer, ILayer> layers;
  private int currentLayer;
  private int width;
  private int height;

  /**
   * Constructs a default version of the multilayer image.
   */
  public MultiLayerImageImpl() {
    this.layers = new TreeMap<Integer, ILayer>();
    this.currentLayer = 0;
    this.width = 0;
    this.height = 0;
  }

  /**
   * Constructs a version of the multilayer image that already have layers.
   * @param layers the layers that make up the image
   */
  public MultiLayerImageImpl(SortedMap<Integer, ILayer> layers) {
    this.layers = layers;
    this.currentLayer = 0;
    this.width = 0;
    this.height = 0;
  }

  @Override
  public int getCurrentID() {
    return this.currentLayer;
  }

  /**
   * Asserts that the add layer piece of the load action event is successful.
   * @return the boolean value of the success of this component
   */
  public boolean addLayer() {
    Integer lastKey = null;
    boolean success = false;
    try {
      lastKey = this.layers.lastKey();
    }
    catch (NoSuchElementException e) {
      lastKey = Integer.valueOf(1);
    }
    success = addLayer(lastKey.intValue() + 1);
    if (success) {
      currentLayer = lastKey.intValue() + 1;
    }
    return success;
  }

  @Override
  public boolean addLayer(int id) {
    boolean success = false;
    ILayer layer = null;
    layer = this.layers.get(Integer.valueOf(id));
    if (layer == null) {
      layer = new ILayerImpl();
      this.layers.put(Integer.valueOf(id), layer);
      success = true;
    }
    return success;
  }

  @Override
  public boolean removeLayer(int id) {
    boolean success = false;
    ILayer layer = null;
    layer = this.layers.get(Integer.valueOf(id));
    if (layer != null) {
      if (id == this.currentLayer) {
        this.currentLayer = 0;
      }
      this.layers.remove(Integer.valueOf(id));
      success = true;
    }
    return success;
  }

  @Override
  public boolean setCurrent(int id) {
    boolean success = false;
    ILayer layer = null;
    layer = this.layers.get(Integer.valueOf(id));
    if (layer != null) {
      this.currentLayer = id;
      layer.turnOnLayer();
      success = true;
    }
    return success;
  }

  @Override
  public boolean setInvisible(int id) {
    boolean success = false;
    ILayer layer = null;
    layer = this.layers.get(Integer.valueOf(id));
    if (layer != null) {
      if (id == this.currentLayer) {
        this.currentLayer = 0;
      }
      layer.turnOffLayer();
      success = true;
    }
    return success;
  }

  private ILayer getCurrentLayer() {
    ILayer layer = null;
    layer = this.layers.get(currentLayer);
    return layer;
  }

  private String getExtension(String filepath) {
    String extension = null;
    int lastIndex = -1;
    lastIndex = filepath.lastIndexOf('.');
    if (lastIndex != -1) {
      extension = filepath.substring(lastIndex + 1);
    }
    return extension;
  }

  private IImage getImage(String filepath) {
    IImage image = null;
    String extension = null;
    int lastIndex = -1;
    ImageImporter importer = null;
    extension = getExtension(filepath);
    if (extension != null) {
      importer = ImporterFactory.instantiate(filepath, extension);
      if (importer != null) {
        image = importer.readFile();
      }
    }
    return image;
  }

  @Override
  public boolean loadImage(String filepath) {
    boolean success = false;
    ILayer layer = null;
    IImage image = null;
    if (currentLayer != 0) {
      layer = getCurrentLayer();
      if (layer != null) {
        image = getImage(filepath);
        if (image != null) {
          layer.addImageToLayer(image);
          width = image.getWidth();
          height = image.getHeight();
          success = true;
        }
      }
    }
    return success;
  }

  /**
   * Gets the current image of the layer.
   * @return a buffered version of this image
   */
  public BufferedImage getCurrentImage() {
    IImage image = null;
    BufferedImage bufferedImage = null;
    ILayer layer = null;
    layer = getCurrentLayer();
    if (layer != null && layer.getVisibility()) {
      image = layer.getImage();
      if (image != null) {
        ImageExporter exporter = ExporterFactory.instantiate("png", image);
        bufferedImage = exporter.exportImage();
      }
    }
    return bufferedImage;
  }

  @Override
  public boolean saveImage(String filepath) {
    boolean success = false;
    ILayer layer = null;
    IImage image = null;
    String extension = null;
    ImageExporter exporter = null;
    if (currentLayer != 0) {
      layer = getCurrentLayer();
      if (layer != null) {
        image = layer.getImage();
        if (image != null) {
          extension = getExtension(filepath);
          if (extension != null) {
            exporter = ExporterFactory.instantiate(extension, image);
            if (exporter != null) {
              exporter.export(filepath);
              success = true;
            }
          }
        }
      }
    }
    return success;
  }

  private boolean transform(String key, ITransformation transformation) {
    boolean success = false;
    ILayer layer = null;
    IImage image = null;
    ImageProcessing model = null;
    model = new ImageProcessingModel();
    if (model != null) {
      layer = getCurrentLayer();
      if (layer != null) {
        image = layer.getImage();
        if (image != null) {
          model.addImage(key, image);
          image = model.applyTransformation(key, transformation);
          if (image != null) {
            layer.setImage(image);
            success = true;
          }
        }
      }
    }
    return success;
  }

  @Override
  public boolean sepia() {
    ITransformation transformation = new SepiaToneImpl();
    return transform("sepia", transformation);
  }

  @Override
  public boolean grayscale() {
    ITransformation transformation = new GrayScaleImpl();
    return transform("gray", transformation);
  }

  @Override
  public boolean blur() {
    ITransformation transformation = new BlurImpl();
    return transform("blur", transformation);
  }

  @Override
  public boolean sharpen() {
    ITransformation transformation = new SharpenImpl();
    return transform("sharpen", transformation);
  }

}
