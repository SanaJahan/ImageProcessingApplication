package view;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.event.ListSelectionListener;

/**
 * Interface that deals with creating the image in the view.
 */
public interface IImageView extends ActionListener {

  /**
   * Creates and updates the image in the viewing panel of the GUI.
   * @param rgb Image matrix.
   * @param width Width of the image.
   * @param height Height of the image.
   */
  public void drawImage(int[][][] rgb, int width, int height);
  }
