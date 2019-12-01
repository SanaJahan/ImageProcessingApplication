package model;

/**
 * Performs dither operation on an image.
 */
public class DitherImage extends ImageData {

  /**
   * Sets values for the width,height and rgb value given any kind of filter, color transformation,
   * or image generation.
   *
   * @param rgb    The pixel information of r,g and b as a 3D matrix.
   * @param height Height of the image.
   * @param width  Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public DitherImage(int[][][] rgb, int height, int width) throws IllegalArgumentException {
    super(rgb, height, width);
    if (height < 1 || width < 1) {
      throw new IllegalArgumentException("Height/Width of the image is too less");
    }
  }

  /**
   * Performs dithering operation on the image after converting it into greyscale.
   * @return The dithered image.
   */
  private int[][][] applyDitheringEffect() {
    int newColor;
    GreyScale greyScale = new GreyScale(rgb,height,width);
    int[][][] greyscaleImage = greyScale.storeRGB();
    for (int x = 0; x < getHeight(); x++) {
      for (int y = 0; y < getWidth(); y++) {
        int oldColor = greyscaleImage[x][y][0];
        newColor = Math.round(oldColor / 255) * 255;
        int error = oldColor - newColor;
        for (int c = 0; c < 3; c++) {
          greyscaleImage[x][y][c] = newColor;
        }
        if (y + 1 <= width - 1) {
          for (int c = 0; c < 3; c++) {
            greyscaleImage[x][y + 1][c] += ((7.0 / 16.0) * error);
          }
        }
        if (x + 1 <= height - 1 && y - 1 >= 0) {
          for (int c = 0; c < 3; c++) {
            greyscaleImage[x + 1][y - 1][c] += ((3.0 / 16.0) * error);
          }
        }
        if (x + 1 <= height - 1) {
          for (int c = 0; c < 3; c++) {
            greyscaleImage[x + 1][y][c] += ((5.0 / 16.0) * error);
          }
        }
        if (x + 1 <= height - 1 && y + 1 <= width - 1) {
          for (int c = 0; c < 3; c++) {
            greyscaleImage[x + 1][y + 1][c] += ((1.0 / 16.0) * error);
          }
        }
      }
    }
    return greyscaleImage;
  }

  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    return applyDitheringEffect();
  }
}
