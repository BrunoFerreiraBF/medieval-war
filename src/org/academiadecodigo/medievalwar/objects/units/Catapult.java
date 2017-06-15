package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Catapult extends Mercenary implements Damageable, Damager {

    private Picture unitPic;
    private double hp = 50;

    public final MercenaryType type = MercenaryType.CATAPULT;

    public final double moveRange = 20;

    public final double attackRange = 200;

    public final double damage = 55;

    public final double accuracy=0.70;

    private Position pos;

    private static int cost=80;

    public Catapult(int x, int y) {
        super(x, y,MercenaryType.CATAPULT);
        this.setInitialHp(hp);
    }

    @Override
    public double getMoveRange() {
        return moveRange;

    }

    public double getAttackRange() {
        return attackRange;
    }

    public Catapult(){
        this.setInitialHp(hp);
    }



    public static int getCost() {
        return cost;
    }
}
