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

    private Terrain[][] terrains;

    private SimpleGfxGrid grid;

    private SelectionScreenKeyboardHandler keyboardHandler = new SelectionScreenKeyboardHandler();


    public SelectionScreen(Player p1, Player p2, SimpleGfxGrid grid, Terrain[][] terrains) {

        this.p1 = p1;
        this.p2 = p2;
        this.grid = grid;
        this.terrains = terrains;
        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

    }

    public void init() {
        Picture rules = new Picture(960 / 3 + SimpleGfxGrid.PADDING, SimpleGfxGrid.PADDING, "game_screens/pickScreen.jpg");

        drawTerrains(terrains);
        rules.draw();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {


        int mouseX = (int) mouseEvent.getX() - 10;
        int mouseY = (int) mouseEvent.getY() - 33;

        if (verifyMercenary(mouseX, mouseY) != null) {

            System.out.println("there is a mercenary there");

            return;
        }

        Terrain terrain = verifyTerrain(mouseX + 10, mouseY + 33);

        if (terrain instanceof Rock) {
            System.out.println("cant place unit o rock");
            return;
        }

        if (mouseX > 320 && mouseX < 640) {
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

        System.out.println(p1.toString());

        System.out.println(p2.toString());

        mouseX += 10;
        mouseY += 10;

        for (int i = 0; i < 20; i++) {


            if (player.getUnits()[i] == null) {

                if (keyboardHandler.isKey1()) {


                    if (player.getGold() < Archer.getCost()) {

                        return;
                    }

                    player.spendGold(Archer.getCost());

                    player.getUnits()[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Archer(mouseX, mouseY), player);

                    //System.out.println(player.getUnits()[i].getPos().getX()+" equal "+mouseX+"  "+player.getUnits()[i].getPos().getY()+" equal "+mouseY);
                }

                if (keyboardHandler.isKey2()) {

                    if (player.getGold() < Catapult.getCost()) {
                        System.out.println(player.getGold() + "not enough gold" + Catapult.getCost());
                        return;
                    }

                    player.getUnits()[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Catapult(mouseX, mouseY), player);


                }

                if (keyboardHandler.isKey3()) {
                    if (player.getGold() < Cavalry.getCost()) {

                        return;
                    }

                    player.spendGold(Cavalry.getCost());
                    player.getUnits()[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Cavalry(mouseX, mouseY), player);


                }

                if (keyboardHandler.isKey4()) {

                    if (player.getGold() < Cavalry_Archer.getCost()) {

                        return;
                    }

                    player.spendGold(Cavalry_Archer.getCost());

                    player.getUnits()[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Cavalry_Archer(mouseX, mouseY), player);


                }

                if (keyboardHandler.isKey5()) {
                    if (player.getGold() < Infantry.getCost()) {

                        return;
                    }

                    player.spendGold(Infantry.getCost());

                    player.getUnits()[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Infantry(mouseX, mouseY), player);


                }

                if (keyboardHandler.isKey6()) {
                    if (player.getGold() < Spearman.getCost()) {

                        return;
                    }

                    player.spendGold(Spearman.getCost());


                    player.getUnits()[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Spearman(mouseX, mouseY), player);

                }
                return;
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        System.out.println(mouseEvent.getX() - 10 + " " + (mouseEvent.getY() - 33));

        Terrain terrain = verifyTerrain(((int) mouseEvent.getX()), ((int) mouseEvent.getY()));
        System.out.println(terrain.toString());


        Mercenary mercenary = verifyMercenary(((int) mouseEvent.getX()), ((int) mouseEvent.getY()));

        System.out.println(mercenary);
        // System.out.println(mercenary.toString());

    }


    private void drawTerrains(Terrain[][] terrains) {

        Picture picture = null;

        this.terrains = terrains;

        for (int i = 0; i < terrains.length; i++) {

            for (int j = 0; j < terrains.length; j++) {

                if (terrains[i][j] instanceof Grass) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/grass.png");

                }
                if (terrains[i][j] instanceof Mountain) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/mountain.png");

                }
                if (terrains[i][j] instanceof Forest) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/forest.png");

                }
                if (terrains[i][j] instanceof Rock) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/rock.png");

                }
                if (terrains[i][j] instanceof Sand) {
                    //System.out.println("in");
                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/sand.png");
                }

                picture.draw();
            }
        }
    }


    public Mercenary verifyMercenary(int mouseX, int mouseY) {

        if (p1.getUnits() == null) {
            return null;
        }
        if (p2.getUnits() == null) {
            return null;
        }

        for (int i = 0; i < p1.getUnits().length; i++) {

            if (p1.getUnits()[i] == null) {

                System.out.println("no mercenary on " + mouseX + " " + mouseY);

                return null;
            }

            if (p2.getUnits()[i] == null) {

                System.out.println("no mercenary on " + mouseX + " " + mouseY);

                return null;
            }


            if ((mouseX > p1.getUnits()[i].getPos().getX() && (mouseX < (p1.getUnits()[i].getPos().getX() + p1.getUnits()[i].getUnitPic().getWidth()))
                    && (mouseY > p1.getUnits()[i].getPos().getY()) && (mouseY < p1.getUnits()[i].getPos().getY() + p1.getUnits()[i].getUnitPic().getHeight()))) {

                return p1.getUnits()[i];
            }

            if ((mouseX > p2.getUnits()[i].getPos().getX() && (mouseX < (p2.getUnits()[i].getPos().getX() + p2.getUnits()[i].getUnitPic().getWidth()))
                    && (mouseY > p2.getUnits()[i].getPos().getY()) && (mouseY < p2.getUnits()[i].getPos().getY() + p2.getUnits()[i].getUnitPic().getHeight()))) {

                return p2.getUnits()[i];
            }
        }

        for (int i = 0; i < p2.getUnits().length; i++) {

            if (p2.getUnits()[i] == null) {

                System.out.println("no mercenary on " + mouseX + " " + mouseY);

                return null;
            }

            System.out.println("in2");
            if ((mouseX > p2.getUnits()[i].getPos().getX() && (mouseX < (p2.getUnits()[i].getPos().getX() + p2.getUnits()[i].getUnitPic().getWidth()))
                    && (mouseY > p2.getUnits()[i].getPos().getY()) && (mouseY < p2.getUnits()[i].getPos().getY() + p2.getUnits()[i].getUnitPic().getHeight()))) {

                return p2.getUnits()[i];
            }


        }
        return null;
    }


    public boolean isThereMercenary(int mouseX, int mouseY) {

        for (int i = 0; i < 20; i++) {

            if (p1.getUnits()[i] == null) {

                System.out.println("no mercenary on " + mouseX + " " + mouseY);

                return false;
            }

            if (p2.getUnits()[i] == null) {

                System.out.println("no mercenary on " + mouseX + " " + mouseY);

                return false;
            }

            System.out.println(p1.getUnits()[i].getPos().getX() + " " + mouseX + " " + p1.getUnits()[i].getPos().getX() + " ");

            if (p1.getUnits()[i].getPos().getX() < mouseX && mouseX < p1.getUnits()[i].getPos().getX() + p1.getUnits()[i].getUnitPic().getWidth()
                    && p1.getUnits()[i].getPos().getY() < mouseY && mouseY < p1.getUnits()[i].getPos().getY() + p1.getUnits()[i].getUnitPic().getHeight()) {

                return true;
            }

            if (p2.getUnits()[i].getPos().getX() < mouseX && mouseX < p2.getUnits()[i].getPos().getX() + p2.getUnits()[i].getUnitPic().getWidth()
                    && p2.getUnits()[i].getPos().getY() < mouseY && mouseY < p2.getUnits()[i].getPos().getY() + p2.getUnits()[i].getUnitPic().getHeight()) {

                return true;
            }
        }
        return false;
    }


    public Terrain verifyTerrain(int mouseX, int mouseY) {

        int mouseRow = (mouseX - SimpleGfxGrid.PADDING) / SimpleGfxGrid.getCELLWIDTH();
        int mouseCol = (mouseY - SimpleGfxGrid.PADDING - 23) / SimpleGfxGrid.getCELLHEIGHT();

        for (int i = 0; i < grid.getCols(); i++) {

            for (int j = 0; j < grid.getRows(); j++) {

                if ((mouseRow == i) && (mouseCol == j)) {

                    System.out.println(terrains[i][j].toString());

                    return terrains[i][j];

                }

            }
        }
        return null;

    }
}
