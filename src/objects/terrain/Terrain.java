package objects.terrain;


import field.grid.positionGrid.GridPosition;


/**
 * Created by codecadet on 12/06/2017.
 */
public abstract class Terrain {

    private double damageMultiplier;

    private double accuraryMultiplier ;

    private GridPosition pos;

    private TerrainType terrainType;

   // private Position pos;

    public Terrain(){}

    public Terrain(GridPosition pos){
        this.pos = pos;
    }

    public GridPosition getPos() {
        return pos;
    }

    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public void setAccuracyMultiplier(double accuracyMultiplier) {
        this.accuraryMultiplier = accuracyMultiplier;
    }

    @Override
    public String toString() {
        return "Terrain{" +
                ", pos=" + pos +
                ", terrainType=" + terrainType +
                '}';
    }
}
