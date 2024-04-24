package walking.game;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({
      WalkingBoardBasicTestSuite.class
    , WalkingBoardExtendedTestSuite.class
})
@Suite public class WalkingBoardFullTestSuite {}
