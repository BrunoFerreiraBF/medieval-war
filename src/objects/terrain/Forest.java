package objects.terrain;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Forest extends Terrain {

    public Forest(){
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(0.9);
    }

    public Forest(int x, int y) {

        super(x, y);
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(0.9);
    }

}
