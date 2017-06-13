import field.grid.Grid;
import objects.Damager;
import objects.terrain.Terrain;
import objects.terrain.TerrainFactory;
import objects.units.Mercenary;

public class Game {

    private boolean endTurn;

    private Mercenary[] player1;
    private Mercenary[] player2;

    public Game(){}

    public void init(){}

    public void start(){}

    private void turn(){

        while (!endTurn){

        // allow player actions

               //on click of ENDTURN ---> endTurn=true;
        }
    }

    private Damager Buy(){
        return null;
    }

    public Terrain[] createTerrains(Grid grid){

        Terrain [] terrains= new Terrain[grid.getCols()*grid.getRows()];
        for (int a = 0; a <terrains.length; a++) {

            for (int i = 0; i < grid.getCols(); i++) {

                for (int j = 0; j < grid.getRows() ; j++) {

                    terrains[a] = TerrainFactory.makeTerrain(grid,i,j);
                }
            }
        }
        return terrains;
    }

}
