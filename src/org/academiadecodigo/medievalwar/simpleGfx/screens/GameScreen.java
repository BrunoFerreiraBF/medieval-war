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


    //@Override
    public void init(Terrain[][] terrains, Grid grid, Mercenary[] p1units, Mercenary[] p2units) {

        this.terrains = terrains;
        this.p1units = p1units;
        this.p2units = p2units;
        this.grid = grid;

        drawTerrains(terrains, grid);

    }

    //@Override
    public void start() {
        draw();
    }

    //@Override
    public void draw() {

        drawUnits(p1units);
        drawUnits(p2units);
    }


   /* public void draw(Terrain[][] terrains, Grid grid, Mercenary[] units) {

        this.terrains = terrains;

        this.units = units;

        drawTerrains(terrains, grid);

        drawUnits(units);


    }
    */

    private void drawUnits(Mercenary[] units) {

        Picture picture;

        for (int i = 0; i < units.length; i++) {

            picture = units[i].getUnitPic();
            picture.draw();
        }
    }


    private void drawTerrains(Terrain[][] terrains, Grid grid) {

        Picture picture = null;

        for (int i = 0; i < terrains.length; i++) {

            for (int j = 0; j < terrains.length; j++) {

                if (terrains[i][j] instanceof Grass) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/SimpleGrass_Tile.png");

                }
                if (terrains[i][j] instanceof Mountain) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/Mountain_movable_Tile.png");

                }
                if (terrains[i][j] instanceof Forest) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/Forest_Tile.png");

                }
                if (terrains[i][j] instanceof Rock) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/Sand_Tile.png");

                }
                if (terrains[i][j] instanceof TallGrass) {
                    //System.out.println("in");
                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/Grass_to_Sand_Tiles_TOP-LEFT.png");
                }

                picture.draw();
            }
        }
    }


    //@Override
    public void update() {

        remove(p1units);

        remove(p2units);

        draw();
    }

    //@Override
    public void remove(Mercenary[] units) {

        Picture picture;

        for (int i = 0; i < units.length; i++) {

            picture = units[i].getUnitPic();
            picture.delete();
        }

    }
}
