package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/06/2017.
 */
public abstract class Mercenary implements Damageable, Damager {

    private Picture unitPic;

    private double initialHp;

    private double hp;

    public double damage;

    private double moveRange;

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

    public Picture getUnitPic() {
        return unitPic;
    }

    public double getMoveRange() {
        return moveRange;
    }

    public void setInitialHp(double initialHp) {
        this.initialHp = initialHp;
    }

    public double getDamage(){

        return damage;
    }


    public void setUnitPic(Picture unitPic) {
        this.unitPic = unitPic;
    }

    public Position getPos() {
        return pos;
    }
}
