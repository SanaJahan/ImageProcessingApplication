package model;

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

  @Override
  public int[][][] identifyFlag() {
    double ratio = 2 / 3;
    if (width / height == ratio) {
      int stripeSize = (int) Math.ceil((double) height / 9);
      int blueBorder = stripeSize * 5;
      int cross = stripeSize * 2;
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          if (j <= stripeSize) {
            rgb[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 2) {
            rgb[j][i] = colorRGB[1];
          } else if (j <= stripeSize * 3) {
            rgb[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 4) {
            rgb[j][i] = colorRGB[1];
          } else if (j <= stripeSize * 5) {
            rgb[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 6) {
            rgb[j][i] = colorRGB[1];
          } else if (j <= stripeSize * 7) {
            rgb[j][i] = colorRGB[0];
          } else if (j <= stripeSize * 8) {
            rgb[j][i] = colorRGB[1];
          } else {
            rgb[j][i] = colorRGB[0];
          }
        }
      }

      for (int i = 0; i <= blueBorder; i++) {
        for (int j = 0; j <= blueBorder; j++) {
          if ((i <= blueBorder || i >= cross - blueBorder)
                  && (j <= blueBorder || j >= blueBorder - blueBorder)) {
            rgb[j][i] = colorRGB[0];
          } else {
            rgb[j][i] = colorRGB[1];
          }
        }
      }


    } else {
      throw new IllegalArgumentException();
    }
    return greece;
  }

  @Override
  public int[][][] storeRGB() {
    return identifyFlag();
  }
}
