package org.academiadecodigo.medievalwar.objects.terrain;


import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;


/**
 * Created by codecadet on 12/06/2017.
 */
public abstract class Terrain {

    private double damageMultiplier;

    private double accuraryMultiplier ;

    private GridPosition pos;

    private TerrainType terrainType;


    public Terrain(TerrainType terrainType){
        this.terrainType=terrainType;
    }

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

    public void setTerrainType(TerrainType terrainType) {
        this.terrainType = terrainType;
    }


    @Override
    public String toString() {
        return "Terrain{" +
                ", pos=" + pos +
                ", terrainType=" + terrainType +
                '}';
    }
}
