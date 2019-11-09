import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ImageReader {

  public static void main(String[] args) {

    try {

      Scanner scanner = new Scanner(System.in);
      int width = scanner.nextInt();
      int height = scanner.nextInt();



      // to load image from a file
      File inputImage = new File("images/github-logo.png");
      BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      image = ImageIO.read(inputImage);



      // write the image to a file
      ImageIO.write(image, "jpg", new File(
              "images/my-logo.jpg"));

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

  }
}
