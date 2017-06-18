package org.academiadecodigo.medievalwar.objects.terrain;

import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Sand extends Terrain {

    public Sand(GridPosition pos) {
        super(1, 1, 1, pos, TerrainType.SAND);
    }

}
