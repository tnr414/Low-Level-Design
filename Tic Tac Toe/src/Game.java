package src;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {

    private  final Board board;
    private  final int boardSize;
    private  final Deque<Player> players;

    public Game(Deque<Player> players, int boardSize) {
        this.players = players;
        this.boardSize = boardSize;
        this.board = new Board(boardSize);

    }


    public String play() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Player currentPlayer = players.removeFirst();
            while (true) {
                System.out.println(currentPlayer.getName() + " Enter position of board");
                int row, col;
                row = sc.nextInt();
                col = sc.nextInt();

                if (board.setPiece(currentPlayer.getPiece(), row, col)) break;
            }

            // print board and check for tie
            boolean isEmptyBlock = false;
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    Piece blockPiece = board.getPiece(i, j);
                    if (blockPiece == null) {
                        System.out.print("|   ");
                        isEmptyBlock = true;
                    }  else {
                        System.out.print("| "+blockPiece.getPieceType().toString()+" ");
                    }
                }
                System.out.println();
            }

            if (!isEmptyBlock) break;

            // determine winner;
            for (int i = 0; i < boardSize; i++) {
                boolean won = true;
                for (int j = 0; j < boardSize; j++) {
                    if (board.getPiece(i, j) == null || !board.getPiece(i, j).getPieceType().equals(currentPlayer.getPiece().getPieceType())) {
                        won = false;
                        break;
                    }
                }
                if (won) {
                    return currentPlayer.getName() + " Won";
                }
            }

            for (int i = 0; i < boardSize; i++) {
                boolean won = true;
                for (int j = 0; j < boardSize; j++) {
                    if (board.getPiece(j, i) == null || !board.getPiece(j, i).getPieceType().equals(currentPlayer.getPiece().getPieceType())) {
                        won = false;
                        break;
                    }
                }
                if (won) {
                    return currentPlayer.getName() + " Won";
                }
            }


            boolean won = true;
            for (int i = 0; i < boardSize; i++) {
                if (board.getPiece(i, i) == null || !board.getPiece(i, i).getPieceType().equals(currentPlayer.getPiece().getPieceType())) {
                    won = false;
                    break;
                }
            }
            if (won) {
                return currentPlayer.getName() + " Won";
            }

            won = true;

            for (int i = 0; i < boardSize; i++) {
                if (board.getPiece(i, boardSize - i - 1) == null || !board.getPiece(i, boardSize - i - 1).getPieceType().equals(currentPlayer.getPiece().getPieceType())) {
                    won = false;
                    break;
                }
            }
            if (won) {
                return currentPlayer.getName() + " Won";
            }

            // move play to last
            players.addLast(currentPlayer);
        }

        return "tie";
    }
}
