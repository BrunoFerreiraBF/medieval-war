package org.academiadecodigo.medievalwar.objects.terrain;


import org.academiadecodigo.medievalwar.field.grid.positionGrid.GridPosition;


/**
 * Created by codecadet on 12/06/2017.
 */
public abstract class Terrain {

    private double damageMultiplier;

    private double accuracyMultiplier;

    private double defenseMultiplier;

    private GridPosition pos;

    private TerrainType terrainType;


    public Terrain(double damageMultiplier, double accuracyMultiplier,double defenseMultiplier, GridPosition pos, TerrainType terrainType) {

        this.damageMultiplier = damageMultiplier;
        this.accuracyMultiplier = accuracyMultiplier;
        this.pos = pos;
        this.terrainType = terrainType;
        this.defenseMultiplier=defenseMultiplier;

    }


    public GridPosition getPos() {
        return pos;
    }


    public TerrainType getTerrainType() {
        return terrainType;
    }


    public double getAccuracyMultiplier() {
        return accuracyMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public double getDefenseMultiplier() {
        return defenseMultiplier;
    }



    @Override
    public String toString() {
        return "Terrain{" +
                ", pos=" + pos +
                ", terrainType=" + terrainType +
                '}';
    }
}
