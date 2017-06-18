package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Cavalry_Archer extends Mercenary implements Damageable, Damager {

    public Cavalry_Archer(int x, int y){

        super (x,y,MercenaryType.CAVALRY_ARCHER,105,27,250,200,94,0.75);

    }




}
