package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Catapult extends Mercenary {

    public Catapult(int x, int y) {
        super(x, y,MercenaryType.CATAPULT,50,55,100,500,80,0.7);

    }



}
