# WalkingBoard

A simple Java class representing a 2D walking board game where a player can move around a grid of tiles, each holding a score value. Each tile has a minimum base score, and moving onto a tile allows reading and updating its value.

## 📦 Package Structure

```
walking.game
├── WalkingBoard.java
├── WalkingBoardWithPlayers.java
├── util
│   └── Direction.java
├── player
│   └── Player.java
│   └── MadlyRotatingBuccaneer.java
└── tests
    ├── WalkingBoardTest.java
    └── WalkingBoardWithPlayersTest.java
    └── DirectionStructureTest.java
    └── MadlyRotatingBuccaneerStructureTest.java
    └── PlayerStructureTest.java
    └── WalkingBoardBasicTestSuite.java
    └── WalkingBoardExtendedTestSuite.java
    └── WalkingBoardFullTestSuite.java
    └── WalkingBoardStructureTest.java
    └── WalkingBoardWithPlayersStructureTest.java
```

- **walking.game.WalkingBoard**: Core class managing the board state and player position.
- **walking.game.WalkingBoardWithPlayers**: Extension supporting multiple players.
- **walking.game.util.Direction**: Enum for movement directions (`UP`, `DOWN`, `LEFT`, `RIGHT`).
- **walking.game.player.Player**: Represents a player on the board.
- **tests**: JUnit test cases for both `WalkingBoard` and `WalkingBoardWithPlayers`.

## 🚀 Features

- **Board Initialization**  
  - `WalkingBoard(int size)`: Creates a square board of given size with every tile initialized to `BASE_TILE_SCORE` (3).
  - `WalkingBoard(int[][] initialTiles)`: Creates a board from a 2D array, ensuring each tile’s score is at least `BASE_TILE_SCORE`.

- **Position Handling**  
  - `getPosition()`: Returns current player coordinates `[x, y]`.
  - `isValidPosition(int x, int y)`: Checks bounds.

- **Tile Access**  
  - `getTile(int x, int y)`: Reads score at specified tile (throws `IllegalArgumentException` if out of bounds).
  - `getTiles()`: Returns a deep copy of the tile matrix.

- **Movement Logic**  
  - `moveAndSet(Direction direction, int value)`:  
    - Calculates new position using `getXStep` and `getYStep`.  
    - If move is valid, updates the tile at new position to `value`, moves player, and returns the old tile value.  
    - Invalid moves return `0` without changing state.

- **Multiple Players**  
  - `WalkingBoardWithPlayers`: Manages multiple `Player` instances moving around the same board.

## 📝 Assignment Requirements

- Implement board initialization with boundary checks.
- Support dynamic tile value updates on movement.
- Maintain encapsulation and input validation.
- Use `Direction` enum to calculate movement steps.
- Extend functionality to support multiple players.

## 📄 License

This assignment code is for educational purposes. No external license applied.
