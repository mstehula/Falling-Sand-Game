package io.github.mstehula.elements;

import io.github.mstehula.elements.interfaces.Moveable;

import java.awt.*;

/**
 * Created by MStehula on 7/6/2015.
 */
public class Air extends AbstractElement implements Moveable {

    private final float density;
    public float getDensity() { return density; }

    public Air() {
        this.density = 1.225f;
        this.color = new Color(0x0f0f0f);
    }

    public void tickMoveable() {
//        System.out.println(this.getClass().getSimpleName() + " Tick: Moveable");
    }

    public void tick() {
        tickMoveable();
    }
}
