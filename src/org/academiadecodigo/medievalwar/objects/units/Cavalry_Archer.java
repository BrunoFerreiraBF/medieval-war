package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Cavalry_Archer extends Mercenary implements Damageable, Damager {



    private double hp=105;

    public final MercenaryType type = MercenaryType.CAVALRY_ARCHER;

    public final double moveRange = 50;

    public final double attackRange =  120;

    public final double damage = 27;

    public final double accuracy = 0.8;

    private static int cost=94;

    public Cavalry_Archer(){
        this.setInitialHp(hp);
    }
    public Cavalry_Archer(int x, int y){

        super(x, y,MercenaryType.CAVALRY_ARCHER);
        this.setInitialHp(hp);
    }





}
