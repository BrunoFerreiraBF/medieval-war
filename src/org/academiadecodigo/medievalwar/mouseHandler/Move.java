package org.academiadecodigo.medievalwar.mouseHandler;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.terrain.Terrain;
import org.academiadecodigo.medievalwar.objects.units.Mercenary;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;

/**
 * Created by codecadet on 13/06/2017.
 */
public class Move implements MouseHandler {

    private Picture pic;

    private Mercenary[] mercenaries;

    private Terrain[][] terrains;

    private SimpleGfxGrid grid;



    public Move(Picture pic, Mercenary[] mercenaries, Terrain[][] terrains, Player player) {


        this.mercenaries = mercenaries;
        this.terrains = terrains;

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

    }

    public Terrain verifyTerrain(int mouseX, int mouseY) {

        int mouseRow = (mouseX - SimpleGfxGrid.PADDING) / SimpleGfxGrid.getCELLWIDTH();
        int mouseCol = (mouseY - SimpleGfxGrid.PADDING) / SimpleGfxGrid.getCELLHEIGHT();

        for (int i = 0; i < grid.getCols(); i++) {

            for (int j = 0; j < grid.getRows(); j++) {

                if ((mouseRow == grid.getRows()) && (mouseCol == grid.getCols())) {

                    return terrains[i][j];

                }

            }
        }

        return null;

    }

    public Mercenary verifyMercenary(int mouseX, int mouseY) {

        for (int i = 0; i < mercenaries.length; i++) {

            if (mercenaries[i].getPos().getX() < mouseX && mouseX < mercenaries[i].getPos().getX()+mercenaries[i].getUnitPic().getWidth()
                    && mercenaries[i].getPos().getY() < mouseY && mouseY <mercenaries[i].getPos().getY()+ mercenaries[i].getUnitPic().getHeight()) {

                return mercenaries[i];

            }
        }
        return null;
    }





    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        System.out.println(mouseEvent);

        int currentX = pic.getX();
        int currentY = pic.getY();

        int centerX = currentX + pic.getWidth() / 2;
        int centerY = currentY + pic.getHeight() / 2;

        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) (mouseEvent.getY()) - 23;

        verifyTerrain(mouseX, mouseY);

        verifyMercenary(mouseX, mouseY);

        double distance = (int) (Math.sqrt(Math.pow(Math.abs(mouseX - currentX), 2) + Math.pow(Math.abs(mouseY - currentY), 2)));


        if (distance > verifyMercenary(mouseX, mouseY).getMoveRange()) {
            return;

        }

        pic.translate(mouseX - centerX, mouseY - centerY);

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}