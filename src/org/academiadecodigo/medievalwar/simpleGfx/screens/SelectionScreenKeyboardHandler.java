package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 15/06/17.
 */
public class SelectionScreenKeyboardHandler implements KeyboardHandler {

    private boolean key1;
    private boolean key2;
    private boolean key3;
    private boolean key4;
    private boolean key5;
    private boolean key6;


    public boolean isKey1() {
        return key1;
    }

    public boolean isKey2() {
        return key2;
    }

    public boolean isKey3() {
        return key3;
    }

    public boolean isKey4() {
        return key4;
    }

    public boolean isKey5() {
        return key5;
    }

    public boolean isKey6() {
        return key6;
    }

    public SelectionScreenKeyboardHandler() {

        Keyboard k = new Keyboard(this);

        KeyboardEvent onePressedEvent = new KeyboardEvent();
        onePressedEvent.setKey(KeyboardEvent.KEY_1);
        onePressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent oneReleasedEvent = new KeyboardEvent();
        oneReleasedEvent.setKey(KeyboardEvent.KEY_1);
        oneReleasedEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent twoPressedEvent = new KeyboardEvent();
        twoPressedEvent.setKey(KeyboardEvent.KEY_2);
        twoPressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent twoReleasedEvent = new KeyboardEvent();
        twoReleasedEvent.setKey(KeyboardEvent.KEY_2);
        twoReleasedEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent threePressedEvent = new KeyboardEvent();
        threePressedEvent.setKey(KeyboardEvent.KEY_3);
        threePressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent threeReleasedEvent = new KeyboardEvent();
        threeReleasedEvent.setKey(KeyboardEvent.KEY_3);
        threeReleasedEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent fourPressedEvent = new KeyboardEvent();
        fourPressedEvent.setKey(KeyboardEvent.KEY_4);
        fourPressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent fourReleasedEvent = new KeyboardEvent();
        fourReleasedEvent.setKey(KeyboardEvent.KEY_4);
        fourReleasedEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent fivePressedEvent = new KeyboardEvent();
        fivePressedEvent.setKey(KeyboardEvent.KEY_5);
        fivePressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent fiveReleasedEvent = new KeyboardEvent();
        fiveReleasedEvent.setKey(KeyboardEvent.KEY_5);
        fiveReleasedEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent sixPressedEvent = new KeyboardEvent();
        sixPressedEvent.setKey(KeyboardEvent.KEY_6);
        sixPressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent sixReleasedEvent = new KeyboardEvent();
        sixReleasedEvent.setKey(KeyboardEvent.KEY_6);
        sixReleasedEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(onePressedEvent);
        k.addEventListener(twoPressedEvent);
        k.addEventListener(threePressedEvent);
        k.addEventListener(fourPressedEvent);
        k.addEventListener(fivePressedEvent);
        k.addEventListener(sixPressedEvent);

        k.addEventListener(oneReleasedEvent);
        k.addEventListener(twoReleasedEvent);
        k.addEventListener(threeReleasedEvent);
        k.addEventListener(fourReleasedEvent);
        k.addEventListener(fiveReleasedEvent);
        k.addEventListener(sixReleasedEvent);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_1:


                key1=true;
                break;

            case KeyboardEvent.KEY_2:
                key2=true;
                break;

            case KeyboardEvent.KEY_3:
                key3=true;
                break;

            case KeyboardEvent.KEY_4:
                key4=true;
                break;

            case KeyboardEvent.KEY_5:
                key5=true;
                break;

            case KeyboardEvent.KEY_6:
                key6=true;
                break;

        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_1:
                key1=false;

                break;

            case KeyboardEvent.KEY_2:
                key2=false;
                break;

            case KeyboardEvent.KEY_3:
                key3=false;
                break;

            case KeyboardEvent.KEY_4:
                key4=false;
                break;

            case KeyboardEvent.KEY_5:
                key5=false;
                break;

            case KeyboardEvent.KEY_6:
                key6=false;
                break;

        }
    }
}
