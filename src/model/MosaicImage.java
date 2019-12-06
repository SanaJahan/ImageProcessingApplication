package model;

/**
 * Imposes the mosaic filter on the image.
 */
public class MosaicImage extends ImageData {
  private int seeds;
  private int[][] cluster;


  /**
   * Sets values for the width,height and rgb value given any kind of filter, color transformation,
   * or image generation.
   * @param rgb    The pixel information of r,g and b as a 3D matrix.
   * @param height Height of the image.
   * @param width  Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public MosaicImage(int[][][] rgb, int height, int width, int seeds)
          throws IllegalArgumentException {
    super(rgb, height, width);
    this.seeds = seeds;
    if (seeds < 1 || height < 1 || width < 1) {
      throw new IllegalArgumentException("Increase number of seeds or the height/ "
              + "width of the image");
    }
    this.cluster = new int[height][width];
  }


  /**
   * Performs all the operations to create the mosaic image.
   * @return The final resulting mosaic image.
   * @throws IllegalArgumentException Thrown at IOException.
   */
  private int[][][] applyMosaic() throws IllegalArgumentException {

    int[][] centroids = createCentroid(seeds);
    int[][] rgbAverage = new int[seeds][3];
    int[] clusterRGB = new int[seeds];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        cluster[i][j] = calculateDistance(centroids, i, j);
        rgbAverage[cluster[i][j]][0] += rgb[i][j][0];
        rgbAverage[cluster[i][j]][1] += rgb[i][j][1];
        rgbAverage[cluster[i][j]][2] += rgb[i][j][2];
        clusterRGB[cluster[i][j]]++;
      }
    }

    getMean(rgbAverage, clusterRGB);

    return getResult(rgbAverage);

  }

  /**
   * Applies the final resulting mosaic operation onto the result matrix.
   * @param rgbAverage The mean of the current cluster.
   * @return The result matrix with the final mosaic image.
   */
  private int[][][] getResult(int[][] rgbAverage) {
    // apply it to the final result
    int[][][] result = new int[height][width][3];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        result[i][j][0] = rgbAverage[cluster[i][j]][0];
        result[i][j][1] = rgbAverage[cluster[i][j]][1];
        result[i][j][2] = rgbAverage[cluster[i][j]][2];
      }
    }
    return result;
  }

  /**
   * Calculates the mean of the pixels in the current cluster.
   * @param rgbAverage Holds the mean of each cluster.
   * @param clusterRGB Holds the count of the pixels in each cluster.
   */
  private void getMean(int[][] rgbAverage, int[] clusterRGB) {
    // to find the mean
    for (int i = 0; i < rgbAverage.length; i++) {
      if (clusterRGB[i] != 0) {
        rgbAverage[i][0] /= clusterRGB[i];
        rgbAverage[i][1] /= clusterRGB[i];
        rgbAverage[i][2] /= clusterRGB[i];
      }
    }
  }

  /**
   * Calculates the distance between the centroid and the current pixel.
   * @param centroid Centroid for distance comparison.
   * @param pixelHeight Height of the current pixel.
   * @param pixelWidth Width of the current pixel.
   * @return The distance between the centroid and the pixel.
   */
  private int calculateDistance(int[][] centroid,
                                int pixelHeight, int pixelWidth) {
    int index = -1;
    double distance = Double.MAX_VALUE;
    for (int k = 0; k < centroid.length; k++) {
      int px1 = centroid[k][0];
      int py1 = centroid[k][1];
      int px2 = pixelHeight;
      int py2 = pixelWidth;
      int d1 = (int) Math.pow(px1 - px2, 2);
      int d2 = (int) Math.pow(py1 - py2, 2);
      double temp =  Math.sqrt(d1 + d2);
      if (temp < distance) {
        distance = temp;
        index = k;
      }
    }
    return index;
  }


  /**
   * Creates an array of seeds which act as the centroids for the clustering.
   * @param seeds Number of seeds.
   * @return Array of centroids for clustering.
   */
  private int[][] createCentroid(int seeds) {
    int[][] seedArray = new int[seeds][2];
    for (int i = 0; i < seeds; i++) {
      seedArray[i][0] = (int)(Math.random() * height);
      seedArray[i][1] = (int)(Math.random() * width);
    }
    return seedArray;
  }



  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    return applyMosaic();
  }
}
