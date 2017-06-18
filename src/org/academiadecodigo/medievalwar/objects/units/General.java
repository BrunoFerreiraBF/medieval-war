package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class General extends Mercenary implements Damageable, Damager {

    public General (int x, int y){
        super (x,y,MercenaryType.GENERAL,300,75,250,100,0,0.95);
    }


}
