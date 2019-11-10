package model;



public class GenerateCheckerBoard implements IGenerateCheckerBoard, IImage{

  private int squareSize;
  private int height;
  private int width;

  public GenerateCheckerBoard(int squareSize) throws IllegalArgumentException {
    this.squareSize = squareSize;
    this.height = squareSize * 8;
    this.width = squareSize * 8;
  }



  @Override
  public int[][][] generateCheckerBoard() {
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

  @Override
  public int[][][] storeRGB() {
    return generateCheckerBoard();
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }
}
