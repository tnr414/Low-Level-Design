package Chess.Piece;

import Chess.Slot;

public class Pawn extends Piece {

    public Pawn(PieceColor color) {
        super(PieceType.PAWN, color);
    }
    @Override
    public boolean isLegalMove(Slot source, Slot destination) {
        return Math.abs(source.getRow() - destination.getRow()) == 1 && Math.abs(source.getCol() - destination.getCol()) == 0;
    }
}
