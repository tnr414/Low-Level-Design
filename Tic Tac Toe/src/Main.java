package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Piece pieceO = new PieceO();
        Piece pieceX = new PieceX();

        Player player1 = new Player("Player1", pieceO, 1);
        Player player2 = new Player("Player2", pieceX, 2);
        Deque<Player> players = new ArrayDeque<>();
        players.addLast(player1);
        players.addLast(player2);

        Game game = new Game(players, 3);
        System.out.println(game.play());
    }
}