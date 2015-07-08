package io.github.mstehula.elements;

import io.github.mstehula.elements.abstracts.MoveableElement;

import java.awt.*;

/**
 * Created by MStehula on 7/6/2015.
 */
public class Air extends MoveableElement {

    public Air(int x, int y) {
        super(x, y);
        this.density = 1.225f;
        this.color = new Color(0x0f0f0f);
    }

    public void tick() {
        tickMoveable();
    }
}
