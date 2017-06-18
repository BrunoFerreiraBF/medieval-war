package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/06/2017.
 */
public class MercenaryFactory {


    public static Mercenary makeMercenary(int x, int y, Mercenary unit, Player player) {

            if (unit instanceof Archer) {

                Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p1/archer/BLUE_archer_RIGHT.png"));
                pic.draw();
                pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

                return unit;
            }

            if (unit instanceof Catapult) {

                Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p1/catapult/BLUE_catapult_RIGHT.png"));
                pic.draw();
                pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

                return unit;
            }

            if (unit instanceof Cavalry) {

                Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p1/cavalry/BLUE_cavalry_RIGHT.png"));
                pic.draw();
                pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

                return unit;
            }

            if (unit instanceof Cavalry_Archer) {

                Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p1/cavalryarcher/BLUE_cavalryarcher_RIGHT.png"));
                pic.draw();
                pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

                return unit;
            }

            if (unit instanceof General) {

                Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p1/general/BLUE_general_Static.png"));
                pic.draw();
                pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

                return unit;
            }

            if (unit instanceof Infantry) {

                Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p1/infantry/BLUE_soldier_RIGHT.png"));
                pic.draw();
                pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

                return unit;
            }

            if (unit instanceof Spearman) {

                Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p1/spearman/BLUE_spearman_RIGHT.png"));
                pic.draw();
                pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

                return unit;
            }

        return unit;
    }


}
