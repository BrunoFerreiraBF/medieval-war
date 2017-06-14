package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.units.Mercenary;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 13/06/17.
 */
public class SelectionScreen implements MouseHandler{

    private Player player;
    private Mercenary mercenary;

    public SelectionScreen(Player player, Mercenary mercenary) {
        this.player = player;
        this.mercenary = mercenary;

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {



    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
