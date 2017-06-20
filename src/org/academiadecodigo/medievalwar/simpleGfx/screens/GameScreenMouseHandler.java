package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.objects.terrain.Terrain;
import org.academiadecodigo.medievalwar.objects.terrain.TerrainType;
import org.academiadecodigo.medievalwar.objects.units.Mercenary;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by codecadet on 17/06/2017.
 */
public class GameScreenMouseHandler implements MouseHandler, KeyboardHandler {

    private Terrain[][] terrains;
    private Player p1;
    private Player p2;
    private SimpleGfxGrid grid;

    private Mercenary selectedMerc;
    private Mercenary targetMerc;

    private Player playerInControl = p1;

    private Ellipse move = new Ellipse(0, 0, 0, 0);
    private Ellipse attack = new Ellipse(0, 0, 0, 0);
    private Ellipse attack1 = new Ellipse(0, 0, 0, 0);


    private int turnCounter;

    public GameScreenMouseHandler(Terrain[][] terrains, SimpleGfxGrid grid, Player p1, Player p2) {

        this.terrains = terrains;
        this.p1 = p1;
        this.p2 = p2;
        this.grid = grid;

        Keyboard k = new Keyboard(this);

        KeyboardEvent SpacePressedEvent = new KeyboardEvent();
        SpacePressedEvent.setKey(KeyboardEvent.KEY_SPACE);
        SpacePressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(SpacePressedEvent);


    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        deleteCircles();

        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY() - 23;

        if (verifyTerrain(mouseX, mouseY + 23).getTerrainType() == TerrainType.ROCK) {
            return;
        }


        if (selectedMerc != null && !selectedMerc.isMoved() && targetMerc == null) {
            move(mouseX, mouseY);
            deleteCircles();
        }


        if (player1InControl(turnCounter)) {

            if (selectedMerc == null) {
                selectedMerc = verifyMercenary(mouseX, mouseY, p1);
            }
            if (targetMerc == null) {
                targetMerc = verifyMercenary(mouseX, mouseY, p2);
            }
            System.out.println("----------------Player " + p1.toString() + " in control-----------------");
            playerInControl = p1;
        }

        if (!player1InControl(turnCounter)) {


            if (selectedMerc == null) {
                selectedMerc = verifyMercenary(mouseX, mouseY, p2);
            }
            if (targetMerc == null) {
                targetMerc = verifyMercenary(mouseX, mouseY, p1);
            }
            System.out.println("----------------Player " + p2.toString() + " in control-----------------");
            playerInControl = p2;
        }


        if (targetMerc != null && selectedMerc != null && !selectedMerc.isAttacked()) {
            attack();
            return;
        }

        if (selectedMerc != null) {
            drawCircles();
        }

        System.out.println(selectedMerc);

        System.out.println(targetMerc);

    }

    private boolean attack() {

        if (selectedMerc.getPos().getDistance(targetMerc.getPos().getX(), targetMerc.getPos().getY()) > selectedMerc.getAttackRange()) {
            System.out.println("Distance " + selectedMerc.getPos().getDistance(targetMerc.getPos().getX(), targetMerc.getPos().getY()) + " attack range " + selectedMerc.getAttackRange());

            return false;
        }

        if (targetMerc != null) {

            selectedMerc.hit(targetMerc);

            if (targetMerc.isDead()) {
                targetMerc.getUnitPic().delete();
                targetMerc.getPos().setX(-10);
                targetMerc.getPos().setY(-10);
            }

            System.out.println("---------------------------------------------------------------" + selectedMerc + "-----attacked-------" + targetMerc + "---------------------------------------------------");
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

        double distanceX = x - selectedMerc.getPos().getX();
        double distanceY = y - selectedMerc.getPos().getY();


        selectedMerc.getUnitPic().translate(distanceX, distanceY);

        selectedMerc.getPos().setX(x);
        selectedMerc.getPos().setY(y);

        move.delete();
        attack.delete();

        attack1 = new Ellipse(selectedMerc.getPos().getX() - (selectedMerc.getAttackRange()) / 2, selectedMerc.getPos().getY() - (selectedMerc.getAttackRange()) / 2, selectedMerc.getAttackRange(), selectedMerc.getAttackRange());
        attack1.setColor(Color.RED);
        attack1.fill();
        attack1.draw();

        selectedMerc.hasMoved();

        selectedMerc = null;
        targetMerc = null;


        return true;
    }


    public void resetMovement() {


        for (int i = 0; i < playerInControl.getUnits().length; i++) {

            if (playerInControl.getUnits()[i] != null) {

                playerInControl.getUnits()[i].resetMove();
            }

        }

    }

    public void resetAttack() {

        for (int i = 0; i < playerInControl.getUnits().length; i++) {

            if (playerInControl.getUnits()[i] != null) {

                playerInControl.getUnits()[i].resetAttacked();
            }

        }

    }

    public void resetUnits() {
        resetMovement();
        resetAttack();
        selectedMerc = null;
        targetMerc = null;

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

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_SPACE:

                turnCounter++;

                System.out.println("----------------------------------------------------Next turn----------------------------------------------------------");

                resetUnits();
                deleteCircles();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}


