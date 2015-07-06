package io.github.mstehula;

import io.github.mstehula.element.AbstractElement;

/**
 * Created by MStehula on 7/2/2015.
 */

public class Main {

    private AbstractElement[][] elements;

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        startup();
        loop();
        shutdown();
    }

    private void startup() {
        elements = new AbstractElement[100][100];
    }

    private void loop() {
        tick();
        render();
    }

    private void shutdown() {

    }

    private void tick() {
        for(AbstractElement[] eArray : elements) {
            for (AbstractElement e : eArray) {
                e.doVoid();
            }
        }
    }

    private void render() {

    }

}
