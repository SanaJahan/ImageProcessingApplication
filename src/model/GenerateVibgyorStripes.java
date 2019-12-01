package model;

/**
 * Generates an image with the colors of the rainbow.
 */
public class GenerateVibgyorStripes extends ImageData {

  private boolean horizontal = false;
  private String direction = "";

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
  public GenerateVibgyorStripes(String direction,int height, int width) throws IllegalArgumentException {
    super(new int[height][width][3], height, width);
    this.direction = direction;
    if(direction.equals("horizontal")){
      this.horizontal = true;
    }
  }

  /**
   * Generates the rainbow colored image with horizontal stripes.
   * @return 3D matrix output.
   */
  private int[][][] createHorizontalVIBGYOR() {
    horizontal = true;
    int stripeWidth = (int) Math.ceil((double) height / 7);
    return createRainbow(stripeWidth);
  }

  /**
   * Generates the rainbow colored image with vertical stripes.
   * @return 3D matrix output.
   */
  private int[][][] createVerticalVIBGYOR() {
    int stripeWidth = (int) Math.ceil((double) width / 7);
    return createRainbow(stripeWidth);
  }

  private int[][][] createRainbow(int stripeWidth) {
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
