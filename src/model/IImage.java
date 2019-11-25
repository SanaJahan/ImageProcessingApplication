package model;

/**
 * Interface with methods to be used by the ImageData class to set the rgb, height and width value.
 */
public interface IImage {

  int[][][] storeRGB();

  int getHeight();

  int getWidth();

}
