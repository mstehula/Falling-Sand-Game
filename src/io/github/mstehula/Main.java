package io.github.mstehula;

import io.github.mstehula.controls.Keyboard;
import io.github.mstehula.controls.Mouse;
import io.github.mstehula.elements.AbstractElement;
import io.github.mstehula.elements.Air;
import io.github.mstehula.elements.interfaces.*;
import io.github.mstehula.ui.MainUI;

/**
 * Created by MStehula on 7/2/2015.
 */
public class Main {

    private Mouse mouse = new Mouse();
    private Keyboard keyboard = new Keyboard();
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

        for(int i = 0; i < elements.length; i++) {
            for(int j = 0; j < elements[i].length; j++) {
                elements[i][j] = new Air();
            }
        }
    }

    private void loop() {
        tick();
        render();
    }

    private void tick() {
        for(int i = 0, width = elements.length; i < width; i++) {
            for (int j = 0, height = elements[i].length; j < height; j++) {
                AbstractElement e = elements[i][j];
                e.tick();
                if(e instanceof Flammable) ((Flammable) e).tickFlammable();
                if(e instanceof Liquid) ((Liquid) e).tickLiquid();
                if(e instanceof Magnetic) ((Magnetic) e).tickMagnetic();
                if(e instanceof Moveable) ((Moveable) e).tickMoveable();
                if(e instanceof Oxydizer) ((Oxydizer) e).tickOxydizer();
                if(e instanceof Soluble) ((Soluble) e).tickSoluble();
                if(e instanceof Solution) ((Solution) e).tickSolution();
                if(e instanceof Solvent) ((Solvent) e).tickSolvent();
            }
        }
    }

    private void render() {
        ui.paint();
    }

    private void shutdown() {
        ui.closePane();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

}
