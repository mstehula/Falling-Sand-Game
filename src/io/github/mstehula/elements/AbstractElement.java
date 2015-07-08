package io.github.mstehula.elements;

import java.awt.*;

/**
 * Created by MStehula on 7/6/2015.
 */
public abstract class AbstractElement {

    protected Color color;
    public Color getColor() { return this.color; }
    public int[] getColorArray() { return new int[]{this.color.getRed(), this.color.getGreen(), this.color.getBlue()}; }

    public abstract void tick();
}
