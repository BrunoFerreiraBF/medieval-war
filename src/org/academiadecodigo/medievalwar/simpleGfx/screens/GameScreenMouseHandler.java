package org.academiadecodigo.medievalwar.simpleGfx.screens;


import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.terrain.Terrain;
import org.academiadecodigo.medievalwar.objects.terrain.TerrainType;
import org.academiadecodigo.medievalwar.objects.units.Mercenary;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

import org.academiadecodigo.simplegraphics.mouse.MouseHandler;


/**
 * Created by codecadet on 17/06/2017.
 */
public class GameScreenMouseHandler implements MouseHandler {


    private Terrain[][] terrains;

    private Player p1;

    private Player p2;

    private SimpleGfxGrid grid;


    private Mercenary selectedMerc;

    private Mercenary targetMerc;


    private Ellipse move = new Ellipse(0, 0, 0, 0);

    private Ellipse attack = new Ellipse(0, 0, 0, 0);
    private Ellipse attack1 = new Ellipse(0, 0, 0, 0);


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

        Terrain terrain = verifyTerrain(mouseX, mouseY);

        if (terrain.getTerrainType() == TerrainType.ROCK) {
            return;
        }
        attack1.delete();


        if (selectedMerc != null) {

            move(mouseX, mouseY);


            move.delete();
            attack.delete();

            attack1 = new Ellipse(selectedMerc.getPos().getX() - (selectedMerc.getAttackRange()) / 2, selectedMerc.getPos().getY() - (selectedMerc.getAttackRange()) / 2, selectedMerc.getAttackRange(), selectedMerc.getAttackRange());
            attack1.setColor(Color.RED);
            attack1.fill();
            attack1.draw();

            selectedMerc = null;
            return;
        }


        selectedMerc = verifyMercenary(mouseX, mouseY, p1);
        targetMerc = verifyMercenary(mouseX, mouseY, p2);

        if (targetMerc != null) {

            selectedMerc.hit(targetMerc);

            if (targetMerc.isDead()){
                targetMerc.getUnitPic().delete();
                targetMerc.getPos().setX(-10);
                targetMerc.getPos().setY(-10);
            }

            targetMerc=null;
            return;
        }

        if (selectedMerc != null) {

            move = new Ellipse((selectedMerc.getPos().getX() - (selectedMerc.getMoveRange() / 2)), (selectedMerc.getPos().getY() - (selectedMerc.getMoveRange() / 2)), (selectedMerc.getMoveRange()), (selectedMerc.getMoveRange()));
            move.setColor(Color.YELLOW);
            move.fill();
            move.draw();

            attack = new Ellipse(selectedMerc.getPos().getX() - (selectedMerc.getMoveRange() + selectedMerc.getAttackRange()) / 2, selectedMerc.getPos().getY() - (selectedMerc.getMoveRange() + selectedMerc.getAttackRange()) / 2, selectedMerc.getMoveRange() + selectedMerc.getAttackRange(), selectedMerc.getMoveRange() + selectedMerc.getAttackRange());
            attack.setColor(Color.RED);
            attack.fill();
            attack.draw();


        }


        // gerar o codigo que faz o hit ao atacar e seleccionar uma unidade inimiga se esta tiver dentro de atack range

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY();
/*
        System.out.println(mouseX + " " + mouseY);

        System.out.println(verifyMercenary(mouseX, mouseY, p1));
        System.out.println(verifyMercenary(mouseX, mouseY, p2));

        Mercenary mercenary1 = verifyMercenary(mouseX, mouseY, p1);

        //System.out.println(mercenary1.getPos().getX());

        System.out.println("X" + (mercenary1.getPos().getX() - (mercenary1.getMoveRange() / 2)) + "Y" + (mercenary1.getPos().getY() - (mercenary1.getMoveRange() / 2)) + " RAIO" + (mercenary1.getMoveRange()));
*/
       // System.out.println(verifyTerrain(mouseX, mouseY));
    }

    private void move(int x, int y) {

//        System.out.println(selectedMerc.getPos().getDistance(x,y)+"move range "+selectedMerc.getMoveRange()+"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa");
        if (selectedMerc.getPos().getDistance(x, y) > selectedMerc.getMoveRange()) {

            System.out.println("out of move range");
            return;
        }

        selectedMerc.getUnitPic().translate(x - selectedMerc.getPos().getX(), y - selectedMerc.getPos().getY());
        selectedMerc.getPos().setX(x);
        selectedMerc.getPos().setY(y);

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
