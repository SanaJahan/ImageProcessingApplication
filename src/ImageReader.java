import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.ColorTransformation;
import model.IColorTransformation;

public class ImageReader {

  public static void main(String[] args) {

    try {
      IColorTransformation colorTransformation = new ColorTransformation();
      //Scanner scanner = new Scanner(System.in);
      int width = 400;//scanner.nextInt();
      int height = 400;//scanner.nextInt();



      // to load image from a file
      File inputImage = new File("/Users/madhuripalanivelu/Documents/IDEs_Code_and_Workspaces/eclipse-workspace/Assignment 7/ImageProcessingApplication/images/sample1.jpg");
      BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      image = ImageIO.read(inputImage);

      // calling all the image processing effects here:
      //colorTransformation.applySepiaTone(image);
      colorTransformation.applyGreyScale(image);


      // write the image to a file
      ImageIO.write(image, "jpg", new File(
              "/Users/madhuripalanivelu/Documents/IDEs_Code_and_Workspaces/eclipse-workspace/Assignment 7/ImageProcessingApplication/images/sample1output.jpg"));

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

  }
}
