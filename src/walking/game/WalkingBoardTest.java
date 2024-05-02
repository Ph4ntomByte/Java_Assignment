package walking.game;

import walking.game.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class WalkingBoardTest{
    @ParameterizedTest
    @CsvSource (textBlock = """
        1,
        7,
        20,
    """)
    public void testSimpleInit(int size){
        walking.game.WalkingBoard wb = new walking.game.WalkingBoard(size);
        int yl=wb.getTiles().length;
        int xl=wb.getTiles()[yl-1].length;
        assertEquals(size,yl,xl);
    }

    @ParameterizedTest
    @CsvSource (textBlock = """
        2, 3, 3
        2, 2, 9
    """)
    public void testCustomInit(int y, int x, int expected){
        int[][] test_tiles={{1,2,3,4},{4,5,6,7},{7,8,9,2},{7,8,9,2}};
        walking.game.WalkingBoard wb=new walking.game.WalkingBoard(test_tiles);
        assertEquals(expected,wb.getTile(x,y));

        test_tiles[x][y]=20;
        assertEquals(expected,wb.getTile(x,y));

        wb.getTiles()[x][y]=20;
        assertEquals(expected,wb.getTile(x,y));
    }

    @ParameterizedTest
    @CsvSource (textBlock = """
        2, 3, 3
        2, 2, 9
    """)
    public void testMoves(){
        walking.game.WalkingBoard wb=new walking.game.WalkingBoard(4);
        int[] pos=wb.getPosition();
        assertEquals(0,pos[0]);
        assertEquals(0,pos[1]);

        wb.moveAndSet(walking.game.util.Direction.RIGHT,1);
        pos=wb.getPosition();
        assertEquals(1,pos[0]);
        assertEquals(0,pos[1]);


        wb.moveAndSet(walking.game.util.Direction.DOWN,1);
        pos=wb.getPosition();
        assertEquals(1,pos[0]);
        assertEquals(1,pos[1]);


        wb.moveAndSet(walking.game.util.Direction.LEFT,1);
        pos=wb.getPosition();
        assertEquals(0,pos[0]);
        assertEquals(1,pos[1]);


        wb.moveAndSet(walking.game.util.Direction.LEFT,1);
        pos=wb.getPosition();
        assertEquals(0,pos[0]);
        assertEquals(1,pos[1]);
    }
}