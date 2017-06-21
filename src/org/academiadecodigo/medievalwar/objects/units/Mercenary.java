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
    private double attackRange;
    private double accuracy;
    private MercenaryType type;
    private Position pos;
    private static int cost;
    private boolean dead = false;


    private boolean moved=false;

    public Mercenary(int x, int y, MercenaryType type, double hp, double damage, double moveRange, double attackRange, int cost, double accuracy) {

        this.type = type;
        pos = new Position(x, y);
        initialHp = hp;
        this.accuracy = accuracy;
        this.hp = hp;
        this.damage = damage;
        this.moveRange = moveRange;
        this.attackRange = attackRange;
        this.cost = cost;

    }

    public Mercenary() {
        initialHp = hp;
    }


    public static int getCost() {
        return cost;
    }

    public Picture getUnitPic() {
        return unitPic;
    }

    public double getMoveRange() {
        return moveRange;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public double getDamage() {

        return damage;
    }

    public Picture setUnitPic(Picture unitPic) {
        this.unitPic = unitPic;
        return unitPic;
    }

    public Position getPos() {
        return pos;
    }

    private boolean attacked;


    public boolean isAttacked() {
        return attacked;
    }
    public void hasAttacked() {
        attacked=true;
    }
    public void resetAttacked() {
        attacked=false;
    }


    public boolean isMoved() {

        return moved;

    }
    public void hasMoved() {
        moved=true;
    }
    public void resetMove() {
        moved=false;
    }

    public boolean isDead() {
        return dead;
    }


    @Override
    public void takeHit(double damage) {
        hp -= damage;
        if (hp < 0) {
            dead = true;
        }
    }

    @Override
    public double getHp() {
        return hp;
    }

    @Override
    public void hit(Damageable unit) {

        unit.takeHit(getDamage() * getHp() / initialHp);

        System.out.println("Gave " + (getDamage() * getHp() / initialHp + "damage");
    }

    @Override
    public String toString() {
        return "Mercenary{" +
                "type=" + type +
                '}';
    }


}
