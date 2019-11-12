package model;

/**
 * Generates the image of the Flag of Greece.
 */
public class GreeceFlag extends ImageData implements IFlag {

  private int[][][] greece = new int[height][width][3];
  private int[][] colorRGB = {{13, 94, 175}, {255, 255, 255}};


  /**
   * Sets values for the width,height and rgb value given any kind of filter, color transformation,
   * or image generation.
   *
   * @param height Height of the image.
   * @param width  Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public GreeceFlag(int height, int width) throws IllegalArgumentException {
    super(new int[height][width][3], height, width);
  }

  /**
   * Generates the Flag of Greece.
   * @return 3D matrix output.
   */
  @Override
  public int[][][] identifyFlag() {
    double ratio = 3 / 2;
    if (width / height == ratio) {
      int stripeSize = (int) Math.ceil((double) height / 9);
      int blueBorder = stripeSize * 5;
      int cross = stripeSize * 2;
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          if (j <= stripeSize) {
            this.greece[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 2) {
            this.greece[j][i] = colorRGB[1];
          } else if (j <= stripeSize * 3) {
            this.greece[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 4) {
            this.greece[j][i] = colorRGB[1];
          } else if (j <= stripeSize * 5) {
            this.greece[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 6) {
            this.greece[j][i] = colorRGB[1];
          } else if (j <= stripeSize * 7) {
            this.greece[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 8) {
            this.greece[j][i] = colorRGB[1];
          } else {
            this.greece[j][i] = colorRGB[0];
          }
        }
      }

      for (int i = 0; i <= blueBorder; i++) {
        for (int j = 0; j <= blueBorder; j++) {
          if ((i <= cross || i >= blueBorder - cross)
                  && (j <= cross || j >= blueBorder - cross)) {
            this.greece[j][i] = colorRGB[0];
          } else {
            this.greece[j][i] = colorRGB[1];
          }
        }
      }

    } else {
      throw new IllegalArgumentException();
    }
    return greece;
  }

  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    return identifyFlag();
  }
}
