package objects.terrain;

import field.grid.positionGrid.GridPosition;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Grass extends Terrain {

    public Grass() {
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(1);
    }

    public Grass(GridPosition pos) {

        super(pos);
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(1);
    }
}
