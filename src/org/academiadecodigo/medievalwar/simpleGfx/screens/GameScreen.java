package org.academiadecodigo.medievalwar.simpleGfx.screens;

import org.academiadecodigo.medievalwar.Player;
import org.academiadecodigo.medievalwar.field.grid.Grid;
import org.academiadecodigo.medievalwar.objects.terrain.*;
import org.academiadecodigo.medievalwar.objects.units.*;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.medievalwar.simpleGfx.SimpleGfxGrid;

/**
 * Created by codecadet on 13/06/17.
 */
public class GameScreen implements Screen {

    private Terrain[][] terrains;

    private Player p1;

    private Player p2;

    private SimpleGfxGrid grid;

    private GameScreenMouseHandler gameScreenMouseHandler;


    private int turnCounter;


    public GameScreen(Terrain[][] terrains, SimpleGfxGrid grid, Player p1, Player p2) {

        gameScreenMouseHandler=new GameScreenMouseHandler(terrains, grid, p1, p2);

        Mouse m = new Mouse(gameScreenMouseHandler);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        this.terrains = terrains;
        this.p1 = p1;
        this.p2 = p2;
        this.grid = grid;

    }

    public void init() {
        drawTerrains(terrains);
    }

    public void start() {
        System.out.println(p1);
        System.out.println(p2);

        drawUnits(p1.getUnits());
        drawUnits(p2.getUnits());
    }

    public void startTurn(){






        turnCounter++;


    }



    private void drawUnits(Mercenary[] units) {

        Picture picture;

        for (int i = 0; i < units.length; i++) {

            if (units[i] == null) {
                return;
            }

            picture = units[i].getUnitPic();
            System.out.println(units[i].getUnitPic());
            picture.draw();
        }
    }

    private void drawTerrains(Terrain[][] terrains) {

        Picture picture = null;

        this.terrains = terrains;

        for (int i = 0; i < terrains.length; i++) {

            for (int j = 0; j < terrains.length; j++) {

                if (terrains[i][j] instanceof Grass) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/grass.png");

                }
                if (terrains[i][j] instanceof Mountain) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/mountain.png");

                }
                if (terrains[i][j] instanceof Forest) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/forest.png");

                }
                if (terrains[i][j] instanceof Rock) {

                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/rock.png");

                }
                if (terrains[i][j] instanceof Sand) {
                    //System.out.println("in");
                    picture = new Picture(SimpleGfxGrid.PADDING + i * SimpleGfxGrid.CELLWIDTH, SimpleGfxGrid.PADDING + j * SimpleGfxGrid.CELLHEIGHT, "chipsets/sand.png");
                }

                picture.draw();
            }
        }
    }


    public void update() {

        remove(p1.getUnits());

        remove(p2.getUnits());

    }


    public void remove(Mercenary[] units) {

        Picture picture;

        for (int i = 0; i < units.length; i++) {
            System.out.println();
            if (units[i] == null) {
                return;
            }

            picture = units[i].getUnitPic();
            picture.delete();
        }

    }
}
