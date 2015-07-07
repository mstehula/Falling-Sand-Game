package io.github.mstehula.elements;

import io.github.mstehula.elements.interfaces.Moveable;

/**
 * Created by MStehula on 7/6/2015.
 */
public class Air extends AbstractElement implements Moveable {

    public Air() {
        this.density = 1.225f;
        this.color = 0x070707;
    }

    public void tickMoveable() {
//        System.out.println(this.getClass().getSimpleName() + " Tick: Moveable");
    }

    public void tick() {

    }
}
