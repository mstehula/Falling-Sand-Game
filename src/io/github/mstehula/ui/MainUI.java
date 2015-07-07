package io.github.mstehula.ui;

import io.github.mstehula.controls.Keyboard;
import io.github.mstehula.controls.Mouse;
import io.github.mstehula.elements.AbstractElement;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by MStehula on 7/6/2015.
 */
public class MainUI {

    private Mouse mouse;
    private Keyboard keyboard;

    private JFrame frame1;
    private Canvas canvas;

    public MainUI(Mouse mouse, Keyboard keyboard) {
        this.mouse = mouse;
        this.keyboard = keyboard;
    }

    public void startPane() {
        this.frame1 = new JFrame();
        this.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.canvas = new Canvas();
        this.canvas.setSize(800, 600);
        this.canvas.setBackground(new Color(0,0,0));
        this.canvas.addMouseListener(mouse);
        this.canvas.addMouseMotionListener(mouse);
        this.frame1.add(canvas);

        this.frame1.pack();
        this.frame1.setVisible(true);

        this.canvas.createBufferStrategy(2);
    }

    public void closePane() {

    }

    public void paint(int i, int j, AbstractElement element) {
        BufferStrategy bf = this.canvas.getBufferStrategy();
        Graphics g = null;

        try {
            g = bf.getDrawGraphics();
            g.setColor(new Color(element.getColor()));
            g.fillRect(i, j, 1, 1);
        } finally {
            g.dispose();
        }
    }

    public void paint() {
        BufferStrategy bf = this.canvas.getBufferStrategy();
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }
}
