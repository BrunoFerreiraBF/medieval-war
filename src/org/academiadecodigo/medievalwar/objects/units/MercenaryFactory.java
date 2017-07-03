package org.academiadecodigo.medievalwar.objects.units;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/06/2017.
 */
public class MercenaryFactory {


    public static Mercenary makeMercenary(int x, int y, Mercenary unit) {

            if (unit instanceof Archer) {

                Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p1/archer/BLUE_archer_RIGHT.png"));
                pic.draw();
                pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);


                Rectangle rec=new Rectangle(x,y,pic.getWidth() ,pic.getHeight() );
                rec.setColor(Color.BLACK);
                rec.draw();
                rec.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

//TODO: take the test square
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

                Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p2/general/RED_general_Static.png"));
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



    public static Mercenary makeMercenary2(int x, int y, Mercenary unit) {

        if (unit instanceof Archer) {

            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p2/archer/RED_archer_LEFT.png"));
            pic.draw();
            pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

            return unit;
        }

        if (unit instanceof Catapult) {

            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p2/catapult/RED_Catapult_LEFT.png"));
            pic.draw();
            pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

            return unit;
        }

        if (unit instanceof Cavalry) {

            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p2/cavalry/RED_kinights_LEFT.png"));
            pic.draw();
            pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

            return unit;
        }

        if (unit instanceof Cavalry_Archer) {

            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p2/cavalryarcher/RED_cavalryArcher_LEFT.png"));
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

            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p2/infantry/RED_soldier_LEFT.png"));
            pic.draw();
            pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

            return unit;
        }

        if (unit instanceof Spearman) {

            Picture pic = unit.setUnitPic(new Picture(x, y, "charset/p2/spearman/RED_spearman_LEFT.png"));
            pic.draw();
            pic.translate(-pic.getWidth() / 2,-pic.getHeight() / 2);

            return unit;
        }

        return unit;
    }



}
