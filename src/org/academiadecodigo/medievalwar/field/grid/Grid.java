package org.academiadecodigo.medievalwar.field.grid;


import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;

public interface Grid {

    /**
     * Initializes the grid
     */
    public void init();

    /**
     * Gets the number of columns in the grid
     *
     * @return the number of columns
     */
    public int getCols();

    /**
     * Gets the number of rows in the grid
     *
     * @return the number of rows
     */
    public int getRows();

    /**
     * Create a random grid positionGrid
     *
     * @return the new grid positionGrid
     */
    public GridPosition makeGridPosition();

    /**
     * Creates a a grid positionGrid in a specific column and row
     *
     * @param col   the positionGrid column
     * @param row   the positionGrid row
     * @return the new grid positionGrid
     */
    public GridPosition makeGridPosition(int col, int row);

}
