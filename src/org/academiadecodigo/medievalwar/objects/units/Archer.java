package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Archer extends Mercenary implements Damageable, Damager {

    private Picture unitPic;

    private double hp=36;

    public final MercenaryType type = MercenaryType.ARCHER;

    public final double moveRange=30;

    public final double attackRange= 160;

    public final double damage=63;

    public final double accuracy=0.8;

    private static int cost=112;


    public Archer(int x, int y){

        super (x,y,MercenaryType.ARCHER);

        this.setInitialHp(hp);
    }

    @Override
    public double getMoveRange() {
        return moveRange;

    }

    public double getAttackRange() {
        return attackRange;
    }

    public Archer(){
        this.setInitialHp(hp);
    }

    public Picture setUnitPic(Picture unitPic) {
        this.unitPic = unitPic;
        return unitPic;
    }

    public static int getCost() {
        return cost;
    }
}
