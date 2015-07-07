package io.github.mstehula;

/**
 * Created by MStehula on 7/2/2015.
 */
public class Main {

    public static void main(String[] args) {
        setInstance(new Game());
        Main.instance.run();
    }

    private static Game instance;
    public static void setInstance(Game game) {
        if(Main.instance != null) {
            System.out.println("Cannot create instance, instance not null.");
            return;
        }
        Main.instance = game;
    }
    public static Game getInstance() { return Main.instance; }

    private static boolean running = true;
    public static boolean isRunning() { return running; }
    public static void setRunning(boolean running) { Main.running = running; }
}
