package org.academiadecodigo.medievalwar.objects.terrain;

import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Mountain extends Terrain {

    public Mountain(GridPosition pos) {
        super(1.2, 1.2, 1, pos, TerrainType.MOUNTAIN);
    }

}
