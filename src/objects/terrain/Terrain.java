package objects.terrain;

import field.Position;

/**
 * Created by codecadet on 12/06/2017.
 */
public abstract class Terrain {

    private double damageMultiplier;

    private double accuraryMultiplier ;

    private Position pos;

    public Terrain(){}

    public Terrain(int x,int y){

        pos= new Position(x,y);
    }

    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public void setAccuracyMultiplier(double accuracyMultiplier) {
        this.accuraryMultiplier = accuracyMultiplier;
    }
}
