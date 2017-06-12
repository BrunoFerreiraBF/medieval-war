package objects.terrain;

/**
 * Created by codecadet on 12/06/2017.
 */
public class TerrainFactory {



    public Terrain[] makeTerrain(int cells){


        Terrain[] a= new Terrain[cells];


        for (int i = 0; i <cells ; i++) {
            int randim= (int) Math.random()TerrainType.values();










            a[i]=




        }


        return a;
    }


}
