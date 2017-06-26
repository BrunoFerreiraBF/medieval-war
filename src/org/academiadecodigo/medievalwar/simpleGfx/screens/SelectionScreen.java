package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.terrain.*;
import org.academiadecodigo.medievalwar.objects.units.*;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
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

    private Text p1Gold= new Text(0,0,"");
    private Text p2Gold= new Text(0,0,"");


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
        createGeneral();

        rules.draw();
        updatePlayerGold();
    }
/*
    public void setKeyboardHandler(SelectionScreenKeyboardHandler keyboardHandler) {
        this.keyboardHandler = keyboardHandler;
    }
*/
    private void createGeneral() {


        for (int i = 0; i < grid.getCols(); i++) {

            if (terrains[0][i].getTerrainType() != TerrainType.ROCK) {

                p1.getUnits()[0] = MercenaryFactory.makeMercenary2(80, 80 + 60 * i, new General(80, 80 + 60 * i), p1);
                break;
            }
        }

        for (int i = grid.getCols() - 1; i > 0; i--) {

            if (terrains[5][i].getTerrainType() != TerrainType.ROCK) {

                p2.getUnits()[0] = MercenaryFactory.makeMercenary(880, 660 - 60 * (5 - i), new General(880, 660 - 60 * (5 - i)), p2);
                break;
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Player player = null;

        int mouseX = (int) mouseEvent.getX() - 10;
        int mouseY = (int) mouseEvent.getY() - 33;


        if (mouseX > 320 + 10 && mouseX < 640 + 10) {
            return;
        }


        Terrain terrain = verifyTerrain(mouseX, mouseY);

        if (terrain instanceof Rock) {
            return;
        }


        if (mouseX <= 320 + 10) {
            player = p1;

            createMercenary(mouseX, mouseY);
        }

        if (mouseX > 640 + 10) {
            player = p2;
            createMercenary2(mouseX, mouseY);
        }

        if (verifyMercenary(mouseX, mouseY, player) != null) {
            return;
        }
        updatePlayerGold();

    }

    private void updatePlayerGold() {
        p1Gold.delete();
        p1Gold= new Text( 460,(115) ,"Gold: "+p1.getGold());
        p1Gold.grow(40,20);
        p1Gold.setColor(Color.YELLOW);
        p1Gold.draw();

        p2Gold.delete();
        p2Gold= new Text( 470 ,(705) ,"Gold: "+p2.getGold());
        p2Gold.grow(50,20);
        p2Gold.setColor(Color.YELLOW);
        p2Gold.draw();



    }


    private void createMercenary2(int mouseX, int mouseY) {

        Player player = p2;

        for (int i = 0; i < player.getUnits().length; i++) {


            if (player.getUnits()[i] == null) {

                if (keyboardHandler.isKey1()) {


                    if (player.getGold() < Archer.getCost()) {
                        return;
                    }
                    player.spendGold(Archer.getCost());
                    player.getUnits()[i] = MercenaryFactory.makeMercenary2(mouseX, mouseY, new Archer(mouseX, mouseY), player);

                    System.out.println(player.getUnits()[i].getPos().getX() + " equal " + mouseX + "  " + player.getUnits()[i].getPos().getY() + " equal " + mouseY);
                }

                if (keyboardHandler.isKey2()) {

                    if (player.getGold() < Catapult.getCost()) {
                        return;
                    }
                    player.getUnits()[i] = MercenaryFactory.makeMercenary2(mouseX, mouseY, new Catapult(mouseX, mouseY), player);
                }

                if (keyboardHandler.isKey3()) {
                    if (player.getGold() < Cavalry.getCost()) {
                        return;
                    }
                    player.spendGold(Cavalry.getCost());
                    player.getUnits()[i] = MercenaryFactory.makeMercenary2(mouseX, mouseY, new Cavalry(mouseX, mouseY), player);
                }

                if (keyboardHandler.isKey4()) {

                    if (player.getGold() < Cavalry_Archer.getCost()) {
                        return;
                    }
                    player.spendGold(Cavalry_Archer.getCost());
                    player.getUnits()[i] = MercenaryFactory.makeMercenary2(mouseX, mouseY, new Cavalry_Archer(mouseX, mouseY), player);
                }

                if (keyboardHandler.isKey5()) {
                    if (player.getGold() < Infantry.getCost()) {
                        return;
                    }
                    player.spendGold(Infantry.getCost());
                    player.getUnits()[i] = MercenaryFactory.makeMercenary2(mouseX, mouseY, new Infantry(mouseX, mouseY), player);
                }

                if (keyboardHandler.isKey6()) {
                    if (player.getGold() < Spearman.getCost()) {
                        return;
                    }
                    player.spendGold(Spearman.getCost());
                    player.getUnits()[i] = MercenaryFactory.makeMercenary2(mouseX, mouseY, new Spearman(mouseX, mouseY), player);

                }
                return;
            }
        }

    }

    private void createMercenary(int mouseX, int mouseY) {

        Player player = p1;


        for (int i = 0; i < player.getUnits().length; i++) {


            if (player.getUnits()[i] == null) {

                if (keyboardHandler.isKey1()) {


                    if (player.getGold() < Archer.getCost()) {
                        return;
                    }
                    player.spendGold(Archer.getCost());
                    player.getUnits()[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Archer(mouseX, mouseY), player);

                    System.out.println(player.getUnits()[i].getPos().getX() + " equal " + mouseX + "  " + player.getUnits()[i].getPos().getY() + " equal " + mouseY);
                }

                if (keyboardHandler.isKey2()) {

                    if (player.getGold() < Catapult.getCost()) {
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
/*
        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY();

        System.out.println(mouseX+" "+mouseY);
        System.out.println(verifyTerrain(mouseX,mouseY));
        System.out.println(verifyMercenary(mouseX, mouseY,p1));
        System.out.println(verifyMercenary(mouseX, mouseY,p2));
*/
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


    public Mercenary verifyMercenary(int mouseX, int mouseY, Player player) {

        if (player.getUnits() == null) {
            return null;
        }

        for (int i = 0; i < player.getUnits().length; i++) {

            if (player.getUnits()[i] == null) {
                return null;
            }

            int centerPosX = player.getUnits()[i].getPos().getX() - player.getUnits()[i].getUnitPic().getWidth() / 2 - 20;
            int centerPosY = player.getUnits()[i].getPos().getY() - player.getUnits()[i].getUnitPic().getHeight() / 2 - 20;

            if ((mouseX > centerPosX && (mouseX < (centerPosX + 120))
                    && (mouseY > centerPosY) && (mouseY < (centerPosY + 80)))) {

                System.out.println(player.getUnits()[i]);

                return player.getUnits()[i];
            }
        }
        return null;
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


    public void remove(Mercenary[] units) {

        Picture picture;

        for (int i = 0; i < units.length; i++) {

            if (units[i] == null) {
                return;
            }

            picture = units[i].getUnitPic();
            picture.delete();
        }

        p1Gold = null;
        p2Gold = null;

    }
}