package model;

import java.awt.image.BufferedImage;

public interface IColorTransformation {
  void applyGreyScale(BufferedImage imageData);
  void applySepiaTone(BufferedImage imageData);
}
