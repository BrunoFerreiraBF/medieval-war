package objects.terrain;

import field.grid.Grid;

/**
 * Created by codecadet on 12/06/2017.
 */
public class TerrainFactory {


    public static Terrain makeTerrain(Grid grid,int col, int row) {

        Terrain ter;

        double a=(int) (Math.random());

        if (a>0.75){
            ter= new Grass(grid.makeGridPosition(col,row));
        }

        if (a>0.6){
            ter= new Mountain(grid.makeGridPosition(col,row));
        }

        if (a>0.45){
            ter = new Forest(grid.makeGridPosition(col,row));
        }

        if (a>0.3){
            ter = new Rock(grid.makeGridPosition(col,row));
        }

        else {
            ter = new TallGrass(grid.makeGridPosition(col,row));
        }

        return ter;

    }









}
