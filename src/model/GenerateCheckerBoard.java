package model;

/**
 * Generates a checkerboard image.
 */
public class GenerateCheckerBoard implements IImage {

  private int squareSize;
  private int height;
  private int width;

  /**
   * Constructor that sets the height, width and square size of the checkerboard image.
   * @param squareSize Size of each square in the checkerboard.
   * @throws IllegalArgumentException thrown at IllegalArgumentException.
   */
  public GenerateCheckerBoard(int squareSize) throws IllegalArgumentException {
    this.squareSize = squareSize;
    this.height = squareSize * 8;
    this.width = squareSize * 8;
    if (squareSize < 1) {
      throw new IllegalArgumentException("Square size is too less");
    }
  }

  /**
   * Generates the checkerboard image.
   * @return 3D matrix output.
   */
  private int[][][] generateCheckerBoard() {
    int[][][] rgb = new int[height][width][3];

    for (int i = 0; i < squareSize * 8; i++) {
      for (int j = 0; j < squareSize * 8; j++) {
        int row = i / squareSize;
        int column = j / squareSize;
        if ((row + column) % 2 == 0) {
          rgb[i][j][0] = 255;
          rgb[i][j][1] = 255;
          rgb[i][j][2] = 255;
        } else {
          rgb[i][j][0] = 0;
          rgb[i][j][1] = 0;
          rgb[i][j][2] = 0;
        }
      }
    }
    return rgb;
  }

  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    return generateCheckerBoard();
  }

  /**
   * Stores the height of the image.
   * @return Height.
   */
  @Override
  public int getHeight() {
    return height;
  }

  /**
   * Stores the width of the image.
   * @return Width.
   */
  @Override
  public int getWidth() {
    return width;
  }
}
