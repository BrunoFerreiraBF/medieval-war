package objects.units;

import field.Position;
import objects.Damageable;
import objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class General extends Mercenary implements Damageable, Damager {

    private double hp=300;

    public final MercenaryType type = MercenaryType.GENERAL;

    public final double moveRange=40;

    public final double attackRange= 10;

    public final double damage = 90;

    private Position pos;

    public final double accuracy=0.95;



    public General (double x, double y){
        super (x,y);
        this.setInitialHp(hp);
    }


}
