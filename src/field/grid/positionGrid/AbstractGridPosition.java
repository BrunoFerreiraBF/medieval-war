package field.grid.positionGrid;

import field.grid.Grid;
import simpleGfx.SimpleGfxGrid;


/**
 * Base skeleton for a grid positionGrid
 *
 * @see GridPosition
 */
public abstract class AbstractGridPosition implements GridPosition {

    private int col;
    private int row;

    private Grid grid;


    /**
     * Construct a new grid positionGrid at a specific column and row
     *  @param col   the column of the grid positionGrid
     * @param row   the row of the grid positionGrid
     * @param grid  the grid in which the positionGrid will be displayed
     */
    public AbstractGridPosition(int col, int row, SimpleGfxGrid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;

    }

    public Grid getGrid() {
        return grid;
    }

    /**
     * @see GridPosition#setPos(int, int)
     */
    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    /**
     * @see GridPosition#getCol()
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * @see GridPosition#getRow()
     */
    @Override
    public int getRow() {
        return row;
    }


    /**
     * @see GridPosition#equals(GridPosition)
     */
    @Override
    public boolean equals(GridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
    }


    @Override
    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }

}
