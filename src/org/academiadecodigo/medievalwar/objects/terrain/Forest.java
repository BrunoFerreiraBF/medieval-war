package org.academiadecodigo.medievalwar.objects.terrain;

import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Forest extends Terrain {

    public Forest(GridPosition pos){
        super(1,1,1.2,pos,TerrainType.FOREST);

    }


}
