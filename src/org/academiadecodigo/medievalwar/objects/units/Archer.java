package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Archer extends Mercenary {

    public Archer(int x, int y){

        super (x,y,MercenaryType.ARCHER,36,63,200,300,112,0.8);

    }


}
