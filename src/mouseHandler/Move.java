package mouseHandler;

import objects.units.Mercenary;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 13/06/2017.
 */
public class Move implements MouseHandler {

    private Picture pic;

    private Mercenary mercenary;

    public Move(Picture pic, Mercenary mercenary) {

        this.pic = pic;
        this.mercenary = mercenary;
        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

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
