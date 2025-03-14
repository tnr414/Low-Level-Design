package Chess;

import Chess.Piece.Piece;

public class Board {
    private final Slot[][] slots;

    public Board() {
        this.slots = new Slot[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                slots[i][j] = new Slot(i, j);
            }
        }
    }

    public Slot getSlot(int row, int col) {
        return slots[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        slots[row][col].setPiece(piece);
    }

    public Piece getPiece(int row, int col) {
        return slots[row][col].getPiece();
    }
}
