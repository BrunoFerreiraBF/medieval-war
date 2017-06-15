package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.units.*;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
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

    private Picture archerUnit;
    private Picture catapultUnit;
    private Picture cavalryUnit;
    private Picture cavalryArcherUnit;
    private Picture infantryUnit;
    private Picture spearmanUnit;

    public SelectionScreen(Player player) {

        this.player = player;
        this.mercenaries = player.getUnits();

        archerUnit = new Picture(SimpleGfxGrid.PADDING,SimpleGfxGrid.PADDING,"");
        catapultUnit = new Picture(SimpleGfxGrid.PADDING, 90, "");
        cavalryUnit = new Picture(SimpleGfxGrid.PADDING, 190, "");
        cavalryArcherUnit = new Picture(SimpleGfxGrid.PADDING, 290, "");
        infantryUnit = new Picture(SimpleGfxGrid.PADDING, 390, "");
        spearmanUnit = new Picture(SimpleGfxGrid.PADDING, 490, "");

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


}
