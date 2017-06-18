package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Infantry extends Mercenary implements Damageable, Damager {

    public Infantry(int x, int y){
        super (x,y,MercenaryType.INFANTRY,135,81,250,100,60,0.95);
    }



}
