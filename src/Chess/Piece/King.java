package Chess.Piece;

import Chess.Slot;

public class King  extends Piece {

    public King(PieceColor color) {
        super(PieceType.KING, color);
    }
    @Override
    public boolean isLegalMove(Slot source, Slot destination) {
        return true;
    }
}