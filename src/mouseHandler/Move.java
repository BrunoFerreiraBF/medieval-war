package mouseHandler;

import objects.terrain.Terrain;
import objects.units.Mercenary;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import simpleGfx.SimpleGfxGrid;

/**
 * Created by codecadet on 13/06/2017.
 */
public class Move implements MouseHandler {

    private Picture pic;

    private Mercenary mercenary;

    private Terrain[][] terrains;

    private SimpleGfxGrid grid;

    public Move(Picture pic, Mercenary mercenary, Terrain[][] terrains, Player p1) {

        this.pic = pic;
        this.mercenary = mercenary;
        this.terrains = terrains;

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

    }

    public Terrain verifyTerrain(int mouseX, int mouseY) {

        int mouseRow = mouseX / SimpleGfxGrid.getCELLWIDTH();
        int mouseCol = mouseY / SimpleGfxGrid.getCELLHEIGHT();

        for (int i = 0; i < grid.getCols(); i++) {

            for (int j = 0; j < grid.getRows() ; j++) {

                if ((mouseRow == grid.getRows()) && (mouseCol == grid.getCols())) {

                    return terrains[i][j];

                }

            }
        }

        return null;

    }

    public void verifyMercenary(int mouseX, int mouseY) {



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


        if (distance > mercenary.getMoveRange()) {
            return;

        }

        pic.translate(mouseX - centerX, mouseY - centerY);

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
