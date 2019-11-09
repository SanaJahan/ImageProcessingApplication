package model;

import java.awt.image.BufferedImage;

public interface IColorTransformation {
  void applyGreyScale(ImageData imageData);
  void applySepiaTone(ImageData imageData);
}
