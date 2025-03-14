package Chess;

import Chess.Piece.PieceColor;

public class Demo {
    public static void main(String[] args) {
        Player player1 = new Player("Rahul", PieceColor.WHITE);
        Player player2 = new Player("Raj", PieceColor.BLACK);

        Game game = new Game(player1, player2);

        game.play();
    }
}
