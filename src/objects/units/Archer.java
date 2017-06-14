package objects.units;

import field.Position;
import objects.Damageable;
import objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Archer extends Mercenary implements Damageable, Damager {

    private double hp=36;

    public final MercenaryType type = MercenaryType.ARCHER;

    public final double moveRange=30;

    public final double attackRange= 160;

    public final double damage=63;

    public final double accuracy=0.8;


    public Archer(int x, int y){

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

    public Archer(){
        this.setInitialHp(hp);
    }




}
