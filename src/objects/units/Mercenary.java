package objects.units;

import field.Position;
import objects.Damageable;
import objects.Damager;

/**
 * Created by codecadet on 10/06/2017.
 */
public abstract class Mercenary implements Damageable, Damager {


    private double hp;

    public double damage;

    private MercenaryType type;

    private Position pos;

    public Mercenary(double x, double y){

        pos= new Position(x,y);
    }

    @Override
    public void takeHit(double damage) {
        hp-=damage;
    }

    @Override
    public double getHp() {
        return hp;
    }


    public abstract void hit(double damage);

    public double getDamage(){

        return damage;
    }


}
