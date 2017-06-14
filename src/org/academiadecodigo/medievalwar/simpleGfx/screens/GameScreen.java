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



    @Override
    public void init() {

    }

    @Override
    public void start() {

    }

    @Override
    public void draw() {

    }


    public void draw(Terrain[][] terrains,Grid grid) {

        this.drawTerrains(terrains, grid);
        //drawUnits(units);
    }

    private void drawUnits(Mercenary[] units){

        Picture picture;

        for (int i = 0; i < units.length; i++) {

            if (units[i] instanceof General) {

                //picture = GeneralImage;
            }
            if (units[i] instanceof Spearman) {

                //picture = SpearmanImage;
            }
            if (units[i] instanceof Infantry) {

                //picture = InfantryImage;
            }
            if (units[i] instanceof Cavalry) {

                //picture = CavalryImage;
            }
            if (units[i] instanceof Archer) {

                picture = new Picture(10,10,"charset/RED_Archer_Static.png");
            }

            if (units[i] instanceof Cavalry_Archer) {

                //picture = Cavalry_ArcherImage;
            }

            if (units[i] instanceof Cavalry) {

                //picture = CavalryImage;
            }

            else {

                //picture = CatapultImage;
            }

            //picture.draw();

        }
    }

    private void drawTerrains(Terrain[][] terrains, Grid grid) {

        Picture picture=null;

        for (int i = 0; i < terrains.length; i++) {

            for (int j = 0; j <terrains.length ; j++) {

                if (terrains[i][j] instanceof Grass) {

                    picture = new Picture(SimpleGfxGrid.PADDING+i* SimpleGfxGrid.CELLWIDTH,SimpleGfxGrid.PADDING+j*SimpleGfxGrid.CELLHEIGHT,"chipset_tiles/SimpleGrass_Tile.png");

                }
                if (terrains[i][j] instanceof Mountain) {

                    picture = new Picture(SimpleGfxGrid.PADDING+i* SimpleGfxGrid.CELLWIDTH,SimpleGfxGrid.PADDING+j*SimpleGfxGrid.CELLHEIGHT,"chipset_tiles/Mountain_movable_Tile.png");

                }
                if (terrains[i][j] instanceof Forest) {

                    picture = new Picture(SimpleGfxGrid.PADDING+i* SimpleGfxGrid.CELLWIDTH,SimpleGfxGrid.PADDING+j*SimpleGfxGrid.CELLHEIGHT,"chipset_tiles/Forest_Tile.png");

                }
                if (terrains[i][j] instanceof Rock) {

                    picture = new Picture(SimpleGfxGrid.PADDING+i* SimpleGfxGrid.CELLWIDTH,SimpleGfxGrid.PADDING+j*SimpleGfxGrid.CELLHEIGHT,"chipset_tiles/Sand_Tile.png");

                }
                if (terrains[i][j] instanceof TallGrass){
                    //System.out.println("in");
                    picture = new Picture(SimpleGfxGrid.PADDING+i* SimpleGfxGrid.CELLWIDTH,SimpleGfxGrid.PADDING+j*SimpleGfxGrid.CELLHEIGHT,"chipset_tiles/Grass_to_Sand_Tiles_TOP-LEFT.png");
                }

                picture.draw();
            }
        }
    }





    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }
}
