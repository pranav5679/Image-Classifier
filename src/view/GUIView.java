package view;

import controller.command.CommandException;
import controller.command.CommandResponse;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Represents the image swing view as a GUI.
 */
public class GUIView extends View implements ActionListener {

  private JFrame mainFrame;
  private JMenuItem loadMenuItem;
  private JMenuItem saveMenuItem;
  private JMenuItem exitMenuItem;
  private JMenuItem deleteMenuItem;
  private JMenuItem blurMenuItem;
  private JMenuItem sepiaMenuItem;
  private JMenuItem sharpenMenuItem;
  private JMenuItem grayScaleMenuItem;
  private JMenuItem invisibleMenuItem;


  private JScrollPane jsp;

  /**
   * Constructs a view for the GUI.
   */
  public GUIView() {
    prepareGUI();
  }

  private void processCommand(String command) {
    try {
      this.controller.processCommand(command);
    }
    catch (CommandException e) {
      e.printStackTrace();
    }
  }

  /**
   * Calls the appropriate method to the model object based on what the user signified through the
   * view object.
   *
   * @param e the event that happened in the GUI
   */
  public void actionPerformed(ActionEvent e) {
    File file = null;
    String filepath = null;
    BufferedImage bufferedImage = null;
    String extension = null;
    boolean success = false;
    String responseMessage = null;
    int id = 0;
    switch (e.getActionCommand()) {
      case "Load":
        filepath = selectFile();
        if (filepath != null) {
          processCommand("load " + filepath);
        }
        break;
      case "Save":
        filepath = saveFile();
        if (filepath != null) {
          processCommand("save " + filepath);
        }
        break;
      case "Exit":
        exitView();
        break;
      case "Blur":
        processCommand("blur");
        break;
      case "Sepia":
        processCommand("sepia");
        break;
      case "Sharpen":
        processCommand("sharpen");
        break;
      case "Gray Scale":
        processCommand("gray");
        break;
      case "Invisible":
        id = controller.getCurrentLayer();
        processCommand("invisible " + Integer.valueOf(id));
        break;
      default:
        break;
    }
  }

  /**
   * Set listeners.
   *
   * @param actionListener listener to be set
   */
  private void setListeners(ActionListener actionListener) {
    // File menu items
    loadMenuItem.addActionListener(actionListener);
    saveMenuItem.addActionListener(actionListener);
    exitMenuItem.addActionListener(actionListener);
    deleteMenuItem.addActionListener(actionListener);
    // Image menu items
    blurMenuItem.addActionListener(actionListener);
    sepiaMenuItem.addActionListener(actionListener);
    sharpenMenuItem.addActionListener(actionListener);
    grayScaleMenuItem.addActionListener(actionListener);
    invisibleMenuItem.addActionListener(actionListener);
  }

  /**
   * Select file.
   *
   * @return File path to be selected
   */
  private String selectFile() {
    File selectedFile = null;
    String filepath = null;
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    int result = fileChooser.showOpenDialog(mainFrame);
    if (result == JFileChooser.APPROVE_OPTION) {
      selectedFile = fileChooser.getSelectedFile();
      filepath = selectedFile.getAbsolutePath();
    }
    return filepath;
  }

  /**
   * Save File.
   *
   * @return File path to be saved
   */
  private String saveFile() {
    File saveToFile = null;
    String filepath = null;
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    int result = fileChooser.showSaveDialog(mainFrame);
    if (result == JFileChooser.APPROVE_OPTION) {
      saveToFile = fileChooser.getSelectedFile();
      filepath = saveToFile.getAbsolutePath();
    }
    return filepath;
  }

  /**
   * Exit view.
   */
  private void exitView() {
    mainFrame.dispose();
  }

  /**
   * Preprares the layout of the GUI.
   */
  private void prepareGUI() {
    mainFrame = new JFrame("Image Processor View");
    mainFrame.setSize(1024, 768);
    mainFrame.setLayout(new FlowLayout());

    //create a menu bar
    final JMenuBar menuBar = new JMenuBar();

    //create File menu
    JMenu fileMenu = new JMenu("File");

    //create menu items
    loadMenuItem = new JMenuItem("Load");
    loadMenuItem.setActionCommand("Load");

    saveMenuItem = new JMenuItem("Save");
    saveMenuItem.setActionCommand("Save");

    exitMenuItem = new JMenuItem("Exit");
    exitMenuItem.setActionCommand("Exit");

    deleteMenuItem = new JMenuItem("Delete Layer");
    deleteMenuItem.setActionCommand("Delete Layer");

    //add menu items to menus
    fileMenu.add(loadMenuItem);
    fileMenu.add(saveMenuItem);
    fileMenu.add(deleteMenuItem);
    fileMenu.addSeparator();
    fileMenu.add(exitMenuItem);

    //create Image menu
    JMenu imageMenu = new JMenu("Image");

    //create menu items
    blurMenuItem = new JMenuItem("Blur");
    blurMenuItem.setActionCommand("Blur");

    sepiaMenuItem = new JMenuItem("Sepia");
    sepiaMenuItem.setActionCommand("Sepia");

    sharpenMenuItem = new JMenuItem("Sharpen");
    sharpenMenuItem.setActionCommand("Sharpen");

    grayScaleMenuItem = new JMenuItem("Gray Scale");
    grayScaleMenuItem.setActionCommand("Gray Scale");

    invisibleMenuItem = new JMenuItem("Invisible");
    invisibleMenuItem.setActionCommand("Invisible");

    //add menu items to menus
    imageMenu.add(blurMenuItem);
    imageMenu.add(sepiaMenuItem);
    imageMenu.add(sharpenMenuItem);
    imageMenu.add(grayScaleMenuItem);
    imageMenu.add(invisibleMenuItem);

    //add menu to menubar
    menuBar.add(fileMenu);
    menuBar.add(imageMenu);

    // setListeners
    setListeners(this);

    //add menubar to the frame
    mainFrame.setJMenuBar(menuBar);

    mainFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
      }
    });
  }

  /**
   * Starts a view.
   *
   * @return Success or failure
   */
  public boolean start(Object param) {
    mainFrame.setVisible(true);
    return true;
  }

  /**
   * Display buffered image.
   *
   * @param bufferedImage buffer image to be displayed
   */
  private void displayImage(BufferedImage bufferedImage) {
    if (jsp != null) {
      mainFrame.getContentPane().remove(jsp);
    }
    JLabel label = new JLabel(new ImageIcon(bufferedImage));
    jsp = new JScrollPane(label);
    jsp.setEnabled(true);
    jsp.setPreferredSize(new Dimension(1024, 768));
    mainFrame.getContentPane().add(jsp);
    mainFrame.repaint();
    mainFrame.setVisible(true);
  }

  private void clearImage() {
    if (jsp != null) {
      mainFrame.getContentPane().remove(jsp);
    }
    mainFrame.repaint();
    mainFrame.setVisible(true);
  }

  @Override
  public void renderMessage(String message) {
    System.out.println(message);
  }

  @Override
  public void renderResponse(CommandResponse commandResponse) {
    BufferedImage bufferedImage = null;
    if (commandResponse != null) {
      if (commandResponse.getSuccess()) {
        bufferedImage = (BufferedImage) commandResponse.getResponse();
        if (bufferedImage != null) {
          displayImage(bufferedImage);
        }
        else {
          clearImage();
        }
      }
    }
  }

}
