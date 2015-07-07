package io.github.mstehula.elements;

import io.github.mstehula.elements.interfaces.Moveable;

/**
 * Created by MStehula on 7/6/2015.
 */
public class Air extends AbstractElement implements Moveable {

    public void tickMoveable() {
        System.out.println(this.getClass().getSimpleName() + " Tick: Moveable");
    }

}
