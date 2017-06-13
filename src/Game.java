import field.grid.Grid;
import objects.Damager;
import objects.terrain.Terrain;
import objects.terrain.TerrainFactory;
import objects.units.Mercenary;
import simpleGfx.SimpleGfxGrid;
import simpleGfx.screens.GameScreen;
import simpleGfx.screens.ScreenManager;

public class Game {

    private boolean endTurn;

    private ScreenManager sm;

    private SimpleGfxGrid grid;

    private Terrain[][] terrains;

    public Game(){
        sm= new ScreenManager();

        grid= new SimpleGfxGrid(6,6);

        terrains=createTerrains(grid);


    }

    public void init(){
        grid.init();

    }

    public void start(){

        GameScreen gm= new GameScreen();

        gm.draw(terrains,grid);

    }


    private void turn(){

        while (!endTurn){

        // allow player actions

               //on click of ENDTURN ---> endTurn=true;
        }
    }


    public Terrain[][] createTerrains(Grid grid){

        Terrain [][] terrains= new Terrain[grid.getCols()][grid.getRows()];


            for (int i = 0; i < grid.getCols(); i++) {

                for (int j = 0; j < grid.getRows() ; j++) {

                    terrains[i][j] = TerrainFactory.makeTerrain(grid,i,j);

                    System.out.println( terrains[i][j].toString() );
                }
            }

        return terrains;
    }
}
