package Chess.Piece;

import Chess.Slot;

public class Knight  extends Piece {

    public Knight(PieceColor color) {
        super(PieceType.KNIGHT, color);
    }
    @Override
    public boolean isLegalMove(Slot source, Slot destination) {
        return true;
    }
}