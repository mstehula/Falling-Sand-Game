package io.github.mstehula.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MStehula on 7/6/2015.
 */
public class MainUI {

    private JFrame frame1;
    private JPanel panel1;
    private Canvas canvas;

    public void startPane() {
        frame1 = new JFrame();

        panel1 = new JPanel();
        panel1.setSize(800, 600);
        frame1.add(panel1);

        canvas = new Canvas();
        canvas.setSize(800, 600);
        panel1.add(canvas);

        frame1.pack();
        frame1.setVisible(true);
    }

    public void closePane() {

    }

    public void paint() {

    }
}
