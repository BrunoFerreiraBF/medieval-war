package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/06/2017.
 */
public class MercenaryFactory {


    public static Mercenary makeMercenary(int x, int y, Mercenary unit, Player player) {

        //if( player.getName()=="p1"){

        if (unit instanceof Archer) {
            //System.out.println("in create Archer image");

            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));

            pic.draw();

        }

        if (unit instanceof Catapult) {
            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));

            pic.draw();
        }

        if (unit instanceof Cavalry) {
            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));

            pic.draw();
        }

        if (unit instanceof Cavalry_Archer) {
            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));

            pic.draw();
        }

        if (unit instanceof General) {
            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));

            pic.draw();
        }

        if (unit instanceof Infantry) {
            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));

            pic.draw();
        }

        if (unit instanceof Spearman) {
            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));

            pic.draw();
        }


        return unit;
    }


}
