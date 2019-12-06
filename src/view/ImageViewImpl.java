package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.GUIController;
import utility.ImageUtil;

/**
 * Deals with the GUI components to be added to the application.
 */
public class ImageViewImpl extends JFrame implements IImageView {

  private GUIController controller;

  private JPanel mainPanel;
  private JScrollPane mainScrollPane;
  private JLabel fileOpenDisplay;
  private JLabel fileSaveDisplay;
  private JLabel imageLabel;
  private JPanel imagePanel;
  private JScrollPane imageScrollPane;
  private JMenuBar menuBar;
  private JMenu menu;
  private ImageUtil imageUtil = new ImageUtil();


  /**
   * Constructor where all the GUI components are added to the user interface of the application.
   */
  public ImageViewImpl() {
    super();
    controller = new GUIController();
    setTitle("Image Processor");
    setSize(400, 400);

    mainPanel = new JPanel();
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    //scroll bars around this main panel
    mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);

    // menu bar
    JPanel menuBarPanel = new JPanel();
    menuBarPanel.setBorder(BorderFactory.createTitledBorder("Select the effect you want"));
    menuBarPanel.setLayout(new BoxLayout(menuBarPanel, BoxLayout.PAGE_AXIS));
    menuBar = new JMenuBar();
    menu = new JMenu("Menu");
    JMenuItem blur = new JMenuItem("Blur");
    blur.setActionCommand("blur");
    blur.addActionListener(this);

    JMenuItem sepia = new JMenuItem("Sepia");
    sepia.setActionCommand("sepia");
    sepia.addActionListener(this);

    JMenuItem sharpen = new JMenuItem("Sharpen");
    sharpen.setActionCommand("sharpen");
    sharpen.addActionListener(this);

    JMenuItem greyscale = new JMenuItem("Greyscale");
    greyscale.setActionCommand("greyscale");
    greyscale.addActionListener(this);

    JMenuItem dither = new JMenuItem("Dither");
    dither.setActionCommand("dither");
    dither.addActionListener(this);

    JMenuItem mosaic = new JMenuItem("Mosaic");
    mosaic.setActionCommand("mosaic");
    mosaic.addActionListener(this);

    JMenuItem vibgyor = new JMenuItem("Generate Vibgyor");
    vibgyor.setActionCommand("vibgyor");
    vibgyor.addActionListener(this);

    JMenuItem checkerboard = new JMenuItem("Generate CheckerBoard");
    checkerboard.setActionCommand("checkerboard");
    checkerboard.addActionListener(this);


    menu.add(blur);
    menu.add(sepia);
    menu.add(sharpen);
    menu.add(greyscale);
    menu.add(dither);
    menu.add(mosaic);
    menu.add(vibgyor);
    menu.add(checkerboard);
    menuBar.add(menu);
    mainPanel.add(menuBar);

    //show an image with a scrollbar
    imagePanel = new JPanel();
    //a border around the panel with a caption
    imagePanel.setBorder(BorderFactory.createTitledBorder("Selected image will be shown here"));
    imagePanel.setLayout(new GridLayout(1, 0, 10, 10));
    mainPanel.add(imagePanel);

    // image label
    imageLabel = new JLabel();

    imageScrollPane = new JScrollPane(imageLabel);
    imageScrollPane.setPreferredSize(new Dimension(100, 600));
    imagePanel.add(imageScrollPane);

    //dialog boxes
    JPanel dialogBoxesPanel = new JPanel();
    dialogBoxesPanel.setBorder(BorderFactory.createTitledBorder("Load or save an image"));
    dialogBoxesPanel.setLayout(new BoxLayout(dialogBoxesPanel, BoxLayout.PAGE_AXIS));
    mainPanel.add(dialogBoxesPanel);

    //file open
    JPanel fileopenPanel = new JPanel();
    fileopenPanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(fileopenPanel);
    JButton fileOpenButton = new JButton("Open a file");
    fileOpenButton.setActionCommand("Open file");
    fileOpenButton.addActionListener(this);
    fileopenPanel.add(fileOpenButton);
    fileOpenDisplay = new JLabel("File path will appear here");
    fileopenPanel.add(fileOpenDisplay);

    //file save
    JPanel filesavePanel = new JPanel();
    filesavePanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(filesavePanel);
    JButton fileSaveButton = new JButton("Save a file");
    fileSaveButton.setActionCommand("Save file");
    fileSaveButton.addActionListener(this);
    filesavePanel.add(fileSaveButton);
    fileSaveDisplay = new JLabel("File path will appear here");
    filesavePanel.add(fileSaveDisplay);

