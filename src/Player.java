import objects.units.Mercenary;

public class Player {

    private Mercenary[] units;

    private int gold = 0;
    private boolean playing;

    public void init() {
        // TODO: when game starts, players decide on an amount of gold
        // TODO: after choosing gold amount, buy characters and place them on the field
        // TODO: choose randomly who will start playing
    }

    public void changePlayingState() {
        if(playing) {
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
}
