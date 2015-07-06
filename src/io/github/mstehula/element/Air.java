package io.github.mstehula.element;

import io.github.mstehula.element.interfaces.Moveable;

/**
 * Created by MStehula on 7/6/2015.
 */
public class Air extends AbstractElement implements Moveable {

    public void tickMoveable() {
        System.out.println("Tick: Moveable");
    }

}
