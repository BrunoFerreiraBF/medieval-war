package simpleGfx.screens;

import field.grid.Grid;
import objects.terrain.*;
import objects.units.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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


    public  void draw(Terrain[] terrains,Mercenary[] units,Grid grid) {

        this.drawTerrains(terrains, grid);
        drawUnits(units);
    }

    private void drawUnits(Mercenary[] units){

        Mercenary picture;

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

                //picture = ArcherImage;
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

    private void drawTerrains(Terrain[] terrains, Grid grid) {

        Picture picture;

        for (int i = 0; i < terrains.length; i++) {


            if (terrains[i] instanceof Grass) {

                // picture = GrassImage;
            }
            if (terrains[i] instanceof Mountain) {

                 //picture = MountainImage;
            }
            if (terrains[i] instanceof Forest) {

                 //picture = ForestImage;
            }
            if (terrains[i] instanceof Rock) {

                 //picture = TallGrassImage;
            }
            else {

                 //picture = GrassImage;
            }

            //picture.draw();

        }
    }





    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }
}
