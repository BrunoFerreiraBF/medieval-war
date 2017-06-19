package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Spearman extends Mercenary {

    public Spearman(int x, int y) {
        super(x, y,MercenaryType.SPEARMAN,84,60,200,100,60,0.9);

    }

}
