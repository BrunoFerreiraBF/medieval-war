package objects.units;

import field.Position;
import objects.Damageable;
import objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Catapult extends Mercenary implements Damageable, Damager {

    private double hp = 40;

    public final MercenaryType type = MercenaryType.CATAPULT;

    public final double moveRange = 50;

    public final double attackRange = 10;

    public final double damage = 30;

    public final double accuracy=0.70;

    private Position pos;


    public Catapult(double x, double y) {
        super(x, y);
    }


    @Override
    public void hit(double damage) {

    }
}
