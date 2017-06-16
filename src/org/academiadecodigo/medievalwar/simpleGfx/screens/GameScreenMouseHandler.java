package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.terrain.Terrain;
import org.academiadecodigo.medievalwar.objects.units.Mercenary;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 17/06/2017.
 */
public class GameScreenMouseHandler implements MouseHandler {


    private Terrain[][] terrains;

    private Player p1;

    private Player p2;

    private SimpleGfxGrid grid;


    public GameScreenMouseHandler(Terrain[][] terrains, SimpleGfxGrid grid, Player p1, Player p2) {

        this.terrains = terrains;
        this.p1 = p1;
        this.p2 = p2;
        this.grid = grid;

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY() - 23;

        Terrain terrain = verifyTerrain(mouseX,mouseY);

        Mercenary mercenary1 = verifyMercenary(mouseX,mouseY,p1);
        Mercenary mercenary2 = verifyMercenary(mouseX,mouseY,p2);


        // quando clicar num boneco gerar om circulo a sua volta com o raio = ao movement range da unidade

        // com o segundo clique ele ve a posição e se estiver dentro do raio de acção ele faz a translacção

        // gerar o codigo que faz o hit ao atacar e seleccionar uma unidade inimiga se esta tiver dentro de atack range








    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }


    public Mercenary verifyMercenary(int mouseX, int mouseY, Player player) {

        if (player.getUnits() == null) {
            return null;
        }

        for (int i = 0; i < player.getUnits().length; i++) {

            if (player.getUnits()[i] == null) {
                return null;
            }

            int centerPosX = player.getUnits()[i].getPos().getX()  -  player.getUnits()[i].getUnitPic().getWidth()/2 - 20;
            int centerPosY = player.getUnits()[i].getPos().getY()  -  player.getUnits()[i].getUnitPic().getHeight()/2 - 20;
            //System.out.println("in X = "+centerPosX+ " "+ mouseX+" "+(centerPosX+80));
            //System.out.println("in y = "+centerPosY+ " "+ mouseY+" "+(centerPosY+60));

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
}
