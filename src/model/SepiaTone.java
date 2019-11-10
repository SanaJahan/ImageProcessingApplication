package model;

public class SepiaTone extends AbstractColorTransformation {

  public SepiaTone(int[][][] rgb, int height, int width) throws IllegalArgumentException {
    super(rgb, height, width);
  }

  @Override
  public int[][][] storeRGB() {
    return applyColorTransformation();
  }


}
