package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.IImage;
import utility.ImageUtil;
import view.IImageView;
import view.ImageViewImpl;

public class GUIController implements ActionListener {
  private static IImageView imageView;
  private static IImage image;
  private ImageUtil imageUtil = new ImageUtil();


  public GUIController() {
    imageView = new ImageViewImpl();
    imageView.setListener(this);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("load")) {
      System.out.println("Loading the image");
      //imageUtil.readImage();
    }
  }

}
