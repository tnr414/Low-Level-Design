package Chess.Piece;

import Chess.Slot;

public class Rook  extends Piece {

    public Rook(PieceColor color) {
        super(PieceType.ROOK, color);
    }
    @Override
    public boolean isLegalMove(Slot source, Slot destination) {
        return true;
    }
}
