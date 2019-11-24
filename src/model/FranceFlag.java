package model;

/**
 * Generates the image of the Flag of France.
 */
public class FranceFlag extends ImageData {

  private int[][][] france = new int[height][width][3];
  private int[][] colorRGB = {{0, 0, 204},
    {255, 255, 255},
    {255, 0, 0}};

  /**
   * Constructor that calls the constructor of the ImageData class to set the rgb,height and width.
   * @param height Height of the image.
   * @param width Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public FranceFlag(int width, int height) throws IllegalArgumentException {
    super(new int[height][width][3], height, width);
  }

  /**
   * Generates the Flag of France.
   * @return 3D matrix output.
   */
  private int[][][] identifyFlag() {
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

  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    return identifyFlag();
  }
}
