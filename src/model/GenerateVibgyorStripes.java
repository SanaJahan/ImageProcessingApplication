package model;

/**
 * Generates an image with the colors of the rainbow.
 */
public class GenerateVibgyorStripes extends ImageData implements IGenerateStripes {

  private boolean horizontal = false;

  private int[][][] rainbow = new int[height][width][3];
  private int[][] colorRGB = {{255, 0, 0},
    {255, 200, 0},
    {255, 255, 0},
    {0, 255, 0},
    {0, 0, 255},
    {75, 0, 130},
    {128, 0, 128}};

  /**
   * Constructor that calls the constructor of the ImageData class to set the rgb,height and width.
   * @param height Height of the image.
   * @param width Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public GenerateVibgyorStripes(int height, int width) throws IllegalArgumentException {
    super(new int[height][width][3], height, width);
  }

  /**
   * Generates the rainbow colored image with horizontal stripes.
   * @return 3D matrix output.
   */
  @Override
  public int[][][] createHorizontalVIBGYOR() {
    horizontal = true;
    int stripeWidth = (int) Math.ceil((double) height / 7);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (j <= stripeWidth) {
          rgb[j][i] = colorRGB[0];
        } else if (j <= stripeWidth * 2) {
          rgb[j][i] = colorRGB[1];
        } else if (j <= stripeWidth * 3) {
          rgb[j][i] = colorRGB[2];
        } else if (j <= stripeWidth * 4) {
          rgb[j][i] = colorRGB[3];
        } else if (j <= stripeWidth * 5) {
          rgb[j][i] = colorRGB[4];
        } else if (j <= stripeWidth * 6) {
          rgb[j][i] = colorRGB[5];
        } else {
          rgb[j][i] = colorRGB[6];
        }
      }
    }
    return rgb;
  }

  /**
   * Generates the rainbow colored image with vertical stripes.
   * @return 3D matrix output.
   */
  @Override
  public int[][][] createVerticalVIBGYOR() {
    int stripeWidth = (int) Math.ceil((double) width / 7);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (i <= stripeWidth) {
          rainbow[j][i] = colorRGB[0];
        } else if (i <= stripeWidth * 2) {
          rainbow[j][i] = colorRGB[1];
        } else if (i <= stripeWidth * 3) {
          rainbow[j][i] = colorRGB[2];
        } else if (i <= stripeWidth * 4) {
          rainbow[j][i] = colorRGB[3];
        } else if (i <= stripeWidth * 5) {
          rainbow[j][i] = colorRGB[4];
        } else if (i <= stripeWidth * 6) {
          rainbow[j][i] = colorRGB[5];
        } else {
          rainbow[j][i] = colorRGB[6];
        }
      }
    }
    return rainbow;
  }

  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    return horizontal ? createHorizontalVIBGYOR() : createVerticalVIBGYOR();
  }
}
