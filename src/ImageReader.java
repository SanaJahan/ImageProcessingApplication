import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.ColorTransformation;
import model.FilterImage;
import model.IColorTransformation;
import model.IFiltering;
import model.ImageData;

public class ImageReader {

  private static ImageData imageData = new ImageData();


  public static void main(String[] args) {

    //read the file
    readImage("ImageProcessingApplication/images/sample1.jpg");
    //write the file
    writeImage("ImageProcessingApplication/images/sample1output.jpg");

  }


  public static ImageData createImageData(BufferedImage image, String fileType) {
    imageData.setImage(image);
    if("jpg".equals(fileType)){
      imageData.setImgType(ImageData.ImageType.JPG);
    } else{
      imageData.setImgType(ImageData.ImageType.PNG);
    }
    imageData.setWidth(image.getWidth());
    imageData.setHeight(image.getHeight());
    imageData.setTotalPixels(imageData.getImageWidth()*imageData.getImageHeight());
    imageData.setPixels(new int[imageData.getImageTotalPixels()]);
    return imageData;
  }


  public static void readImage(String filePath){
    try{
      File f = new File(filePath);
      BufferedImage image = ImageIO.read(f);
      String fileType = filePath.substring(filePath.lastIndexOf('.')+1);
      ImageData imageData = createImageData(image,fileType);
//      IFiltering filterImage = new FilterImage();
//      filterImage.applyBlurringEffect(imageData,3);
      IColorTransformation c = new ColorTransformation();
      c.applyGreyScale(imageData);
    }catch( IOException e){
      System.out.println("Error Occurred!\n"+e);
    }
  }

  public static void writeImage(String filePath){
    try {
      File f = new File(filePath);
      String fileType = filePath.substring(filePath.lastIndexOf('.') + 1);
      ImageIO.write(imageData.getImage(), fileType, f);
    } catch(IOException e){
      System.out.println("Error Occurred!\n" + e);
    }
  }

}
