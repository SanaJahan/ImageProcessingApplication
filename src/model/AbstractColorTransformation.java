package model;

public abstract class AbstractColorTransformation extends ImageData {

  public AbstractColorTransformation(int[][][] rgb, int height, int width) throws IllegalArgumentException {
    super(rgb, height, width);
  }

  public int[][][] applyColorTransformation() {
    float[][] sepiaTone = {{0.393f, 0.769f, 0.189f},
            {0.349f, 0.686f, 0.168f},
            {0.272f, 0.534f, 0.131f}};
    int[][][] output = copyColors(rgb);
    for (int c = 0; c < 3; c++) {
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          double value = (sepiaTone[c][0] * rgb[i][j][0]) + (sepiaTone[c][1] * rgb[i][j][1])
                  + (sepiaTone[c][2] * rgb[i][j][2]);
          output[i][j][c] = clampValue(value);
        }
      }
    }
    return output;
  }


}
