package io.github.mstehula.ui;

import io.github.mstehula.Main;
import io.github.mstehula.elements.AbstractElement;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * Created by MStehula on 7/6/2015.
 */
public class MainUI {

    private JFrame frame1;
    private Canvas canvas;

    private BufferedImage img = new BufferedImage((int) Main.getDimension().getWidth(), (int) Main.getDimension().getHeight(), BufferedImage.TYPE_INT_RGB);

    public void startPane() {
        this.frame1 = new JFrame();
        this.frame1.addWindowListener(Main.getWindow());

        this.canvas = new Canvas();
        this.canvas.setSize(Main.getDimension());
        this.canvas.setBackground(new Color(0x0));
        this.canvas.addMouseListener(Main.getMouse());
        this.canvas.addMouseMotionListener(Main.getMouse());
        this.frame1.add(canvas);

        this.frame1.pack();
        this.frame1.setVisible(true);
    }

    public void closePane() {
        this.frame1.setVisible(false);
        this.frame1.dispose();
    }

    public void paint(int i, int j, AbstractElement element) {
        img.getRaster().setPixel(i, j, element.getColorArray());
    }

    public void paint() {
        this.canvas.getGraphics().drawImage(img, this.canvas.getWidth(), this.canvas.getHeight(), null);
    }
}
