package walking.game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class WalkingBoardWithPlayersTest{
    @Test
    public void walk1()
    {
        WalkingBoardWithPlayers w = new WalkingBoardWithPlayers(4, 2);
        assertArrayEquals(new int[]{6, 15}, w.walk(2, 3, 3, 1, 2, 1)); //pontszam vizsgalat
        assertArrayEquals(new int[][]{{3,2,3,4},{11,10,9,8},{3,3,3,3},{3,3,3,3}},w.getTiles()); //vegso allapot vizsgalat

    }

    @Test
    public void walk2()
    {
        WalkingBoardWithPlayers w = new WalkingBoardWithPlayers(5, 3);
        assertArrayEquals(new int[]{12, 12, 9}, w.walk(1, 2, 3, 3, 2, 1, 4, 5, 1));
        assertArrayEquals(new int[][]{{3,1,2,3,4},{3,3,3,3,9},{3,3,3,3,10},{13,13,13,12,11},{3,3,3,3,3}},w.getTiles());
    }
}