package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 16/06/2017.
 */
public class EndScreen implements KeyboardHandler {


    private Picture endScreen;


    public EndScreen(Picture pic) {

        endScreen=pic;

        Keyboard k = new Keyboard(this);
/*
        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(spacePressed);
*/
        KeyboardEvent qPressed = new KeyboardEvent();
        qPressed.setKey(KeyboardEvent.KEY_Q);
        qPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(qPressed);

    }

    public void Start() {

        endScreen.draw();
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_SPACE:

                endScreen.delete();

                break;
            case KeyboardEvent.KEY_Q:
                System.out.println("Finish Screen");
                System.exit(0);
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
