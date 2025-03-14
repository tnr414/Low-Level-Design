package Chess;

import Chess.Piece.Piece;

public class Slot {
    private final int row;
    private final int col;
    private Piece piece;

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Slot(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }
}
