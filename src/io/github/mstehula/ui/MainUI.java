package io.github.mstehula.ui;

import io.github.mstehula.Main;
import io.github.mstehula.elements.AbstractElement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

/**
 * Created by MStehula on 7/6/2015.
 */
public class MainUI {

    private JFrame frame1;
    private JPanel panel1;
    private Canvas canvas;

    private BufferedImage img = new BufferedImage((int) Main.getDimension().getWidth(), (int) Main.getDimension().getHeight(), BufferedImage.TYPE_INT_RGB);

    public void startPane() {
        this.frame1 = new JFrame();
        this.frame1.addWindowListener(Main.getWindow());

        this.panel1 = new JPanel();
        this.panel1.setSize(Main.getDimension());
        this.frame1.add(this.panel1);

        this.canvas = new Canvas();
        this.canvas.setSize(Main.getDimension());
        this.canvas.setBackground(new Color(0x0000ff));
        this.canvas.addMouseListener(Main.getMouse());
        this.canvas.addMouseMotionListener(Main.getMouse());
        this.canvas.setVisible(true);
        this.panel1.add(this.canvas);

        this.frame1.pack();
        this.frame1.setVisible(true);

        this.canvas.createBufferStrategy(2);
    }

    public void closePane() {
        this.frame1.setVisible(false);
        this.frame1.dispose();
    }

    public void paint(int i, int j, AbstractElement element) {
        img.getRaster().setPixel(i, j, element.getColorArray());
    }

    public void paint() {
        this.canvas.getGraphics().drawImage(img, 0, 0, this.canvas.getWidth(), this.canvas.getHeight(), null);
    }
}
