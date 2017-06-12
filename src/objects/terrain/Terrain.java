package objects.terrain;

import field.Position;

/**
 * Created by codecadet on 12/06/2017.
 */
public abstract class Terrain {

    private double damageMultiplier;

    private Position pos;

    public Terrain(){}

    public Terrain(int x,int y){

        pos= new Position(x,y);
    }





}
