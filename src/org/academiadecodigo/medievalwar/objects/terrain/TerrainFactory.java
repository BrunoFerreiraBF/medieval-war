package org.academiadecodigo.medievalwar.objects.terrain;

import org.academiadecodigo.medievalwar.field.grid.Grid;

/**
 * Created by codecadet on 12/06/2017.
 */
public class TerrainFactory {


    public static Terrain makeTerrain(Grid grid,int col, int row) {

        Terrain ter;

        double a= (Math.random());

        if (a>0.75){
            //System.out.println("made grass");
            ter= new Grass(grid.makeGridPosition(col,row));

            return ter;
        }

        if (a>0.6){
            //System.out.println("made mountain");
            ter= new Mountain(grid.makeGridPosition(col,row));

            return ter;
        }

        if (a>0.45){
            //System.out.println("made forest");
            ter = new Forest(grid.makeGridPosition(col,row));

            return ter;
        }

        if (a>0.3){
            //System.out.println("made rock");
            ter = new Rock(grid.makeGridPosition(col,row));

            return ter;
        }

        else {
            ter = new TallGrass(grid.makeGridPosition(col,row));
            //System.out.println("made sand");
            return ter;
        }




    }









}
