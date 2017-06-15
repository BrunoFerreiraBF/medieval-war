package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Spearman extends Mercenary implements Damageable, Damager {

    private Picture unitPic;

    private double hp = 84;

    public final MercenaryType type = MercenaryType.SPEARMAN;

    public final double moveRange = 30;

    public final double attackRange = 15;

    public final double damage = 60;

    public final double accuracy = 0.9;

    private Position pos;
    private static int cost = 65;

    public Spearman(int x, int y) {
        super(x, y,MercenaryType.SPEARMAN);
        this.setInitialHp(hp);
    }

    @Override
    public double getMoveRange() {
        return moveRange;

    }

    public double getAttackRange() {
        return attackRange;
    }

    public Spearman() {
        this.setInitialHp(hp);
    }
    public static int getCost() {
        return cost;
    }
}
