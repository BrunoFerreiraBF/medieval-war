import objects.Damager;
import objects.terrain.Terrain;
import objects.units.Mercenary;

/**
 * Created by codecadet on 10/06/2017.
 */
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


    public Terrain[] createTerrains(){

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
