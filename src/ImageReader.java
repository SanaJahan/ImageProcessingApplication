import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.BlurImage;
import utility.FileTypeHelper;
import model.FranceFlag;
import model.GenerateCheckerBoard;
import model.GenerateVibgyorStripes;
import model.GreyScale;
import model.IBlur;
import model.IGenerateCheckerBoard;
import model.ISharpen;
import model.SepiaTone;
import model.SharpenImage;

/**
 * The main driver class that will perform the image transformation operations.
 */
public class ImageReader {


  public static void main(String[] args) throws IOException {
    //read the file
    //File f = new File("ImageProcessingApplication/images/manhattan-small.png");
    File f = new File("ImageProcessingApplication/res/cat.png");
    String originalLocation = "ImageProcessingApplication/res/";

    int dot = f.getName().indexOf('.') + 1;
    String fileType = f.getName().substring(dot);
    FileTypeHelper fileTypeHelper = new FileTypeHelper();
    FileTypeHelper.FileType file = fileTypeHelper.chooseFileType(fileType);
    String extension = "." + file.getFileType();
    BufferedImage image = ImageIO.read(f);

    //get the image
    int[][][] img = readImage(image);

    //create the blur effect
    IBlur blur = new BlurImage(img, image.getHeight(), image.getWidth());
    //write the file
    writeImage(originalLocation + "blur" + extension, blur.applyBlurringEffect(), image.getWidth(), image.getHeight());

    //create the sharpen effect
    ISharpen sharpen = new SharpenImage(img, image.getHeight(), image.getWidth());
    writeImage(originalLocation + "sharpen" + extension, sharpen.applySharpeningEffect(), image.getWidth(), image.getHeight());

    //create the grey scale effect
    GreyScale greyScale = new GreyScale(img, image.getHeight(), image.getWidth());
    writeImage(originalLocation + "greyscale" + extension, greyScale.applyGrayScaleTransformation(), image.getWidth(), image.getHeight());

    //create the sepiatone effect
    SepiaTone sepiaTone = new SepiaTone(img, image.getHeight(), image.getWidth());
    writeImage(originalLocation + "sepiatone" + extension, sepiaTone.applySepiaTransformation(), image.getWidth(), image.getHeight());


    // generate the checker board
    IGenerateCheckerBoard generateImage = new GenerateCheckerBoard(40);
    writeImage(originalLocation + "checkerboard" + extension, generateImage.generateCheckerBoard(),
            ((GenerateCheckerBoard) generateImage).getWidth(), ((GenerateCheckerBoard) generateImage).getHeight());

    //generate vibgyor horizontal
    GenerateVibgyorStripes vibgyorHorizontalStripes = new GenerateVibgyorStripes(500,400);
    writeImage(originalLocation + "horizontal" + extension, vibgyorHorizontalStripes.createHorizontalVIBGYOR(), vibgyorHorizontalStripes.getWidth(),vibgyorHorizontalStripes.getHeight());

    //generate vibgyor vertical
    GenerateVibgyorStripes vibgyorVerticalStripes = new GenerateVibgyorStripes(500,400);
    writeImage(originalLocation + "vertical" + extension, vibgyorVerticalStripes.createVerticalVIBGYOR(), vibgyorVerticalStripes.getWidth(),vibgyorVerticalStripes.getHeight());

    // generate the Flag of France
    FranceFlag franceFlag = new FranceFlag(300,200);
    writeImage(originalLocation + "franceflag" + extension,franceFlag.identifyFlag(),franceFlag.getWidth(),franceFlag.getHeight());

  }


  /**
   * Reads and loads the image in consideration.
   * @param image The image.
   * @return 3D matrix output.
   */
  private static int[][][] readImage(BufferedImage image) {
    if (image == null) {
      throw new IllegalArgumentException();
    }
    int[][][] result = new int[image.getHeight()][image.getWidth()][3];
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int color = image.getRGB(j, i);
        Color c = new Color(color);
        result[i][j][0] = c.getRed();
        result[i][j][1] = c.getGreen();
        result[i][j][2] = c.getBlue();
      }
    }
    return result;

  }

  /**
   * Writes the newly created image to a specified filepath.
   * @param filePath Path to which the new image output is to be stored.
   * @param rgb The rgb 3D matrix value.
   * @param width Width of the image.
   * @param height Height of the image.
   */
  private static void writeImage(String filePath, int[][][] rgb, int width, int height) {
    try {
      BufferedImage output = new BufferedImage(
              width,
              height,
              BufferedImage.TYPE_INT_RGB);

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int red = rgb[i][j][0];
          int green = rgb[i][j][1];
          int blue = rgb[i][j][2];
          int color = (red << 16) + (green << 8) + blue;
          output.setRGB(j, i, color);
        }
      }
      String extension = filePath.substring(filePath.indexOf(".") + 1);
      ImageIO.write(output, extension, new FileOutputStream(filePath));
    } catch (IOException e) {
      System.out.println("Error Occurred!\n" + e);
    }
  }

}
