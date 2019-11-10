package model;

/**
 * Generates the image of the Flag of France.
 */
public class FranceFlag extends ImageData implements IFlag {

  private int[][][] france = new int[height][width][3];
  private int[][] colorRGB = {{0, 0, 204},
          {255, 255, 255},
          {255, 0, 0}};


  public FranceFlag(int width, int height) throws IllegalArgumentException {
    super(new int[height][width][3], height, width);
  }

  @Override
  public int[][][] identifyFlag() {
    double ratio = 3 / 2;
    if (width / height == ratio ) {
      int stripeWidth = (int) Math.ceil((double) width / 3);
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          if (i <= stripeWidth) {
            france[j][i] = colorRGB[0];
          } else if (i <= stripeWidth * 2) {
            france[j][i] = colorRGB[1];
          } else {
            france[j][i] = colorRGB[2];
          }
        }
      }
    }
    else {
      throw new IllegalArgumentException();
    }
    return france;
  }

  @Override
  public int[][][] storeRGB() {
    return identifyFlag();
  }
}
