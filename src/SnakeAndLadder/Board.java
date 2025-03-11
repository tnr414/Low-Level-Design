package SnakeAndLadder;

public class Board {
    private final int size;
    Cell[][] board;
    public Board(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        initBoard(size);
    }
    private void initBoard(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }
    public int getSize() {
        return size;
    }

    public Cell getCell(int position) {
        position--;
        int row = position / size;
        int col = position % size;

        return board[row][col];
    }
}
