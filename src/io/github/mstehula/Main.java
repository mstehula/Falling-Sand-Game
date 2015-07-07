package io.github.mstehula;

import io.github.mstehula.controls.Keyboard;
import io.github.mstehula.controls.Mouse;
import io.github.mstehula.controls.Window;
import io.github.mstehula.ui.MainUI;

/**
 * Created by MStehula on 7/2/2015.
 */
public class Main {

    public static void main(String[] args) {
        setInstance(new Game());
        setMouse(new Mouse());
        setKeyboard(new Keyboard());
        setWindow(new Window());
        setMainUI(new MainUI(getMouse(), getKeyboard(), getWindow()));
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

    private static Mouse mouse;
    public static Mouse getMouse() { return mouse; }
    public static void setMouse(Mouse mouse) { Main.mouse = mouse; }

    private static Keyboard keyboard;
    public static Keyboard getKeyboard() { return keyboard; }
    public static void setKeyboard(Keyboard keyboard) { Main.keyboard = keyboard; }

    private static Window window;
    public static Window getWindow() { return window; }
    public static void setWindow(Window window) { Main.window = window; }

    private static MainUI ui;
    public static MainUI getMainUI() { return ui; }
    public static void setMainUI(MainUI ui) { Main.ui = ui; }
}
