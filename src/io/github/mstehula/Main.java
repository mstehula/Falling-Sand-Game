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
    private MainUI ui = new MainUI(mouse, keyboard);
    private AbstractElement[][] elements = new AbstractElement[100][100];

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        this.startup();
        this.loop();
        this.shutdown();
    }

    private void startup() {
        this.ui.startPane();

        for(int i = 0; i < elements.length; i++) {
            for(int j = 0; j < elements[i].length; j++) {
                this.elements[i][j] = new Air();
            }
        }
    }

    private void loop() {
        boolean running = true;
        long currentTime = System.nanoTime();
        long tickTime = currentTime;
//        long renderTime = currentTime;
        long secondTime = currentTime;
        int tickCount = 0;
        int renderCount = 0;
        while(running) {
            currentTime = System.nanoTime();
            if((currentTime - tickTime) > (1000000000 / 20)) {
                tickTime = currentTime;
                tickCount++;
                this.tick();
            }
            this.render();
            renderCount++;
            //Frame limiter to 60fps
//            if((currentTime - renderTime) > (1000000000 / 60)) {
//                renderTime = currentTime;
//                renderCount++;
//                this.render();
//            }
            if((currentTime - secondTime) > 1000000000) {
                secondTime = currentTime;
                System.out.println("Tick count: " + tickCount + ", Render count " + renderCount);
                tickCount = 0;
                renderCount = 0;
            }
        }
    }

    private void tick() {
        for(int i = 0, width = this.elements.length; i < width; i++) {
            for (int j = 0, height = this.elements[i].length; j < height; j++) {
                AbstractElement e = this.elements[i][j];
                e.tick();
                if(e instanceof Flammable) ((Flammable) e).tickFlammable();
                if(e instanceof Liquid) ((Liquid) e).tickLiquid();
                if(e instanceof Magnetic) ((Magnetic) e).tickMagnetic();
                if(e instanceof Moveable) ((Moveable) e).tickMoveable();
                if(e instanceof Oxydizer) ((Oxydizer) e).tickOxydizer();
                if(e instanceof Soluble) ((Soluble) e).tickSoluble();
                if(e instanceof Solution) ((Solution) e).tickSolution();
                if(e instanceof Solvent) ((Solvent) e).tickSolvent();
                this.ui.paint(i, j, elements[i][j]);
            }
        }
    }

    private void render() {
        this.ui.paint();
    }

    private void shutdown() {
        this.ui.closePane();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

}
