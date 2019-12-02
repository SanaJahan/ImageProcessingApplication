package view;

import java.awt.event.ActionListener;
import java.io.IOException;

public interface IImageView {

  String drawImage() throws IOException;
  void saveImage();
  void generateImage(String input) throws IOException;
  void setListener(ActionListener listener);

  }
