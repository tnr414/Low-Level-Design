package Chess.Piece;

import Chess.Slot;

public class Bishop extends Piece {

    public Bishop(PieceColor color) {
        super(PieceType.BISHOP, color);
    }
    @Override
    public boolean isLegalMove(Slot source, Slot destination) {
        return true;
    }
}