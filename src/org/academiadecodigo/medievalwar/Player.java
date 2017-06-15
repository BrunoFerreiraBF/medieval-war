package org.academiadecodigo.medievalwar;

import org.academiadecodigo.medievalwar.objects.units.Mercenary;

import java.util.Arrays;

/**
 * @author João David Silva
 */

public class Player {

    private String name;

    private Mercenary[] units;

    private int gold = 0;
    private boolean playing;

    public Player (String name){
        this.name=name;
        this.units = new Mercenary[5];

        this.gold=500;

    }

    public String getName() {
        return name;

    }

    public void setUnits(Mercenary[] units) {
        this.units = units;
    }

    public Mercenary[] getUnits() {
        return units;
    }

    public void init() {
        // TODO: when game starts, players decide on an amount of gold
        // TODO: after choosing gold amount, buy characters and place them on the org.academiadecodigo.medievalwar.field
        // TODO: choose randomly who will start playing
    }

    public void changePlayingState() {
        if (playing) {
            playing = false;
        } else {
            playing = true;
        }
    }

    public int getGold() {
        return this.gold;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public void spendGold(int mercenaryCost){

        this.gold= gold-mercenaryCost;

    }


    @Override
    public String toString() {
        return "Player{" +
                "units=" + Arrays.toString(units) +
                ", gold=" + gold +
                '}';
    }
}
