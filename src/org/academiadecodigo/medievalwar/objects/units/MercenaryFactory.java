package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.Damageable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/06/2017.
 */
public class MercenaryFactory {


    public static Mercenary makeMercenary(int x, int y, Mercenary unit, Player player){

        if( player.getName()=="p1"){

            if (unit instanceof Archer) {
                ((Archer) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Catapult) {
                ((Catapult) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Cavalry) {
                ((Cavalry) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Cavalry_Archer) {
                ((Cavalry_Archer) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof General) {
                ((General) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Infantry) {
                ((Infantry) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Spearman) {
                ((Spearman) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

        }
        if (player.getName()=="p2") {
            if (unit instanceof Archer) {
                ((Archer) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Catapult) {
                ((Catapult) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Cavalry) {
                ((Cavalry) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Cavalry_Archer) {
                ((Cavalry_Archer) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof General) {
                ((General) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Infantry) {
                ((Infantry) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

            if (unit instanceof Spearman) {
                ((Spearman) unit).setUnitPic(new Picture(x, y, "charset/RED_Archer_Static.png"));
            }

        }


        return unit;
    }




}
