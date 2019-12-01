package view;

import java.awt.event.ActionListener;

public interface IImageView {

  void loadImage();
  void drawImage();
  void saveImage();
  void generateImage();
  void setListener(ActionListener listener);

}
