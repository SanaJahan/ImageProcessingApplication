package view;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public interface IImageView {

  String drawImage() throws IOException;

  void saveImage(BufferedImage output,String filename,String ext);

  void generateImage(String input) throws IOException;

  void setListener(ActionListener listener);

  BufferedImage writeNewImage(int[][][] rgb, int width, int height);

  }
