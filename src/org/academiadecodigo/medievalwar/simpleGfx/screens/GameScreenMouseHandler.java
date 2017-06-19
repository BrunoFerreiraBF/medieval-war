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

    private static Player playerInControl;

    private Ellipse move = new Ellipse(0, 0, 0, 0);
    private Ellipse attack = new Ellipse(0, 0, 0, 0);
    private Ellipse attack1 = new Ellipse(0, 0, 0, 0);


    private int turnCounter;

    public GameScreenMouseHandler(Terrain[][] terrains, SimpleGfxGrid grid, Player p1, Player p2) {

        this.terrains = terrains;
        this.p1 = p1;
        this.p2 = p2;
        this.grid = grid;
    }


    public static void nextTurn() {
        resetAttack();
        resetMovement();

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        turnCounter = GameScreenKeyboardHandler.getTurnCounter();

        deleteCircles();

        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY() - 23;


        if (verifyTerrain(mouseX, mouseY + 23).getTerrainType() == TerrainType.ROCK) {
            return;
        }

        if (targetMerc != null && selectedMerc != null && !selectedMerc.isAttacked()) {

            //System.out.println((selectedMerc.getPos().getDistance(targetMerc.getPos().getX(),targetMerc.getPos().getY())<selectedMerc.getAttackRange())+" and atack");

            attack();

            return;
        }

        if (selectedMerc != null && !selectedMerc.isMoved() && targetMerc==null) {
            move(mouseX, mouseY);
            deleteCircles();
        }


        if (player1InControl(turnCounter)) {
            selectedMerc = verifyMercenary(mouseX, mouseY, p1);
            targetMerc = verifyMercenary(mouseX, mouseY, p2);
            playerInControl = p1;

        }

        if (!player1InControl(turnCounter)) {
            selectedMerc = verifyMercenary(mouseX, mouseY, p2);
            targetMerc = verifyMercenary(mouseX, mouseY, p1);
            playerInControl = p2;
        }

        if (selectedMerc != null) {
            drawCircles();
        }

        System.out.println(selectedMerc);

        System.out.println(targetMerc);

    }
    private boolean attack() {

        if (targetMerc != null) {

            selectedMerc.hit(targetMerc);

            if (targetMerc.isDead()) {
                targetMerc.getUnitPic().delete();
                targetMerc.getPos().setX(-10);
                targetMerc.getPos().setY(-10);
            }

            System.out.println("--------------------------------------------------------------------attacked----------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------attacked----------------------------------------------------------");

            selectedMerc.hasAttacked();

            selectedMerc = null;
            targetMerc = null;

            return true;
        }

        return false;
    }
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }


    private boolean gameEnded() {

        for (int i = 0; i < p1.getUnits().length; i++) {

            if (p1.getUnits()[i] != null && !p1.getUnits()[i].isDead()) {

            }
        }

        for (int i = 0; i < p2.getUnits().length; i++) {

            if (p2.getUnits()[i] != null && !p2.getUnits()[i].isDead()) {

                return false;
            }
        }

        deleteCircles();

        return true;
    }


    private boolean move(int x, int y) {


        if (selectedMerc.getPos().getDistance(x, y) > selectedMerc.getMoveRange()) {

            System.out.println("out of move range");
            return false;
        }

        selectedMerc.getUnitPic().translate(x - selectedMerc.getPos().getX(), y - selectedMerc.getPos().getY());
        selectedMerc.getPos().setX(x);
        selectedMerc.getPos().setY(y);

        move.delete();
        attack.delete();

        attack1 = new Ellipse(selectedMerc.getPos().getX() - (selectedMerc.getAttackRange()) / 2, selectedMerc.getPos().getY() - (selectedMerc.getAttackRange()) / 2, selectedMerc.getAttackRange(), selectedMerc.getAttackRange());
        attack1.setColor(Color.RED);
        attack1.fill();
        attack1.draw();

        //System.out.println("--------------------------------------------------------- "+selectedMerc.isMoved() +"----------------------------------------------");

        selectedMerc.hasMoved();

        //selectedMerc = null;
        //targetMerc = null;


        return true;

    }


    public static void resetMovement() {


        for (int i = 0; i < playerInControl.getUnits().length; i++) {

            if (playerInControl.getUnits()[i] != null) {

                playerInControl.getUnits()[i].resetMove();
            }

        }


    }

    public static void resetAttack() {

        for (int i = 0; i < playerInControl.getUnits().length; i++) {

            if (playerInControl.getUnits()[i] != null) {

                playerInControl.getUnits()[i].resetAttacked();
            }

        }

    }



    private void drawCircles() {

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
    }

    private void deleteCircles() {
        attack.delete();
        attack1.delete();
        move.delete();
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


    private boolean player1InControl(int turn) {

        if ((turn % 2) == 0) {//par= true
            return true;
        }
        return false;
    }
}


