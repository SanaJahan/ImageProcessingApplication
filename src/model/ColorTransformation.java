package model;

/**
 * Contains methods used for performing Color Transformation operations, like grayscale and sepia,
 * on the image.
 */
public class ColorTransformation implements IColorTransformation {

  /**
   * Converts image to grayscale.
   * @param imageData Image in consideration.
   */
  @Override
  public void applyGreyScale(ImageData imageData) {
    for(int y = 0; y < imageData.getImageHeight(); y++){
      for(int x = 0; x < imageData.getImageWidth(); x++) {
        int p = imageData.getImage().getRGB(x, y);

        int a = (p >> 24) & 0xff;
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b = p & 0xff;

        //calculate average
        int avg = (r + g + b) / 3;

        //replace RGB value with avg
        p = (a << 24) | (avg << 16) | (avg << 8) | avg;

        imageData.getImage().setRGB(x, y, p);
      }
    }
  }

  /**
   * Converts image to sepia tone.
   * @param imageData Image in consideration.
   */
  @Override
  public void applySepiaTone(ImageData imageData) {
    int width = imageData.getImageWidth();
    int height = imageData.getImageHeight();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int p = imageData.getImage().getRGB(x, y);

        int a = (p >> 24) & 0xff;
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b = p & 0xff;

        //calculate tr, tg, tb
        int tr = (int) (0.393 * r + 0.769 * g + 0.189 * b);
        int tg = (int) (0.349 * r + 0.686 * g + 0.168 * b);
        int tb = (int) (0.272 * r + 0.534 * g + 0.131 * b);

        //check condition
        if (tr > 255) {
          r = 255;
        } else {
          r = tr;
        }

        if (tg > 255) {
          g = 255;
        } else {
          g = tg;
        }

        if (tb > 255) {
          b = 255;
        } else {
          b = tb;
        }

        //set new RGB value
        p = (a << 24) | (r << 16) | (g << 8) | b;

        imageData.getImage().setRGB(x, y, p);
      }
    }
  }
}

