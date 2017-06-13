import field.grid.Grid;
import objects.Damager;
import objects.terrain.Terrain;
import objects.terrain.TerrainFactory;
import objects.units.Mercenary;
import simpleGfx.SimpleGfxGrid;
import simpleGfx.screens.ScreenManager;

public class Game {

    private boolean endTurn;

    private ScreenManager sm;

    private SimpleGfxGrid grid;

    private Terrain[] terrains;

    public Game(){

        grid= new SimpleGfxGrid(6,6);

        terrains=createTerrains(grid);


    }

    public void init(){
        grid.init();
        sm= new ScreenManager();

    }

    public void start(){
        turn();
    }



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
