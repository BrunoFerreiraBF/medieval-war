package objects.units;

import field.Position;
import objects.Damageable;
import objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Cavalry extends Mercenary implements Damageable, Damager {

    private double hp=120;

    public final MercenaryType type = MercenaryType.CAVALRY;

    public final double moveRange=50;

    public final double attackRange= 10;

    public final double damage=25;

    private Position pos;

    public final double accuracy=0.95;



    public Cavalry (double x, double y){
        super (x,y);
    }


    @Override
    public void hit(double damage) {

    }
}
