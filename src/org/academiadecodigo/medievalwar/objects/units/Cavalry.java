package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Cavalry extends Mercenary implements Damageable, Damager {

    /*
    private double hp = 105;

    public final MercenaryType type = MercenaryType.CAVALRY;

    public final double moveRange = 50;

    public final double attackRange = 10;

    public final double damage = 54;

    public final double accuracy = 0.95;

    private static int cost = 100;
*/

    public Cavalry(int x, int y) {
        super(x, y,MercenaryType.CAVALRY,105,54,350,100,100,0.95);
    }


}
