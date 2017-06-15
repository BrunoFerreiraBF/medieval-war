package org.academiadecodigo.medievalwar.objects.terrain;

import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Sand extends Terrain {

    public Sand(){
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(0.9);
    }

    public Sand(GridPosition pos) {

        super(pos);
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(0.9);
    }

}
