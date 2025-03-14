package Chess;

import Chess.Piece.PieceColor;

public class Player {
    private final String name;
    private final PieceColor pieceColor;

    public String getName() {
        return name;
    }

    public Player(String name, PieceColor color) {
        this.name = name;
        this.pieceColor = color;
    }
}
