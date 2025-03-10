package src;

public class Board {
    private final BoardBlock [][] blocks;
    private final int boardSize;
    public Board(int boardSize) {
        this.boardSize = boardSize;
        blocks = new BoardBlock[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                blocks[i][j] = new BoardBlock(i, j);
            }
        }
    }


    public Piece getPiece(int row, int col) {
        return blocks[row][col].getPiece();
    }

    public boolean setPiece(Piece piece, int row, int col) {
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            System.out.println("Invalid position try again");
            return false;
        }

        if (blocks[row][col].getPiece() != null) {
            System.out.println("This position is occupied try again");
            return false;
        }
        blocks[row][col].setPiece(piece);
        return true;
    }

}
