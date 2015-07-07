package io.github.mstehula.controls;

import io.github.mstehula.Main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by MStehula on 7/7/2015.
 */
public class Window implements WindowListener{

    public void windowOpened(WindowEvent e) {  }

    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing");
        Main.getInstance().stop();
    }

    public void windowClosed(WindowEvent e) {  }
    public void windowIconified(WindowEvent e) {  }
    public void windowDeiconified(WindowEvent e) {  }
    public void windowActivated(WindowEvent e) {  }
    public void windowDeactivated(WindowEvent e) {  }
}
