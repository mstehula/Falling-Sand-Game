package io.github.mstehula;

import io.github.mstehula.element.AbstractElement;
import io.github.mstehula.ui.MainUI;

/**
 * Created by MStehula on 7/2/2015.
 */
public class Main {

    private MainUI ui = new MainUI();
    private AbstractElement[][] elements = new AbstractElement[100][100];

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        startup();
        loop();
        shutdown();
    }

    private void startup() {
        ui.startPane();
    }

    private void loop() {
        tick();
        render();
    }

    private void shutdown() {
        ui.closePane();
    }

    private void tick() {
        for(int i = 0, width = elements.length; i < width; i++) {
            for (int j = 0, height = elements[i].length; j < height; j++) {
                AbstractElement e = elements[i][j];
                e.doVoid();
            }
        }
    }

    private void render() {
        ui.paint();
    }

}
