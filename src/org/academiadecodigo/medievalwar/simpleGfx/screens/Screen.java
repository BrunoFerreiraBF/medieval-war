package org.academiadecodigo.medievalwar.simpleGfx.screens;

/**
 * Basic screen skeleton
 * @author João David Silva
 */

public interface Screen {

    /**
     * Initialize every thing in the game
     */
    void init();

    /**
     * Start the loop to draw the screen
     */
    void start();

    /**
     * Draw onto the screen
     */
    void draw();

    /**
     * Update movement on the screen
     */
    void update();

    /**
     * Remove entities when Screen is pop'ed off the stack
     */
    void remove();
}
