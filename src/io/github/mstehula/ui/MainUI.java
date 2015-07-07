package io.github.mstehula.ui;

import io.github.mstehula.controls.Keyboard;
import io.github.mstehula.controls.Mouse;
import io.github.mstehula.controls.Window;
import io.github.mstehula.elements.AbstractElement;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

/**
 * Created by MStehula on 7/6/2015.
 */
public class MainUI {

    private Mouse mouse;
    private Keyboard keyboard;
    private Window window;

    private JFrame frame1;
    private Canvas canvas;

    public MainUI(Mouse mouse, Keyboard keyboard, Window window) {
        this.mouse = mouse;
        this.keyboard = keyboard;
        this.window = window;
    }

    public void startPane() {
        this.frame1 = new JFrame();
        this.frame1.addWindowListener(window);

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
        this.frame1.setVisible(false);
        this.frame1.dispose();
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
