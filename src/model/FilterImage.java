package model;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class FilterImage implements IFiltering {


  @Override
  public void applyBlurringEffect(ImageData img, int maskSize) {
    float[] blurMatrix = {1.0f / 16.0f, 1.0f / 8.0f, 1.0f / 16.0f,
            1.0f / 8.0f, 1.0f / 4.0f, 1.0f / 8.0f, 1.0f / 16.0f,
            1.0f / 8.0f, 1.0f / 16.0f};
    BufferedImageOp blurFilter = new ConvolveOp(
            new Kernel(3, 3, blurMatrix), ConvolveOp.EDGE_NO_OP, null);
    BufferedImage image = blurFilter.filter(img.getImage(), null);
    img.setImage(image);

  }

  @Override
  public void applySharpeningEffect(BufferedImage image) {
    /*BufferedImage dstImage = null;
    float[] sharpen = new float[] {
            0.0f, -1.0f, 0.0f,
            -1.0f, 5.0f, -1.0f,
            0.0f, -1.0f, 0.0f
    };
    Kernel kernel = new Kernel(3, 3, sharpen);
    ConvolveOp op = new ConvolveOp(kernel);
    dstImage = op.filter(sourceImage, null);
*/
  }
}
