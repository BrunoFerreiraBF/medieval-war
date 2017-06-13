package objects.units;

import objects.Damageable;
import objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Infantry extends Mercenary implements Damageable, Damager {

    private double hp=135;

    public final MercenaryType type = MercenaryType.INFANTRY;

    public final double moveRange=35;

    public final double attackRange= 10;

    public final double damage=81;

    public final double accuracy=0.95;




    public Infantry(double x, double y){

        super(x,y);
        this.setInitialHp(hp);
    }




}
