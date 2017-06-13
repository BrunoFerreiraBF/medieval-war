package objects.terrain;

import field.grid.Grid;

/**
 * Created by codecadet on 12/06/2017.
 */
public class TerrainFactory {


    public Terrain makeTerrain(Grid grid,int col, int row) {

<<<<<<< HEAD
    public terrain[] maketerrain(int cells){


        terrain[] a= new terrain[cells];
=======
        Terrain ter;
>>>>>>> 8d92aff88fed191c069b9f2697729f58201bfb74

        double a=(int) (Math.random());

<<<<<<< HEAD
        for (int i = 0; i <cells ; i++) {
            int randim= (int) math.random()terraintype.values();
=======
>>>>>>> 8d92aff88fed191c069b9f2697729f58201bfb74

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



    public Terrain [] createTerrains(){

        Terrain [] terrains= new Terrain[grid.getCol*grid.getRows];
        for (int a = 0; a <terrains.length; a++) {

            for (int i = 0; i < grid.getCol; i++) {

                for (int j = 0; j <grid ; j++) {

                      terrains[a]= makeTerrain(gird,i,j);
                }
            }
        }
        return terrains;
    }





}
