package org.academiadecodigo.medievalwar;

import org.academiadecodigo.medievalwar.objects.units.Mercenary;

import java.util.Arrays;

/**
 * @author João David Silva
 */

public class Player {


    private Mercenary[] units;

    private int gold;


    public Player (){

        this.units = new Mercenary[10];
        this.gold=1000;
    }


    public Mercenary[] getUnits() {
        return units;
    }


    public int getGold() {
        return this.gold;
    }


    public void spendGold(int mercenaryCost){

        this.gold -= mercenaryCost;
    }


    @Override
    public String toString() {
        return "Player{" +
                "units=" + Arrays.toString(units) +
                ", gold=" + gold +
                '}';
    }
}
