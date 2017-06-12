package simpleGfx;

import field.grid.positionGrid.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics positionGrid
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics positionGrid constructor
     *
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid) {

        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);

        simpleGfxGrid = grid;

        rectangle = new Rectangle(  grid.columnToX(super.getCol())+ grid.PADDING , grid.rowToY(super.getRow())+grid.PADDING  , grid.getCellSize() , grid.getCellSize());


        show();

    }

    /**
     * Simple graphics positionGrid constructor
     *
     * @param col  positionGrid column
     * @param row  positionGrid row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);

        simpleGfxGrid = grid;

        rectangle = new Rectangle(grid.getX() + col * grid.getCellSize(), grid.getY() + row * grid.getCellSize(), grid.getCellSize(), grid.getCellSize());

        show();


    }

    /**
     * @see field.grid.positionGrid.GridPosition#show()
     */
    @Override
    public void show() {


        rectangle.fill();

    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();

        //check this later
    }


}
