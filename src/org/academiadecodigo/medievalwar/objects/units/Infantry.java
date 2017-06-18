package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Infantry extends Mercenary implements Damageable, Damager {
/*
    private Picture unitPic;

    private double hp=135;

    public final MercenaryType type = MercenaryType.INFANTRY;

    public final double moveRange=35;

    public final double attackRange= 10;

    public final double damage=81;

    public final double accuracy=0.95;

    private  static int cost=60;
*/

    public Infantry(int x, int y){
        super (x,y,MercenaryType.INFANTRY,135,81,250,100,60,0.95);
    }



}