    //file reset
    JPanel resetPanel = new JPanel();
    resetPanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(resetPanel);
    JButton resetButton = new JButton("Reset");
    resetButton.setActionCommand("Reset");
    resetButton.addActionListener(this);
    resetPanel.add(resetButton);

  }

  /**
   * Mentions the actions that need to be performed when a particular effect is requested.
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    int height = -1;
    int width = -1;
    switch (e.getActionCommand()) {
      case "Open file": {
        final JFileChooser fchooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Images", "jpg", "png");
        fchooser.setFileFilter(filter);
        int retvalue = fchooser.showOpenDialog(ImageViewImpl.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File file = fchooser.getSelectedFile();
          if (file == null) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "No image was selected to load", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
            break;
          }
          fileOpenDisplay.setText(file.getAbsolutePath());
          imageLabel.setIcon(new ImageIcon(file.getAbsolutePath()));
          imageLabel.setHorizontalAlignment(JLabel.CENTER);

          try {
            controller.loadImage(file.getName());
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          imagePanel.updateUI();
        }
        break;
      }
      case "blur": {
        width = controller.getWidth();
        height = controller.getHeight();
        if (width < 0 || height < 0) {
          JOptionPane.showMessageDialog(new JFrame(),
                  "Please open an image file to apply the effect", "Dialog",
                  JOptionPane.ERROR_MESSAGE);
          break;
        }
        drawImage(controller.applyEffect("blur"), width, height);
        break;
      }
      case "sharpen": {
        width = controller.getWidth();
        height = controller.getHeight();
        if (width < 0 || height < 0) {
          JOptionPane.showMessageDialog(new JFrame(),
                  "Please open an image file to apply the effect", "Dialog",
                  JOptionPane.ERROR_MESSAGE);
          break;
        }
        drawImage(controller.applyEffect("sharpen"), width, height);
        break;
      }
      case "greyscale": {
        width = controller.getWidth();
        height = controller.getHeight();
        if (width < 0 || height < 0) {
          JOptionPane.showMessageDialog(new JFrame(),
                  "Please open an image file to apply the effect", "Dialog",
                  JOptionPane.ERROR_MESSAGE);
          break;
        }
        drawImage(controller.applyEffect("greyscale"), width, height);
        break;
      }
      case "sepia": {
        width = controller.getWidth();
        height = controller.getHeight();
        if (width < 0 || height < 0) {
          JOptionPane.showMessageDialog(new JFrame(),
                  "Please open an image file to apply the effect", "Dialog",
                  JOptionPane.ERROR_MESSAGE);
          break;
        }
        drawImage(controller.applyEffect("sepia"), width, height);
        break;
      }
      case "mosaic": {
        width = controller.getWidth();
        height = controller.getHeight();
        if (width < 0 || height < 0) {
          JOptionPane.showMessageDialog(new JFrame(),
                  "Please open an image file to apply the effect", "Dialog",
                  JOptionPane.ERROR_MESSAGE);
          break;
        }
        int seeds = Integer.parseInt(JOptionPane.showInputDialog("Enter seed value"));
        if (seeds < 2) {
          JOptionPane.showMessageDialog(new JFrame(),
                  "Seeds value should be greater than 1", "Dialog",
                  JOptionPane.ERROR_MESSAGE);

        }
        drawImage(controller.applyMosaicEffect(seeds), width, height);
        break;
      }
      case "dither": {
        width = controller.getWidth();
        height = controller.getHeight();
        if (width < 0 || height < 0) {
          JOptionPane.showMessageDialog(new JFrame(),
                  "Please open an image file to apply the effect", "Dialog",
                  JOptionPane.ERROR_MESSAGE);
          break;
        }
        drawImage(controller.applyEffect("dither"), width, height);
        break;
      }
      case "vibgyor": {
        String direction = JOptionPane.showInputDialog("Please enter direction of stripe");
        String heightStr = JOptionPane.showInputDialog("Please enter height");
        String widthStr = JOptionPane.showInputDialog("Please enter width");
        width = Integer.parseInt(widthStr);
        height = Integer.parseInt(heightStr);
        if (width < 0 || height < 0 || !direction.equals("horizontal")
                && !direction.equals("vertical")) {
          JOptionPane.showMessageDialog(new JFrame(),
                  "Generation of image failed. Please try again", "Dialog",
                  JOptionPane.ERROR_MESSAGE);
          break;
        }
        drawImage(controller.generateVibgyor(direction, width,
                height), height, width);
        break;
      }
      case "checkerboard": {
        String squareSize = JOptionPane.showInputDialog("Please enter square size value");
        if (Integer.parseInt(squareSize) < 1) {
          JOptionPane.showMessageDialog(new JFrame(),
                  "Square size should be greater than 0", "Dialog",
                  JOptionPane.ERROR_MESSAGE);
          break;
        }
        int[][][] img = controller.generateCheckerboard(Integer.parseInt(squareSize));
        height = controller.getHeight();
        width = controller.getWidth();
        drawImage(img, width, height);
        break;
      }
      case "Save file": {
        final JFileChooser fchooser = new JFileChooser(".");
        int retvalue = fchooser.showSaveDialog(ImageViewImpl.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          if (f == null) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Failed to save image.Please try again", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
            break;
          }
          fileSaveDisplay.setText(f.getAbsolutePath());
          controller.saveImage(f.getAbsolutePath());
        }
      }
      case "Reset": {
        imageLabel.setIcon(null);
        fileOpenDisplay.setText("File path will appear here");
        break;
      }
    }
  }

  /**
   * Creates and updates the image in the viewing panel of the GUI.
   * @param rgb Image matrix.
   * @param width Width of the image.
   * @param height Height of the image.
   */
  @Override
  public void drawImage(int[][][] rgb, int width, int height) {
    if (rgb == null) {
      JOptionPane.showMessageDialog(new JFrame(),
              "Effect cannot be applied. Please try again", "Dialog",
              JOptionPane.ERROR_MESSAGE);
    }
    BufferedImage output = imageUtil.getTransformedImage(rgb, width, height);
    imageLabel.setIcon(new ImageIcon(output));
    imagePanel.updateUI();
  }
}


