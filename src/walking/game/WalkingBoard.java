package walking.game;

import walking.game.util.Direction;

public class WalkingBoard {
    private int[][] tiles;
    private int x, y;
    public static final int BASE_TILE_SCORE = 3;

    public WalkingBoard(int size) {
        tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j] = BASE_TILE_SCORE;
            }
        }
        x = 0;
        y = 0;
    }

    public WalkingBoard(int[][] initialTiles) {
        tiles = new int[initialTiles.length][];
        for (int i = 0; i < initialTiles.length; i++) {
            tiles[i] = new int[initialTiles[i].length];
            for (int j = 0; j < initialTiles[i].length; j++) {
                tiles[i][j] = Math.max(BASE_TILE_SCORE, initialTiles[i][j]);
            }
        }
        x = 0;
        y = 0;
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < tiles.length && y >= 0 && y < tiles[x].length;
    }

    public int getTile(int x, int y) {
        if (!isValidPosition(x, y)) {
            throw new IllegalArgumentException("Invalid position");
        }
        return tiles[x][y];
    }

    public int[][] getTiles() {
        int[][] copy = new int[tiles.length][];
        for (int i = 0; i < tiles.length; i++) {
            copy[i] = tiles[i].clone();
        }
        return copy;
    }

    public static int getXStep(Direction direction) {
        switch (direction) {
            case LEFT:
                return -1;
            case RIGHT:
                return 1;
            default:
                return 0;
        }
    }

    public static int getYStep(Direction direction) {
        switch (direction) {
            case UP:
                return -1;
            case DOWN:
                return 1;
            default:
                return 0;
        }
    }

    public int moveAndSet(Direction direction, int value) {
        int newX = x + getXStep(direction);
        int newY = y + getYStep(direction);

        if (!isValidPosition(newX, newY)) return 0;

        int oldValue = tiles[newX][newY];
        tiles[newX][newY] = value;
        x = newX;
        y = newY;
        return oldValue;
    }
}
