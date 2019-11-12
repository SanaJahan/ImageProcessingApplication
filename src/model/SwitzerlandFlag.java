package model;

public class SwitzerlandFlag extends ImageData implements IFlag {

  private int[][][] switz = new int[height][width][3];
  private int[][] colorRGB = {{255, 0, 0},
          {255, 255, 255}};

  /**
   * Sets values for the width,height and rgb value given any kind of filter, color transformation,
   * or image generation.
   *
   * @param height Height of the image.
   * @param width  Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public SwitzerlandFlag(int height, int width) throws IllegalArgumentException {
    super(new int[height][width][3], height, width);
  }


  @Override
  public int[][][] identifyFlag() {
    if (width == height) {
      int top_perimeter = height * 3 / 16;
      int bottom_perimeter = height - top_perimeter;
      int cross = height * 7 / 32;
      int stripeSize = width / 7;
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          if ((i > top_perimeter + cross || i < bottom_perimeter - cross)
                  && (j > top_perimeter + cross || j < bottom_perimeter - cross)) {
            switz[j][i] = colorRGB[1];
          }
          if (j <= stripeSize) {
            this.switz[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 2) {
            this.switz[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 3) {
            this.switz[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 4) {
            this.switz[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 5) {
            this.switz[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 6) {
            this.switz[j][i] = colorRGB[0];
          } else {
            this.switz[j][i] = colorRGB[0];
          }
        }
      }
    } else {
      throw new IllegalArgumentException();
    }
    return switz;
  }

  @Override
  public int[][][] storeRGB() {
    return identifyFlag();
  }
}
