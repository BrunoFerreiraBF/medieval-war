package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Implementation of the menu screen
 *
 * @author João David Silva
 */
public class MenuScreen implements Screen, KeyboardHandler {

    private boolean spacePressed;

    private Picture menuScreen = new Picture(SimpleGfxGrid.PADDING, SimpleGfxGrid.PADDING, "game_screens/fullScreen_init.jpg");


    public MenuScreen() {
        Keyboard k = new Keyboard(this);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(spacePressed);

    }

    public void Start() {

        menuScreen.draw();
    }

    public boolean isSpacePressed() {
        return spacePressed;
    }

    public void setSpacePressed(boolean spacePressed) {
        this.spacePressed = spacePressed;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_SPACE:

                spacePressed = true;
                menuScreen.delete();
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
