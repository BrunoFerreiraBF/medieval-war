package objects.terrain;

/**
 * Created by codecadet on 12/06/2017.
 */
public class TerrainFactory {


    public Terrain makeTerrain(int cells) {

        Terrain ter;

        double a=(int) (Math.random());


        if (a>0.75){
            ter= new Grass();
        }

        if (a>0.6){
            ter= new Mountain();
        }

        if (a>0.45){
            ter = new Forest();
        }

        if (a>0.3){
            ter = new Rock();
        }

        else {
            ter = new TallGrass();
        }

        return ter;

        /*

        int random = (int) (Math.random() * TerrainType.values().length);

        TerrainType terrainType = TerrainType.values()[random];

        switch (terrainType) {
            case TALLGRASS:
                 ter = new TallGrass();
                break;

            case MOUNTAIN:
                ter = new Mountain();
                break;

            case FOREST:
                ter = new Forest();
                break;

            case ROCK:
                ter = new Rock();
                break;

            case GRASS:
                ter = new Grass();
                break;


        }

        return ter;
        */
    }
}
