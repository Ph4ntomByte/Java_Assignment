package walking.game;

import walking.game.util.Direction;
import walking.game.util.*;

public class WalkingBoard {
    private int[][] board;
    private int x, y;
    private static final int BASE_TILE_SCORE = 3;


    public WalkingBoard(int size) {
        this.board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = BASE_TILE_SCORE;
            }
        }
        this.x = 0;
        this.y = 0;
    }

    public WalkingBoard(int[][] initialValues) {
        this.board = new int[initialValues.length][];
        for (int i = 0; i < initialValues.length; i++) {
            this.board[i] = initialValues[i].clone();
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = Math.max(BASE_TILE_SCORE, this.board[i][j]);
            }
        }
        this.x = 0;
        this.y = 0;
    }

    public int[] getPosition() {
        return new int[]{this.x, this.y};
    }

    public int getTile(int x, int y) {
        if (!isValidPosition(x, y)) {
            throw new IllegalArgumentException("Invalid position");
        }
        return this.board[x][y];
    }

    public int[][] getTiles() {
        int[][] copy = new int[this.board.length][];
        for (int i = 0; i < this.board.length; i++) {
            copy[i] = this.board[i].clone();
        }
        return copy;
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < this.board.length && y >= 0 && y < this.board[x].length;
    }

public static int getXStep(Direction direction){
    switch(direction){
        case direction.UP: //ha felfele megyunk, akkor az x koordinata nem valtozik
            return 0;
        case direction.DOWN:
            return 0;
        case direction.RIGHT: //ha jobbra megyunk, akkor az x koordinata no
            return 1;
        case direction.LEFT:
            return -1;
        default:return -2;
    }
}

    public static int getYStep(Direction direction){
        switch(direction){
            case direction.UP: //mivel a tomb indexelese miatt invertalni kell a lepes iranyat, ezert csokkenni fog az ertek ha felfele megyunk (ha fellepunk, akkor egyel kisebb tombindexu sorban leszunk)
                return -1;
            case direction.DOWN:
                return 1;
            case direction.RIGHT:
                return 0;
            case direction.LEFT:
                return 0;
            default: return -2;
        }
    }
    public int moveAndSet(Direction direction, int value){  //a direction iranyba lepunk 1-et, es az uj mezon levo erteket value-re valtoztatjuk
        if(!isValidPosition(getXStep(direction)+getPosition()[0],getYStep(direction)+getPosition()[1])){
            return 0;
        }
        this.x+=getXStep(direction);
        this.y+=getYStep(direction);
        int toReturn=getTile(x,y);
        this.board[y][x]=value;
        return toReturn;
    }

    public int setAndMove(int newX, int newY, int newValue) {
        if (!isValidPosition(newX, newY)) {
            return 0;
        }
        this.board[this.x][this.y] = newValue;
        this.x = newX;
        this.y = newY;
        return this.board[newX][newY];
    }
}
