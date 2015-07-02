package io.github.mstehula;

import io.github.mstehula.elements.Element;
import io.github.mstehula.elements.interfaces.Flammable;
import io.github.mstehula.elements.interfaces.Moveable;
import io.github.mstehula.elements.interfaces.Soluble;

/**
 * Created by MStehula on 7/2/2015.
 */
public class Main {

    private Element[][] elements;

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        startup();
        loop();
        shutdown();
    }

    private void startup() {
        elements = new Element[100][100];
    }

    private void loop() {
        tick();
        render();
    }

    private void shutdown() {

    }

    private void tick() {
        for(Element[] eArray : elements) {
            for (Element e : eArray) {
                if (e instanceof Moveable) ((Moveable) e).tickMoveable();
                if (e instanceof Flammable) ((Flammable) e).tickFlammable();
                if (e instanceof Soluble) ((Soluble) e).contactingWater();
            }
        }
    }

    private void render() {

    }

}
