package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import model.BlurImage;
import model.DitherImage;
import model.GreyScale;
import model.IImage;
import model.MosaicImage;
import model.SepiaTone;
import model.SharpenImage;
import utility.ImageUtil;
import view.IImageView;
import view.ImageViewImpl;

public class GUIController implements ActionListener {
  private IImageView imageView;
  private IImage image;
  private ImageUtil imageUtil = new ImageUtil();
  private static int[][][] img = null;
  private static int height = -1;
  private static int width = -1;
  private String imgName = "";


  public GUIController() {
    imageView = new ImageViewImpl();
    imageView.setListener(this);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("load")) {
      System.out.println("Loading the image");
      try {
        imgName = imageView.drawImage();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    if (e.getActionCommand().equals("blur")) {
      System.out.println("Applying blur to the image");
      try {
        img = imageUtil.readImage(imgName);
        height = imageUtil.getHeight();
        width = imageUtil.getWidth();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      image = new BlurImage(img, height, width);
      img = image.storeRGB();
        imgName = "blur-"+imgName;
        imageUtil.writeImage("res/blur-"+imgName, img, width, height);
      try {
        imageView.generateImage(imgName);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    if (e.getActionCommand().equals("greyscale")) {
      System.out.println("Applying greyscale filtering on the image");
      try {
        img = imageUtil.readImage(imgName);
        height = imageUtil.getHeight();
        width = imageUtil.getWidth();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      image = new GreyScale(img, height, width);
      img = image.storeRGB();
      imgName = "greyscale-"+imgName;
      imageUtil.writeImage("res/greyscale-"+imgName, img, width, height);
      try {
        imageView.generateImage(imgName);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    if (e.getActionCommand().equals("sepia")) {
      System.out.println("Applying sepia filtering on the image");
      try {
        img = imageUtil.readImage(imgName);
        height = imageUtil.getHeight();
        width = imageUtil.getWidth();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      image = new SepiaTone(img, height, width);
      img = image.storeRGB();
      imgName = "sepia-"+imgName;
      imageUtil.writeImage("res/sepia-"+imgName, img, width, height);
      try {
        imageView.generateImage(imgName);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    if (e.getActionCommand().equals("sharpen")) {
      System.out.println("Sharpening the image");
      try {
        img = imageUtil.readImage(imgName);
        height = imageUtil.getHeight();
        width = imageUtil.getWidth();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      image = new SharpenImage(img, height, width);
      img = image.storeRGB();
      imgName = "sharpen-"+imgName;
      imageUtil.writeImage("res/sharpen-"+imgName, img, width, height);
      try {
        imageView.generateImage(imgName);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    if (e.getActionCommand().equals("dither")) {
      System.out.println("Dithering the image");
      try {
        img = imageUtil.readImage(imgName);
        height = imageUtil.getHeight();
        width = imageUtil.getWidth();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      image = new DitherImage(img, height, width);
      img = image.storeRGB();
      imgName = "dither-"+imgName;
      imageUtil.writeImage("res/dither-"+imgName, img, width, height);
      try {
        imageView.generateImage(imgName);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }



}
