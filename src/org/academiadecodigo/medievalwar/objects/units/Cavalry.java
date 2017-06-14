package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Cavalry extends Mercenary implements Damageable, Damager {

    private double hp=105;

    public final MercenaryType type = MercenaryType.CAVALRY;

    public final double moveRange=50;

    public final double attackRange= 10;

    public final double damage=54;

    private Position pos;

    public final double accuracy=0.95;



    public Cavalry (int x, int y){
        super (x,y);
        this.setInitialHp(hp);
    }

    public Cavalry(){
        this.setInitialHp(hp);
    }

}
