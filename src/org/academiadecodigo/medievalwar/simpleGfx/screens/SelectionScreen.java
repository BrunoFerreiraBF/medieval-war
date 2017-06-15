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
public class SelectionScreen implements MouseHandler{

    private Player player;
    private Mercenary[] mercenaries;

    private SelectionScreenKeyboardHandler keyboardHandler=new SelectionScreenKeyboardHandler();


    public SelectionScreen(Player player) {

        this.player = player;
        this.mercenaries = player.getUnits();

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

    }

    public void setPlayerUnits() {
        player.setUnits(mercenaries);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY();



        //Could be with getWidth or getHeigth instead of getMax
        for (int i = 0; i < mercenaries.length; i++) {
            if (mercenaries[i] == null) {

                if (keyboardHandler.isKey1()) {

                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Archer(mouseX, mouseY), player);
                    player.

                }

                if (keyboardHandler.isKey2()) {
                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Catapult(mouseX, mouseY), player);

                }

                if (keyboardHandler.isKey3()) {
                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Cavalry(mouseX, mouseY), player);

                }

                if (keyboardHandler.isKey4()) {
                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Cavalry_Archer(mouseX, mouseY), player);

                }

                if (keyboardHandler.isKey5()) {
                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Infantry(mouseX, mouseY), player);

                }

                if (keyboardHandler.isKey6()) {
                    mercenaries[i] = MercenaryFactory.makeMercenary(mouseX, mouseY, new Spearman(mouseX, mouseY), player);

                }

                return;

            }

        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void init(Terrain [][] terrains,SimpleGfxGrid grid){

        drawTerrains(terrains,grid);

        //picOption.draw()

    }




    private void drawTerrains(Terrain[][] terrains, Grid grid) {

        Picture picture = null;

        for (int i = 0; i < terrains.length; i++) {

            for (int j = 0; j < terrains.length; j++) {

                if (terrains[i][j] instanceof Grass) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/SimpleGrass_Tile.png");

                }
                if (terrains[i][j] instanceof Mountain) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/Mountain_movable_Tile.png");

                }
                if (terrains[i][j] instanceof Forest) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/Forest_Tile.png");

                }
                if (terrains[i][j] instanceof Rock) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/Sand_Tile.png");

                }
                if (terrains[i][j] instanceof Sand) {
                    //System.out.println("in");
                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipset_tiles/Grass_to_Sand_Tiles_TOP-LEFT.png");
                }

                picture.draw();
            }
        }
    }


}
