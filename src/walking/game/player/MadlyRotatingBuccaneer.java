package walking.game.player;
import walking.game.player.Player;


public class MadlyRotatingBuccaneer extends Player{
    private int turnCount;

    public MadlyRotatingBuccaneer(){
        super();
        this.turnCount=0;
    }

    public void turn() {
        for (int i=0; i<turnCount; i++) {
            super.turn();
        }
        turnCount++;
    }

}