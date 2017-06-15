package org.academiadecodigo.medievalwar.simpleGfx.screens;

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



    public void init() {
        rect = new Rectangle(PADDING, PADDING, 960, 720);
        rect.setColor(Color.GREEN);
    }


    public void start() {
        update();
        draw();
    }


    public void draw() {
        rect.fill();
    }


    public void update() {
        rect2.translate(10, 0);
    }


    public void remove() {
        rect.delete();
    }
}
