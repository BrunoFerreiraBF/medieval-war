package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.field.grid.Grid;
import org.academiadecodigo.medievalwar.objects.terrain.*;
import org.academiadecodigo.medievalwar.objects.units.*;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 13/06/17.
 */
public class SelectionScreen implements MouseHandler {

    private Player p1;
    private Player p2;
    private Mercenary[] mercenaries;

    private SelectionScreenKeyboardHandler keyboardHandler = new SelectionScreenKeyboardHandler();


    public SelectionScreen(Player p1, Player p2) {

        this.p1 = p1;
        this.mercenaries = p1.getUnits();

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

    }

    public void setPlayerUnits() {
        // player.setUnits(mercenaries);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY();

        //if (isThereMercenary(mouseX, mouseY)) {
          //  System.out.println("there is a mercenary there");
            //return;}

        if (mouseX > 320 && mouseX < 660) {
            System.out.println("wrong place");
            return;
        }
        Player player = null;

        if (mouseX < 320) {
            player = p1;
        }
        if (mouseX > 640) {
            player = p2;
        }


        for (int i = 0; i < mercenaries.length; i++) {
            if (mercenaries[i] == null) {

                if (keyboardHandler.isKey1()) {

                    //System.out.println(player.getGold()+" "+Archer.getCost());

                    if (player.getGold()<Archer.getCost()){
                        //System.out.println(player.getGold()+" not enough gold "+Archer.getCost());
                        return;
                    }

                    player.spendGold(Archer.getCost());

                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Archer(mouseX, mouseY), player);
                }

                if (keyboardHandler.isKey2()) {

                    if (player.getGold()<Catapult.getCost()){
                        System.out.println(player.getGold()+"not enough gold"+Catapult.getCost());
                        return;
                    }

                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Catapult(mouseX, mouseY), player);


                }

                if (keyboardHandler.isKey3()) {
                    if (player.getGold()<Cavalry.getCost()){
                        //System.out.println(player.getGold()+" not enough gold "+Archer.getCost());
                        return;
                    }

                    player.spendGold(Cavalry.getCost());
                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Cavalry(mouseX, mouseY), player);


                }

                if (keyboardHandler.isKey4()) {

                    if (player.getGold()<Cavalry_Archer.getCost()){
                        //System.out.println(player.getGold()+" not enough gold "+Cavalry_Archer.getCost());
                        return;
                    }

                    player.spendGold(Cavalry_Archer.getCost());

                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Cavalry_Archer(mouseX, mouseY), player);


                }

                if (keyboardHandler.isKey5()) {
                    if (player.getGold()<Infantry.getCost()){
                        //System.out.println(player.getGold()+" not enough gold "+Infantry.getCost());
                        return;
                    }

                    player.spendGold(Infantry.getCost());

                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Infantry(mouseX, mouseY), player);


                }

                if (keyboardHandler.isKey6()) {
                    if (player.getGold()<Spearman.getCost()){
                        //System.out.println(player.getGold()+" not enough gold "+Spearman.getCost());
                        return;
                    }

                    player.spendGold(Spearman.getCost());


                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Spearman(mouseX, mouseY), player);


                }

                return;

            }

        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void init(Terrain[][] terrains, SimpleGfxGrid grid) {

        drawTerrains(terrains, grid);
    }


    private void drawTerrains(Terrain[][] terrains, Grid grid) {

        Picture picture = null;

        for (int i = 0; i < terrains.length; i++) {

            for (int j = 0; j < terrains.length; j++) {

                if (terrains[i][j] instanceof Grass) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "Chipset Tiles/grass.png");

                }
                if (terrains[i][j] instanceof Mountain) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "Chipset Tiles/mountain.png");

                }
                if (terrains[i][j] instanceof Forest) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "Chipset Tiles/forest.png");

                }
                if (terrains[i][j] instanceof Rock) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "Chipset Tiles/rock.png");

                }
                if (terrains[i][j] instanceof Sand) {
                    //System.out.println("in");
                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "Chipset Tiles/sand.png");
                }

                picture.draw();
            }
        }
    }

    public Mercenary verifyMercenary(int mouseX, int mouseY) {

        for (int i = 0; i < mercenaries.length; i++) {

            if (mercenaries[i].getPos().getX() < mouseX && mouseX < mercenaries[i].getPos().getX() + mercenaries[i].getUnitPic().getWidth()
                    && mercenaries[i].getPos().getY() < mouseY && mouseY < mercenaries[i].getPos().getY() + mercenaries[i].getUnitPic().getHeight()) {

                return mercenaries[i];

            }
        }
        return null;
    }

    public boolean isThereMercenary(int mouseX, int mouseY) {

        for (int i = 0; i < mercenaries.length; i++) {

            if (mercenaries[i].getPos().getX() == 0) {
                break;
            }

            if (mercenaries[i].getPos().getX() < mouseX && mouseX < mercenaries[i].getPos().getX() + mercenaries[i].getUnitPic().getWidth()
                    && mercenaries[i].getPos().getY() < mouseY && mouseY < mercenaries[i].getPos().getY() + mercenaries[i].getUnitPic().getHeight()) {

                return true;
            }
        }
        return false;
    }
}
