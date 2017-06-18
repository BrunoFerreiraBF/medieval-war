package org.academiadecodigo.medievalwar.objects.terrain;

import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Grass extends Terrain {

    public Grass(GridPosition pos) {
        super(1, 1, 1, pos, TerrainType.GRASS);
    }
}
