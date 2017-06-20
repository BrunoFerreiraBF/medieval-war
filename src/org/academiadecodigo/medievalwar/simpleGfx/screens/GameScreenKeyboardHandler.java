package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 19/06/2017.
 */
public class GameScreenKeyboardHandler implements KeyboardHandler {


    private static boolean keySpace;



    private GameScreenMouseHandler gameScreenMouseHandler;

    public static boolean isKeySpace() {
        return keySpace;
    }


    public GameScreenKeyboardHandler() {



        Keyboard k = new Keyboard(this);

        KeyboardEvent SpacePressedEvent = new KeyboardEvent();
        SpacePressedEvent.setKey(KeyboardEvent.KEY_SPACE);
        SpacePressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(SpacePressedEvent);

    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

