package io.github.mstehula;

import io.github.mstehula.elements.AbstractElement;
import io.github.mstehula.elements.Air;
import io.github.mstehula.elements.interfaces.*;

/**
 * Created by MStehula on 7/7/2015.
 */
public class Game {

    private AbstractElement[][] elements = new AbstractElement[100][100];

    public void run() {
        this.startup();
        this.loop();
        this.shutdown();
    }

    public void stop() {
        Main.setRunning(false);
    }

    private void startup() {
        Main.getMainUI().startPane();

        for(int i = 0; i < this.elements.length; i++) {
            for(int j = 0; j < this.elements[i].length; j++) {
                this.elements[i][j] = new Air();
            }
        }
    }

    private void loop() {
        long currentTime = System.nanoTime();
        long tickTime = currentTime;
        long secondTime = currentTime;
        int tickCount = 0;
        int renderCount = 0;
        while(Main.isRunning()) {
            currentTime = System.nanoTime();
            if((currentTime - tickTime) > (1000000000 / 20)) {
                tickTime = currentTime;
                tickCount++;
                this.tick();
            }
            this.render();
            renderCount++;
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
                Main.getMainUI().paint(i, j, elements[i][j]);
            }
        }
    }

    private void render() {
        Main.getMainUI().paint();
    }

    private void shutdown() {
        Main.getMainUI().closePane();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }
}
