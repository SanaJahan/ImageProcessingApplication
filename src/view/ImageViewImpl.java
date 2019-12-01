package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ImageViewImpl extends JFrame implements ActionListener,IImageView {

  private JLabel display;
  private JButton echoButton, exitButton,toggleButton;
  private JTextField input;

  public ImageViewImpl() {
      display = new JLabel("Image Processor");
      this.add(display);

      this.setVisible(true);
      this.setSize(500,600);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new FlowLayout());
  }
  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
