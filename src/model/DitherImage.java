package model;

public class DitherImage extends ImageData implements IDither {
  private GreyScale greyScale;

  /**
   * Sets values for the width,height and rgb value given any kind of filter, color transformation, or
   * image generation.
   *
   * @param rgb    The pixel information of r,g and b as a 3D matrix.
   * @param height Height of the image.
   * @param width  Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public DitherImage(int[][][] rgb, int height, int width) throws IllegalArgumentException {
    super(rgb, height, width);
  }

  /**
   * Performs dithering operation on the image after converting it into greyscale.
   * @return The dithered image.
   */
  @Override
  public int[][][] applyDitheringEffect() {
    int newColor;
    greyScale = new GreyScale(rgb,height,width);
    int[][][] greyscaleImage = greyScale.storeRGB();
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        int oldColor = greyscaleImage[x][y][0]; //for red in this case
        if (oldColor >= 127) {
          newColor = 255;
        }
        else {
          newColor = 0;
        }
        int error = oldColor - newColor;
        greyscaleImage[x][y][0] = greyscaleImage[newColor][newColor][newColor];
        greyscaleImage[x + 1][y][0] = greyscaleImage[x+1][y][0] + (error * 7 / 16);
        greyscaleImage[x - 1][y + 1][0] = greyscaleImage[x - 1][y + 1][0] + (error * 3 / 16);
        greyscaleImage[x][y + 1][0] = greyscaleImage[x][y + 1][0] + (error * 5 / 16);
        greyscaleImage[x + 1][y + 1][0] = greyscaleImage[x + 1][y + 1][0] + (error * 1 / 16);
      }
    }

    return greyscaleImage;
  }

  @Override
  public int[][][] storeRGB() {
    return applyDitheringEffect();
  }
}
