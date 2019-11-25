package utility;

/**
 * Helper class to support multiple file types.
 */
public class FileTypeHelper {
  /**
   * enum for the different supported file types.
   */
  public enum FileType {
    PNG("png"), JPG("jpg"), BMP("bmp");

    // declaring private variable for getting values
    private String fileType;

    /**
     * Gives the filetype of the image.
     * @return Filetype.
     */
    public String getFileType() {
      return fileType;
    }

    // enum constructor
    FileType(String fileType) {
      this.fileType = fileType;
    }

  }

  /**
   * Helps select the file type.
   * @param fileType File type.
   * @return the selected file type.
   */
  public FileType chooseFileType(String fileType) {
    switch (fileType) {
      case "png":
        return FileType.PNG;
      case "jpg":
        return FileType.JPG;
      case "bmp":
        return FileType.BMP;
      default:
        throw new IllegalArgumentException("File type not supported.");
    }
  }

}
