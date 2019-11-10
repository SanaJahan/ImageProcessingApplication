package model;

import java.awt.image.BufferedImage;

/**
 * Contains the Color Transformation operations to be implemented in the ColorTransformation class.
 */
public interface IColorTransformation {
  void applyGreyScale(ImageData imageData);
  void applySepiaTone(ImageData imageData);
}
