package simpleGfx.screens;

public class ScreenManager {

    private Screen screen = new MenuScreen();

    public void init(Screen screen) {
        this.screen = screen;
        this.screen.init();
    }

    public void start() {
        update();
        draw();
        //remove();
    }

    public void update() {
        screen.update();
    }

    public void draw() {
        screen.draw();
    }

    public void remove() {
        screen.remove();
    }

    public void changeScreen(Screen screen) {
        init(screen);
    }

    public void popScreen() {

    }
}
