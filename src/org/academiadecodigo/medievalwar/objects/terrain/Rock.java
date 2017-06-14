package org.academiadecodigo.medievalwar.objects.terrain;

import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Rock extends Terrain{

    public Rock(){
        this.setDamageMultiplier(0);
        this.setAccuracyMultiplier(0);
    }

    public Rock (GridPosition pos) {

        super(pos);
        this.setDamageMultiplier(0);
        this.setAccuracyMultiplier(0);
    }
}
