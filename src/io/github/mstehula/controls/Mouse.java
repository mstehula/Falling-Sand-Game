package io.github.mstehula.controls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by MStehula on 7/7/2015.
 */
public class Mouse implements MouseListener, MouseMotionListener {

    private int x = 0;
    public int getX() { return x; }

    private int y = 0;
    public int getY() { return y; }

    private boolean isPressed;
    public boolean isPressed() { return isPressed; }

    public void mouseClicked(MouseEvent e) {
        //Not used, use mousePressed(MouseEvent e) and mouseReleased(MouseEvent e)
    }

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        isPressed = true;
    }

    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        isPressed = false;
    }

    public void mouseEntered(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        isPressed = false;
    }

    public void mouseExited(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        isPressed = false;
    }

    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();

    }

}
