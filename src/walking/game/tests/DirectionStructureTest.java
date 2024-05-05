package walking.game.tests;

import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class DirectionStructureTest {
    @Test
    public void testEnum() {
        CheckThat.theEnum("walking.game.util.Direction")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .hasEnumElements("UP", "RIGHT", "DOWN", "LEFT");
    }
}

