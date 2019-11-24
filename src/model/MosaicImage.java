package model;

import java.util.ArrayList;
import java.util.Random;

public class MosaicImage extends ImageData{
  private static final Random random = new Random();
//  ArrayList<Centroid> clusters = new ArrayList<>();

  private int[][] createCentroid(int seeds) {
    int[][] seedArray = new int[seeds][2];
    int max = 255;
    int min = 0;
    int range = max - min + 1;
    for (int i = 0; i < seeds; i++) {
      seedArray[i][0] = (int)(Math.random() * range * ) + min;
    }
  }
  


  @Override
  public int[][][] storeRGB() {
    return new int[0][][];
  }

  /**
   * create
   * calculateDist

  assignToCluster(int centroids[][], int rgb[]) {
    int[][] cluster = new int[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < seedArray.length; k++) {
          //store the closest pixels
          cluster[i][j] = calcDistance(centroid[k][0],centroid[k][1], i, j);
        }
      }
    }

    int[][][] mosaic(int noOfSeeds){
      int[] clusterRGB = new int[seeds];
      int[][] rgbAverage = new int[seeds][3];
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          rgbAverage[cluster[i][j]][0] += rgb[i][j][0];
          rgbAverage[cluster[i][j]][1] += rgb[i][j][1];
          rgbAverage[cluster[i][j]][2] += rgb[i][j][2];
          clusterRGB[cluster[i][j]]++;
        }
      }
      //find mean
      for (int i = 0; i < rgbAverage.length; i++) {
        if (clusterRGB[i] != 0) {
          rgbAverage[i][0] /= clusterRGB[i];
          rgbAverage[i][1] /= clusterRGB[i];
          rgbAverage[i][2] /= clusterRGB[i];
        }
      }

      int[][][] result = new int[height][width][3];
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          for (int k = 0; k < 3; k++) {
            result[i][j][k] = rgbAverage[cluster[i][j]][k];
          }
        }
      }
      return result;
    }

   */
}
