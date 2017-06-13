package objects.terrain;

/**
 * Created by codecadet on 12/06/2017.
 */
public class TallGrass extends Terrain {

    public TallGrass(){
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(0.9);
    }

    public TallGrass(int x, int y) {

        super(x, y);
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(0.9);
    }

}
