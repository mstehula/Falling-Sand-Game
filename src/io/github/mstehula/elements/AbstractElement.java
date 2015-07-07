package io.github.mstehula.elements;

/**
 * Created by MStehula on 7/6/2015.
 */
public abstract class AbstractElement {

    protected float density = 0.0F;
    protected int color = 0;
    public int getColor() { return this.color; }

    public abstract void tick();
}
