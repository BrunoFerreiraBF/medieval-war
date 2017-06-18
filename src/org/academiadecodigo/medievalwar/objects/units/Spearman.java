package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.field.Position;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.medievalwar.objects.Damager;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Spearman extends Mercenary implements Damageable, Damager {
/*
    private double hp = 84;

    public final MercenaryType type = MercenaryType.SPEARMAN;

    public final double moveRange = 30;

    public final double attackRange = 15;

    public final double damage = 60;

    public final double accuracy = 0.9;

    private static int cost = 65;

*/
    public Spearman(int x, int y) {
        super(x, y,MercenaryType.SPEARMAN,84,60,200,100,60,0.9);

    }

}
