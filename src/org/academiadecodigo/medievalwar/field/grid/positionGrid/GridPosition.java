package org.academiadecodigo.medievalwar.field.grid.positionGrid;


/**
 * A positionGrid on the grid that is capable of moving around
 */
public interface GridPosition {

    /**
     * Gets the positionGrid column in the grid
     *
     * @return the positionGrid column
     */
    public int getCol();

    /**
     * Gets the positionGrid row in the grid
     *
     * @return the positionGrid row
     */
    public int getRow();

    /**
     * Updates the positionGrid column and row
     *
     * @param col the new positionGrid column
     * @param row the new positionGrid row
     */
    public void setPos(int col, int row);




    /**
     * Displays the positionGrid in the grid
     */
    public void show();

    /**
     * Hides the positionGrid in the grid
     */
    public void hide();


    /**
     * Tests equality with another positionGrid
     *
     * @param position the positionGrid to test against
     * @return true if positions are equal
     */
    public boolean equals(GridPosition position);

}
