package objects.units;

import field.Position;
import objects.Damageable;
import objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Archer extends Mercenary implements Damageable, Damager {

    private double hp=75;

    public final MercenaryType type = MercenaryType.ARCHER;

    public final double moveRange=30;

    public final double attackRange= 30;

    public final double damage=20;

    private Position pos;

    public final double accuracy=0.8;


    public Archer(double x, double y){
        super (x,y);
    }


    @Override
    public void hit(double damage) {

    }


}
