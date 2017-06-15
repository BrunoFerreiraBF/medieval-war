package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class General extends Mercenary implements Damageable, Damager {

    private Picture unitPic;

    private double hp=300;

    public final MercenaryType type = MercenaryType.GENERAL;

    public final double moveRange=40;

    public final double attackRange= 10;

    public final double damage = 90;

    private Position pos;

    public final double accuracy=0.95;



    public General (int x, int y){
        super(x, y,MercenaryType.GENERAL);
        this.setInitialHp(hp);
    }

    @Override
    public double getMoveRange() {
        return moveRange;

    }

    public double getAttackRange() {
        return attackRange;
    }

    public General(){
        this.setInitialHp(hp);
    }
}
