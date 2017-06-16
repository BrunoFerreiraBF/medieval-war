package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.field.grid.Grid;
import org.academiadecodigo.medievalwar.objects.terrain.*;
import org.academiadecodigo.medievalwar.objects.units.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;

/**
 * Created by codecadet on 13/06/17.
 */
public class GameScreen implements Screen {

    private Terrain[][] terrains;

    private Mercenary[] p1units;

    private Mercenary[] p2units;

    private Grid grid;



    public GameScreen(Terrain[][] terrains, Grid grid, Mercenary[] p1units, Mercenary[] p2units) {

        this.terrains = terrains;
        this.p1units = p1units;
        this.p2units = p2units;
        this.grid = grid;

        //drawTerrains(terrains, grid);  // IMPORTANTE

    }

    private void init(){

    }

    public void start() {
        draw();
    }


    public void draw() {

        drawUnits(p1units);
        drawUnits(p2units);
    }



    private void drawUnits(Mercenary[] units) {

        Picture picture;

        for (int i = 0; i < units.length; i++) {

            picture = units[i].getUnitPic();
            picture.draw();
        }
    }


    public void update() {

        remove(p1units);

        remove(p2units);

        draw();
    }


    public void remove(Mercenary[] units) {

        Picture picture;

        for (int i = 0; i < units.length; i++) {

            picture = units[i].getUnitPic();
            picture.delete();
        }

    }
}
