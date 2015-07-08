package io.github.mstehula.elements.abstracts;

import java.awt.*;

/**
 * Created by MStehula on 7/6/2015.
 */
public abstract class Element {

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected int x;
    protected int y;
    public int[] getLocation() {
        return new int[]{this.x, this.y};
    }
    public void setLocation(int[] location) {
        x = location[0];
        y = location[1];
    }
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected Color color;
    public Color getColor() { return color; }
    public int[] getColorArray() { return new int[]{this.color.getRed(), this.color.getGreen(), this.color.getBlue()}; }

    public abstract void tick();
}
