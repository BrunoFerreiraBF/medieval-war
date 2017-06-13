package objects.units;

import field.Position;
import objects.Damageable;
import objects.Damager;
import objects.units.Mercenary;
import objects.units.MercenaryType;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Spearman extends Mercenary implements Damageable, Damager {

    private double hp = 84;

    public final MercenaryType type = MercenaryType.SPEARMAN;

    public final double moveRange = 30;

    public final double attackRange = 15;

    public final double damage = 60;

    public final double accuracy=0.9;

    private Position pos;


    public Spearman(double x, double y) {
        super(x, y);
        this.setInitialHp(hp);
    }


}
