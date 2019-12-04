package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import utility.ImageUtil;

public class ImageViewImpl extends JFrame implements IImageView {

  private JLabel display;
  private JMenu load, generate;
  private JMenuBar menuBar;
  private JLabel saveImage;
  private JPanel mainPanel = new JPanel();
  // Menu items
  private JMenuItem loadImg, hVibgyor, vVibgyor, checkerboard,franceFlag,greeceFlag;
  private JButton blurBtn, ditherBtn, mosaicBtn, greyScaleBtn, sepiaBtn,sharpenBtn,saveImageBtn;
  private String imgName;



  public ImageViewImpl() {
      display = new JLabel("Image Processor");
      this.add(display);

      this.setVisible(true);
      this.setSize(500,600);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new FlowLayout());

      //create the menu
       menuBar = new JMenuBar();
       load = new JMenu("Load");
       generate = new JMenu("Generate");

      // create menu items
      loadImg = new JMenuItem("image");
      loadImg.setActionCommand("load");
      hVibgyor = new JMenuItem("Horizontal Vibgyor");
      vVibgyor = new JMenuItem("Vertical Vibgyor");
      checkerboard = new JMenuItem("Checkerboard");
      franceFlag = new JMenuItem("France Flag");
      greeceFlag = new JMenuItem("Greece Flag");

      // add menu items to menu
      generate.add(hVibgyor);
      generate.add(vVibgyor);
      generate.add(checkerboard);
      generate.add(franceFlag);
      generate.add(greeceFlag);
      load.add(loadImg);

      // add menu to menu bar
      menuBar.add(load);
      menuBar.add(generate);
      this.add(menuBar);
      this.add(mainPanel);
      // create all the buttons
      blurBtn = new JButton("Blur");
      blurBtn.setActionCommand("blur");

      greyScaleBtn = new JButton("GreyScale");
      greyScaleBtn.setActionCommand("greyscale");

      sepiaBtn = new JButton("Sepia");
      sepiaBtn.setActionCommand("sepia");

      sharpenBtn = new JButton("Sharpen");
      sharpenBtn.setActionCommand("sharpen");

      ditherBtn = new JButton("Dither");
      ditherBtn.setActionCommand("dither");

      mosaicBtn = new JButton("Mosaic");
      mosaicBtn.setActionCommand("mosaic");

      saveImageBtn = new JButton("Save Image");
      saveImageBtn.setActionCommand("save");

  }


  @Override
  public String drawImage() throws IOException {
    this.setVisible(false);
    this.imgName = JOptionPane.showInputDialog("Please input a value");
    System.out.println(imgName);
    displayImage(imgName);
    return imgName;

  }

  @Override
  public void saveImage(BufferedImage output,String filename,String ext) {
    try {
      if (ext == "png" || ext == "jpg" || ext == "bmp") {
        filename = filename + "." + ext;
      }
      File outputFile = new File(filename);
      ImageIO.write(output,ext,outputFile);

      JFileChooser fileChooser = new JFileChooser();
      int option = fileChooser.showSaveDialog(ImageViewImpl.this);
      if(option == JFileChooser.APPROVE_OPTION){
        fileChooser.setSelectedFile(outputFile);
        saveImage.setText("File Saved as: " + outputFile.getName());
      }else{
        saveImage.setText("Save command canceled");
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void generateImage(String input) throws IOException {
    this.setVisible(false);
    displayImage(input);
  }

  private void displayImage(String input) throws IOException {
    ClassLoader classLoader = new ImageUtil().getClass().getClassLoader();
    BufferedImage image = ImageIO.read(classLoader.getResource(input));
    ImageIcon icon = new ImageIcon(image);
    JLabel label = new JLabel(icon);
    JScrollPane pane = new JScrollPane(label);
    mainPanel.add(pane);
    //create all the transform buttons
    this.add(blurBtn);
    this.add(greyScaleBtn);
    this.add(sepiaBtn);
    this.add(sharpenBtn);
    this.add(ditherBtn);
    this.add(mosaicBtn);
    this.add(saveImageBtn);
    this.setVisible(true);
    System.out.println("Image showed");
  }

  @Override
  public void setListener(ActionListener listener) {
    loadImg.addActionListener(listener);
    blurBtn.addActionListener(listener);
    greyScaleBtn.addActionListener(listener);
    sepiaBtn.addActionListener(listener);
    sharpenBtn.addActionListener(listener);
    ditherBtn.addActionListener(listener);
    mosaicBtn.addActionListener(listener);
    saveImageBtn.addActionListener(listener);
  }

  @Override
  public BufferedImage writeNewImage(int[][][] rgb, int width, int height) {
      BufferedImage output = new BufferedImage(
              width,
              height,
              BufferedImage.TYPE_INT_RGB);

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int red = rgb[i][j][0];
          int green = rgb[i][j][1];
          int blue = rgb[i][j][2];
          int color = (red << 16) + (green << 8) + blue;
          output.setRGB(j, i, color);
        }
      }
      return output;
  }

}
