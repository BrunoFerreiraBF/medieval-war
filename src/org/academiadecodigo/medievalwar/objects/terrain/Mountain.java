package org.academiadecodigo.medievalwar.objects.terrain;

import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Mountain extends Terrain {

    public Mountain(){
        super(TerrainType.MOUNTAIN);
        this.setDamageMultiplier(1.25);
        this.setAccuracyMultiplier(1.1);

    }

    public Mountain (GridPosition pos) {

        super(pos);
        this.setDamageMultiplier(1.25);
        this.setAccuracyMultiplier(1.1);
    }

}
