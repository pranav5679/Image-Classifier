package model;

import controller.command.Command;
import controller.command.CommandException;
import controller.command.CommandFactory;
import controller.command.CommandResponse;
import controller.scriptmanager.ScriptManager;
import model.multilayerimage.MultiLayerImageImpl;

import java.awt.image.BufferedImage;

/**
 * Represents a generic model object.
 */
public class Model implements IModel {

  private boolean loadImage(MultiLayerImageImpl multiLayerImage, String filepath) {
    boolean success = false;
    int id = multiLayerImage.getCurrentID();
    if (id == 0) {
      success = multiLayerImage.addLayer();
      if (success) {
        success = multiLayerImage.loadImage(filepath);
      }
    }
    else {
      success = multiLayerImage.loadImage(filepath);
    }
    return success;
  }

  private boolean saveImage(MultiLayerImageImpl multiLayerImage, String filepath) {
    return multiLayerImage.saveImage(filepath);
  }

  private boolean runScript(MultiLayerImageImpl multiLayerImage, String filepath) {
    ScriptManager scriptManager = new ScriptManager(filepath, multiLayerImage);
    boolean success = false;
    success = scriptManager.run();
    return success;
  }

  protected BufferedImage getCurrentImage(MultiLayerImageImpl multiLayerImage) {
    return multiLayerImage.getCurrentImage();
  }

  private boolean blurImage(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    success = multiLayerImage.blur();
    return success;
  }

  private boolean sepiaImage(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    success = multiLayerImage.sepia();
    return success;
  }

  private boolean sharpenImage(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    success = multiLayerImage.sharpen();
    return success;
  }

  private boolean grayscaleImage(MultiLayerImageImpl multiLayerImage) {
    boolean success = false;
    success = multiLayerImage.grayscale();
    return success;
  }

  protected void setResponse(CommandResponse commandResponse, MultiLayerImageImpl multiLayerImage) {
    commandResponse.setSuccess(true);
    commandResponse.setResponse(getResponseObject(commandResponse));
  }

  private void setErrorResponse(CommandResponse commandResponse, String errorMessage) {
    commandResponse.setSuccess(false);
    commandResponse.setErrorMessage(errorMessage);
  }

  @Override
  public CommandResponse processCommand(MultiLayerImageImpl multiLayerImage, String commandLine)
      throws CommandException {
    CommandResponse commandResponse = new CommandResponse(commandLine);
    String errorMessage = "";
    boolean success = false;
    Command command = CommandFactory.instantiate(commandLine);
    if (command != null) {
      switch (command.getKeyword()) {
        case "load":
          success = loadImage(multiLayerImage, command.getToken(1));
          if (!success) {
            errorMessage = "Failed to load the image.";
          }
          break;
        case "save":
          success = saveImage(multiLayerImage, command.getToken(1));
          if (!success) {
            errorMessage = "Failed to save the image.";
          }
          break;
        case "create":
          success = multiLayerImage.addLayer(Integer.valueOf(command.getToken(2)));
          if (!success) {
            errorMessage = "Failed to create a layer.";
          }
          break;
        case "current":
          success = multiLayerImage.setCurrent(Integer.valueOf(command.getToken(1)));
          if (!success) {
            errorMessage = "Failed to set to the current layer.";
          }
          break;
        case "delete":
          success = multiLayerImage.removeLayer(Integer.valueOf(command.getToken(2)));
          if (!success) {
            errorMessage = "Failed to delete a layer.";
          }
          break;
        case "blur":
          success = blurImage(multiLayerImage);
          if (!success) {
            errorMessage = "Failed to blur the image.";
          }
          break;
        case "sharpen":
          success = sharpenImage(multiLayerImage);
          if (!success) {
            errorMessage = "Failed to sharpen the image.";
          }
          break;
        case "sepia":
          success = sepiaImage(multiLayerImage);
          if (!success) {
            errorMessage = "Failed to apply a sepia filter to the image.";
          }
          break;
        case "gray":
          success = grayscaleImage(multiLayerImage);
          if (!success) {
            errorMessage = "Failed to apply a grayscale filter to the image.";
          }
          break;
        case "invisible":
          success = multiLayerImage.setInvisible(Integer.valueOf(command.getToken(1)));
          if (!success) {
            errorMessage = "Failed to make the layer invisible.";
          }
          break;
        default:
          break;
      }
      if (success) {
        setResponse(commandResponse, multiLayerImage);
      }
      else {
        setErrorResponse(commandResponse, errorMessage);
      }
    }
    return commandResponse;
  }

  @Override
  public Object getResponseObject(CommandResponse commandResponse) {
    String response = commandResponse.getCommandLine();
    return "\"" + response + "\"" + " complete sucessfully.";
  }
}