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

    public Move ( Picture pic, Mercenary mercenary){

        this.pic=pic;
        this.mercenary=mercenary;
        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent);

        int currentX = pic.getX();
        int currentY = pic.getY();

        //int centerX = currentX + currentY / 2;

        int mouseX = (int)mouseEvent.getX();
        int mouseY = (int)(mouseEvent.getY()) - 23;

        if ()

        pic.translate(mouseX - currentX, mouseY - currentY);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
