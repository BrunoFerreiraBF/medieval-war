package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.units.Mercenary;
import org.academiadecodigo.medievalwar.objects.units.MercenaryFactory;
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
    private Mercenary mercenary;

    public SelectionScreen(Player player, Mercenary mercenary) {
        this.player = player;
        this.mercenary = mercenary;

        createSelectionScreen();

        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

    }

    public void createSelectionScreen() {

        Picture archerPic = new Picture(10,10,"");
        Picture catapultPic = new Picture(10,100,"");
        Picture cavalryPic = new Picture(10,200,"");
        Picture cavalryArcherPic = new Picture(10,300,"");
        Picture generalPic = new Picture(10,400,"");
        Picture infantryPic = new Picture(10,500,"");
        Picture spearmanPic = new Picture(10,600,"");


    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY();


        if ((mouseX >= 10) && (mouseY < 90) && (mouseY > 10)) {

        }

        if ((mouseX >= 10) && (mouseY < 190) && (mouseY > 200)) {

        }

        if ((mouseX >= 10) && (mouseY < 290) && (mouseY > 300)) {

        }

        if ((mouseX >= 10) && (mouseY < 390) && (mouseY > 400)) {

        }

        if ((mouseX >= 10) && (mouseY < 490) && (mouseY > 500)) {

        }

        if ((mouseX >= 10) && (mouseY < 590) && (mouseY > 600)) {

        }
        

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
