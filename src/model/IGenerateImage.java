package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

/**
 * Contains methods that will generate an image based on the implementations in the,
 * GenerateImage class.
 */
public interface IGenerateImage {
  void generateHorizontalRainbow(Scanner sc) throws IOException;
  void generateVerticalRainbow(Scanner sc) throws IOException;
  void generateCheckerBoard(Scanner sc) throws IOException;
}
