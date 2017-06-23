package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Cavalry extends Mercenary  {

    public Cavalry(int x, int y) {
        super(x, y,MercenaryType.CAVALRY,105,54,350,150,100,0.95);
    }


}
