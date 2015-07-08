package io.github.mstehula.elements.abstracts;

import io.github.mstehula.Main;
import io.github.mstehula.elements.interfaces.Moveable;

import java.util.LinkedList;

/**
 * Created by MStehula on 7/8/2015.
 */
public abstract class MoveableElement extends Element implements Moveable {

    public MoveableElement(int x, int y) {
        super(x, y);
    }

    protected float density;
    public float getDensity() { return density; }

    public void tickMoveable() {
       Element[] surroundings = Main.getInstance().getSurroundingElements(this);

        for(int i = 0; i < 8; i++) {
            Element element = surroundings[i];
            if(element != null && element instanceof MoveableElement) {
                MoveableElement moveableElement = (MoveableElement) element;
                if(moveableElement.getDensity() < this.getDensity()) {
                    Main.getInstance().swapElements(this, element);
                }
            }
        }
    }

}
