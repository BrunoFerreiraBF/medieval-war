package simpleGfx.screens;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Implementation of the menu screen
 * @author João David Silva
 */
public class MenuScreen implements Screen {
    private Rectangle rect;
    private final int PADDING = 10;

    private Rectangle rect2 = new Rectangle(50, 50, 50, 50);


    @Override
    public void init() {
        rect = new Rectangle(PADDING, PADDING, 960, 720);
        rect.setColor(Color.GREEN);
    }

    @Override
    public void start() {
        update();
        draw();
    }

    @Override
    public void draw() {
        rect.fill();
    }

    @Override
    public void update() {
        rect2.translate(10, 0);
    }

    @Override
    public void remove() {
        rect.delete();
    }
}
