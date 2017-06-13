package objects.terrain;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Mountain extends Terrain {

    public Mountain(){
        this.setDamageMultiplier(1.25);
        this.setAccuracyMultiplier(1.1);
    }

    public Mountain(int x, int y) {

        super(x, y);
        this.setDamageMultiplier(1.25);
        this.setAccuracyMultiplier(1.1);
    }

}
