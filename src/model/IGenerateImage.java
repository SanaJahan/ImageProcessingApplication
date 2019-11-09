package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public interface IGenerateImage {
  void generateHorizontalRainbow(Scanner sc) throws IOException;
  void generateVerticalRainbow(Scanner sc) throws IOException;
  void generateCheckerBoard(Scanner sc) throws IOException;
}
