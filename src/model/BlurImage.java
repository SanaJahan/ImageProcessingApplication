package model;

public class BlurImage extends ImageData implements IBlur {

  public BlurImage(int[][][] rgb, int height, int width) {

    super(rgb, height, width);
  }

  public int[][][] applyBlurringEffect() {
    double[][] blurKernel = {{1.0f/16.0f, 1.0f/8.0f, 1.0f/16.0f},
            {1.0f/8.0f, 1.0f/4.0f, 1.0f/8.0f},
            {1.0f/16.0f, 1.0f/8.0f, 1.0f/16.0f}};
    return initializeRGBValues(blurKernel);
  }

  @Override
  public int[][][] storeRGB() {
    return applyBlurringEffect();
  }
}
