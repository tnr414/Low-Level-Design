package src;

public class BoardBlock {
    private final int row;
    private final int col;
    private Piece piece;

    public BoardBlock(int row, int col) {
        this.row = row;
        this.col = col;
        piece = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
       return  this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
