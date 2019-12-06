package view;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.event.ListSelectionListener;

public interface IImageView extends ActionListener {

  public void drawImage(int[][][] rgb, int width, int height);
  }
