package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ImageViewImpl extends JFrame implements IImageView {

  private JLabel display;
  private JMenu menu;
  private JMenuBar menuBar;
  // Menu items
  private JMenuItem m1, m2;



  public ImageViewImpl() {
      display = new JLabel("Image Processor");
      this.add(display);

      this.setVisible(true);
      this.setSize(500,600);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new FlowLayout());

      //create the menu
       menuBar = new JMenuBar();
       menu = new JMenu("Menu");

      // create menu items
      m1 = new JMenuItem("load");
      m1.setActionCommand("load");
      m2 = new JMenuItem("generate");

      // add menu items to menu
      menu.add(m1);
      menu.add(m2);

      // add menu to menu bar
      menuBar.add(menu);
      this.add(menuBar);



  }

  @Override
  public void loadImage() {

  }

  @Override
  public void drawImage() {

  }

  @Override
  public void saveImage() {

  }

  @Override
  public void generateImage() {

  }

  @Override
  public void setListener(ActionListener listener) {
    m1.addActionListener(listener);
  }

}
