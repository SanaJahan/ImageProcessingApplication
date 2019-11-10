package model;


public class GreyScale extends AbstractColorTransformation {

  public GreyScale(int[][][] rgb, int height, int width) throws IllegalArgumentException {
    super(rgb, height, width);
  }


  @Override
  public int[][][] storeRGB() {
    return applyColorTransformation();
  }
}
