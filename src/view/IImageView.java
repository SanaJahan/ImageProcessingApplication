package view;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.event.ListSelectionListener;

/**
 * Interface that deals with creating the image in the view.
 */
public interface IImageView extends ActionListener {

  public void drawImage(int[][][] rgb, int width, int height);
  }
