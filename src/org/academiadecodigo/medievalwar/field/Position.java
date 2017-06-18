package org.academiadecodigo.medievalwar.field;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Position {

    private int x;

    private int y;

    //private double centerX;
    //private double centerY;

    public Position(){}

    public Position(int x, int y) {

        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public double getDistance(int x, int y){

        return (Math.sqrt (Math.pow(   ((double)(x-this.x)),2)  +  Math.pow ((double)(y-this.y),2)));
    }

    public void setX(int x) {
        this.x = x;

    }

    public void setY(int y) {
        this.y = y;
    }
}
