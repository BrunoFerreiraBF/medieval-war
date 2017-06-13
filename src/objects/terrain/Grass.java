package objects.terrain;

/**
 * Created by codecadet on 12/06/2017.
 */
public class Grass extends Terrain {

    public Grass() {
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(1);
    }

    public Grass(int x, int y) {

        super(x,y);
        this.setDamageMultiplier(1);
        this.setAccuracyMultiplier(1);
    }
}
