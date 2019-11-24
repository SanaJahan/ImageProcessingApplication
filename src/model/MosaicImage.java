package model;

public class MosaicImage extends ImageData{
  private int seeds;
  private int[][] cluster;


  /**
   * Sets values for the width,height and rgb value given any kind of filter, color transformation, or
   * image generation.
   *
   * @param rgb    The pixel information of r,g and b as a 3D matrix.
   * @param height Height of the image.
   * @param width  Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public MosaicImage(int[][][] rgb, int height, int width, int seeds) throws IllegalArgumentException {
    super(rgb, height, width);
    this.seeds = seeds;
    this.cluster = new int[height][width];
  }

  private int[][] createCentroid(int seeds) {
    int[][] seedArray = new int[seeds][2];
    for (int i = 0; i < seeds; i++) {
      seedArray[i][0] = clampValue(Math.random() * height);
      seedArray[i][1] = clampValue(Math.random() * width);
    }
    return seedArray;
  }

  private int calculateDistance(int centroidHeight, int centroidWidth,
                                int pixelHeight, int pixelWidth) {
    int px1 = centroidHeight;
    int px2 = centroidWidth;
    int py1 = pixelHeight;
    int py2 = pixelWidth;
    int d1 = (int)Math.pow(px1 - px2,2);
    int d2 = (int)Math.pow(py1 - py2,2);
    return (int)Math.sqrt(d1 + d2);
  }

  private int[][] assignToCluster() {
    int[][] centroid = createCentroid(seeds);
    int[][] cluster = new int[height][width];
    for (int i = 0; i < height; i ++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < seeds; k++) {
          cluster[i][j] = calculateDistance(centroid[k][0], centroid[k][1], i, j);
        }
      }
    }
    return cluster;
  }

  private int[][][] applyMosaic(int seeds) {
    assignToCluster();
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

    //to find the mean
    for (int i = 0; i < rgbAverage.length; i++) {
      if (clusterRGB[i] != 0) {
        rgbAverage[i][0] /= clusterRGB[i];
        rgbAverage[i][1] /= clusterRGB[i];
        rgbAverage[i][2] /= clusterRGB[i];
      }
    }

    //apply the new mean on the neighboring pixels of each cluster
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

  @Override
  public int[][][] storeRGB() {
    return applyMosaic(seeds);
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
