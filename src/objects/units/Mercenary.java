package objects.units;

import field.Position;
import objects.Damageable;
import objects.Damager;

/**
 * Created by codecadet on 10/06/2017.
 */
public abstract class Mercenary implements Damageable, Damager {

    private double initialHp;
    private double hp;

    public double damage;

    private MercenaryType type;

    private Position pos;

    public Mercenary(int x, int y){

        pos= new Position(x,y);
        initialHp=hp;
    }
    public Mercenary(){
        initialHp=hp;
    }

    @Override
    public void takeHit(double damage) {
        hp-=damage;
    }

    @Override
    public double getHp() {
        return hp;
    }

    @Override
    public void hit(Damageable unit){
        unit.takeHit(getDamage()*initialHp/getHp());

    }

    public void setInitialHp(double initialHp) {
        this.initialHp = initialHp;
    }

    public double getDamage(){

        return damage;
    }

    public Position getPos() {
        return pos;
    }
}
