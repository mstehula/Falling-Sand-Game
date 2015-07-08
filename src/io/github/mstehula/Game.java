package io.github.mstehula;

import io.github.mstehula.elements.abstracts.Element;
import io.github.mstehula.elements.Air;
import io.github.mstehula.elements.Stone;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by MStehula on 7/7/2015.
 */
public class Game {

    private Element[][] elements = new Element[(int) Main.getDimension().getWidth()][(int) Main.getDimension().getHeight()];

    private Random rand = new Random();

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
                if(j > 20 && j < 40) {
                    this.elements[i][j] = new Stone();
                }
                else {
                    this.elements[i][j] = new Air();
                }
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
                Element e = this.elements[i][j];
                e.tick();
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

    public Element[] getSurroundingElements(Element element) {
        Element[] returnElements = new Element[8];
        int x = element.getLocation()[0];
        int y = element.getLocation()[1];

        //Down one row
        if(y + 1 < Main.getDimension().getHeight()) {
            returnElements[0] = this.elements[x][y + 1];
            if((x - 1) >= 0) {
                returnElements[1] = this.elements[x - 1][y + 1];
            } else if((x + 1) < Main.getDimension().getWidth()) {
                returnElements[2] = this.elements[x + 1][y + 1];
            }
        }

        //Up one row
        if((y - 1) >= 0) {
            returnElements[3] = this.elements[x][y - 1]);
            if((x - 1) >= 0) {
                returnElements[4] = this.elements[x - 1][y - 1];
            } else if((x + 1) < Main.getDimension().getHeight()) {
                returnElements[5] = this.elements[x + 1][y - 1];
            }
        }

        //Sides
        if((x - 1) >= 0) {
            returnElements[6] = this.elements[x - 1][y]);
        } else if((x + 1) < Main.getDimension().getHeight()) {
            returnElements[7] = this.elements[x + 1][y]);
        }

        return returnElements;
    }

    public void swapElements(Element element1, Element element2) {
        Element temp = element2;
        int[] location = element2.getLocation();
        element2 = element1;
        element2.setLocation(element1.getLocation());
        element1 = temp;
        element1.setLocation(location);
    }
}
