package objects.terrain;

/**
 * Created by codecadet on 12/06/2017.
 */
public class TerrainFactory {



    public Terrain[] makeTerrain(int cells){


        Terrain[] a= new Terrain[cells];


        for (int i = 0; i <cells ; i++) {

            int random = (int) (Math.random() * TerrainType.values().length);

            TerrainType terrainType = TerrainType.values()[random];

            Terrain ter;






            switch (terrainType) {

                case TALLGRASS:

                    a[i] = new TallGrass(col,row);
                    break;
                case MOUNTAIN:
                    a[i] = new Mountain(col,row);
                    break;
                case FOREST:
                    a[i] = new Forest(col,row);
                    break;
                case ROCK:
                    a[i] = new Rock(col,row);
                    break;

                case NOTYPE:
                    //a[i] = new Rock(x,y);
                    break;
            }

        }
        return a;
    }


}
