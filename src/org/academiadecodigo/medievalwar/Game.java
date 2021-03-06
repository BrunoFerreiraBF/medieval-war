package org.academiadecodigo.medievalwar;

import org.academiadecodigo.medievalwar.field.grid.Grid;
import org.academiadecodigo.medievalwar.objects.terrain.Terrain;
import org.academiadecodigo.medievalwar.objects.terrain.TerrainFactory;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.medievalwar.simpleGfx.screens.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game {

    private SimpleGfxGrid grid;

    private Terrain[][] terrains;

    private Player p1;

    private Player p2;



    public void init() {

        grid = new SimpleGfxGrid(6, 6);

        terrains = createTerrains(grid);

        p1 = new Player();

        p2 = new Player();

        grid.init();
    }

    public void start() {

        MenuScreen menuScreen = new MenuScreen();
        //menuScreen.setSpacePressed(true);


        while (!menuScreen.isSpacePressed()) {
            menuScreen.Start();
        }

        SelectionScreen selectionScreen = new SelectionScreen(p1, p2, grid, terrains);


        //SelectionScreenKeyboardHandler.setTurnCounter(true);

        selectionScreen.init();

        while (!SelectionScreenKeyboardHandler.isStartGameScreen()) {

        }


        selectionScreen.remove(p1.getUnits());
        selectionScreen.remove(p2.getUnits());


        GameScreen gameScreen = new GameScreen(terrains, grid, p1, p2);

        gameScreen.init();
        gameScreen.start();

    }


    public Terrain[][] createTerrains(Grid grid) {

        Terrain[][] terrains = new Terrain[grid.getCols()][grid.getRows()];

        for (int i = 0; i < grid.getCols(); i++) {
            for (int j = 0; j < grid.getRows(); j++) {

                terrains[i][j] = TerrainFactory.makeTerrain(grid, i, j);
            }
        }
        return terrains;
    }
}
