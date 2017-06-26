package org.academiadecodigo.medievalwar.simpleGfx;

import org.academiadecodigo.medievalwar.field.grid.Grid;
import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;

    public static final int CELLWIDTH=160;

    public static final int CELLHEIGHT=120;

    private Rectangle rec;


    private int cols;

    private int rows;



    public SimpleGfxGrid(int cols, int rows){

        this.rows=rows;
        this.cols=cols;
    }

    /**
     * @see Grid#init()
     */

    @Override
    public void init() {

        rec=new Rectangle(10,10,CELLWIDTH*cols,CELLHEIGHT*rows);

        rec.setColor(Color.BLACK);

        rec.draw();


    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
       return cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
       return rows;
    }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {
        return rec.getWidth();
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return rec.getHeight();
    }

    /**
     * Obtains the grid X positionGrid in the SimpleGFX canvas
     * @return the x positionGrid of the grid
     */
    public int getX() {
        return rec.getX();
    }

    /**
     * Obtains the grid Y positionGrid in the SimpleGFX canvas
     * @return the y positionGrid of the grid
     */
    public int getY() {

        return rec.getY();
    }

    /**
     * Obtains the pixel width and height of a grid positionGrid
     * @return
     */
    public static int getCELLHEIGHT() {
        return CELLHEIGHT;
    }

    public static int getCELLWIDTH() {
        return CELLWIDTH;
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
       return new SimpleGfxGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {

        return new SimpleGfxGridPosition(col,row,this);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return CELLHEIGHT*row;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return CELLWIDTH*column;
    }
}
