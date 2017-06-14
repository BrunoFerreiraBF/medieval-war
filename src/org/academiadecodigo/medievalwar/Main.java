package org.academiadecodigo.medievalwar;

/**
 * Test game screens
 * @author João David Silva
 */
public class Main {

    public static final int WIDTH = 960;
    public static final int HEIGHT = 720;

    public static void main(String[] args) throws InterruptedException {


        Game g =new Game();
        g.init();
        g.start();


    }

}
