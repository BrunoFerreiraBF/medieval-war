package objects.terrain;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Rock extends Terrain{

    public Rock(){
        this.setDamageMultiplier(0);
        this.setAccuracyMultiplier(0);
    }

    public Rock(int x, int y) {

        super(x, y);
        this.setDamageMultiplier(0);
        this.setAccuracyMultiplier(0);
    }
}
