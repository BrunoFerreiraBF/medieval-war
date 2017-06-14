package objects.units;

import field.Position;
import objects.Damageable;
import objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Cavalry_Archer extends Mercenary implements Damageable, Damager {

    private double hp=105;

    public final MercenaryType type = MercenaryType.CAVALRY_ARCHER;

    public final double moveRange = 50;

    public final double attackRange =  120;

    public final double damage = 27;

    private Position pos;

    public final double accuracy = 0.8;



    public Cavalry_Archer(int x, int y){

        super (x,y);
        this.setInitialHp(hp);
    }

    @Override
    public double getMoveRange() {
        return moveRange;

    }

    public double getAttackRange() {
        return attackRange;
    }

    public Cavalry_Archer(){
        this.setInitialHp(hp);
    }

}
