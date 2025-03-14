package Chess.Piece;

import Chess.Slot;

public class Queen  extends Piece {

    public Queen(PieceColor color) {
        super(PieceType.QUEEN, color);
    }
    @Override
    public boolean isLegalMove(Slot source, Slot destination) {
        return true;
    }
}
