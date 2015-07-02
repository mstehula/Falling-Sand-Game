package io.github.mstehula.elements;

/**
 * Created by MStehula on 7/2/2015.
 */
public abstract class Element {

    // Float defines the density. All movement up and down is defined by this density constant.
    private float density;
    public float getDensity() { return density; }
    public float setDensity() { return density; }

    // Dispersion defines the amount of dispersion an element goes through
    private float dispersion;
    public float getDispersion() { return dispersion; }
    public float setDispersion() { return dispersion; }


}
