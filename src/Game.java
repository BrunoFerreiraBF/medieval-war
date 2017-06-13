import objects.Damager;
import objects.terrain.Terrain;
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

<<<<<<< HEAD
=======

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

>>>>>>> 8d92aff88fed191c069b9f2697729f58201bfb74
}
