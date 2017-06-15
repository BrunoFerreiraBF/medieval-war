package org.academiadecodigo.medievalwar;

import org.academiadecodigo.medievalwar.field.grid.Grid;
import org.academiadecodigo.medievalwar.objects.terrain.Terrain;
import org.academiadecodigo.medievalwar.objects.terrain.TerrainFactory;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.medievalwar.simpleGfx.screens.GameScreen;
import org.academiadecodigo.medievalwar.simpleGfx.screens.ScreenManager;

public class Game {

    private boolean endTurn;

    private ScreenManager sm;

    private SimpleGfxGrid grid;

    private Terrain[][] terrains;

    public Game(){
        sm= new ScreenManager();

        grid= new SimpleGfxGrid(6,6);

        terrains=createTerrains(grid);

        Player p1=new Player("p1");
        Player p2=new Player("p2");

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

                    //System.out.println( terrains[i][j].toString() );
                }
            }

        return terrains;
    }
}
