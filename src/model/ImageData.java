package model;

import java.util.Arrays;

/**
 * image representation for the image processing applications.
 */
public final class ImageData {
  private int width;
  private int height;
  private byte[] data;

  public ImageData(int width, int height, byte[] data) {
    this.width = width;
    this.height = height;
    this.data = data;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public byte[] getData() {
    return data;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    ImageData imageData = (ImageData) o;

    if (width != imageData.width) return false;
    if (height != imageData.height) return false;
    return Arrays.equals(data, imageData.data);

  }

  @Override
  public int hashCode() {
    int result = width;
    result = 31 * result + height;
    result = 31 * result + Arrays.hashCode(data);
    return result;
  }
}
