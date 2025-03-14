package Chess;

import Chess.Piece.*;

import java.util.Scanner;

public class Game {
    Board board;
    Player current;
    Player wait;
    boolean isCheck;
    boolean isCheckMate;
    public Game(Player player1, Player player2) {
        board = new Board();
        initBoard();
        current = player1;
        wait = player2;
        isCheck = false;
        isCheckMate = false;
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        while (!isCheckMate) {
            while (true) {
                System.out.println(current.getName() + " choose a piece and dest");
                int srcRow = sc.nextInt();
                int srcCol = sc.nextInt();
                int destRow = sc.nextInt();
                int destCol = sc.nextInt();

                Piece piece = board.getPiece(srcRow, srcCol);

                if (piece.isLegalMove(board.getSlot(srcRow, srcCol), board.getSlot(destRow, destCol))) {
                    board.setPiece(srcRow, srcCol, null);
                    if (board.getPiece(destRow, destCol) != null) {
                        board.setPiece(destRow, destCol, null);
                    }
                    board.setPiece(destRow, destCol, piece);
                    break;
                } else {
                    System.out.println("Illegal move, try again");
                }
            }

            if (check()) {
                if (checkMate()) {
                    isCheckMate = true;
                    break;
                }
                isCheck = true;
            }

            Player temp = current;
            current = wait;
            wait = temp;
        }
        System.out.println(current.getName() + " won the game");
    }

    private boolean check() {
        return false;
    }

    private boolean checkMate() {
        return false;
    }

    private void initBoard() {
        // pawns
        for (int i = 0; i < 8; i++) {
            Pawn blackPawn = new Pawn(PieceColor.BLACK);
            Pawn whitePawn = new Pawn(PieceColor.WHITE);
            board.setPiece(1, i, whitePawn);
            board.setPiece(6, i, blackPawn);
        }

        // kings
        King blackKing = new King(PieceColor.BLACK);
        King whiteKing = new King(PieceColor.WHITE);
        board.setPiece(0, 3, whiteKing);
        board.setPiece(7, 3, blackKing);

        // queens
        Queen blackQueen = new Queen(PieceColor.BLACK);
        Queen whiteQueen = new Queen(PieceColor.WHITE);
        board.setPiece(0, 4, whiteQueen);
        board.setPiece(7, 4, blackQueen);

        // bishops
        Bishop blackBishop1 = new Bishop(PieceColor.BLACK);
        Bishop whiteBishop1 = new Bishop(PieceColor.WHITE);
        board.setPiece(0, 5, whiteBishop1);
        board.setPiece(7, 5, blackBishop1);
        Bishop blackBishop2 = new Bishop(PieceColor.BLACK);
        Bishop whiteBishop2 = new Bishop(PieceColor.WHITE);
        board.setPiece(0, 2, whiteBishop2);
        board.setPiece(7, 2, blackBishop2);

        // knights
        Knight blackKnight1 = new Knight(PieceColor.BLACK);
        Knight whiteKnight1 = new Knight(PieceColor.WHITE);
        board.setPiece(0, 6, whiteKnight1);
        board.setPiece(7, 6, blackKnight1);
        Knight blackKnight2 = new Knight(PieceColor.BLACK);
        Knight whiteKnight2 = new Knight(PieceColor.WHITE);
        board.setPiece(0, 1, whiteKnight2);
        board.setPiece(7, 1, blackKnight2);

        // rook
        Rook blackRook1 = new Rook(PieceColor.BLACK);
        Rook whiteRook1 = new Rook(PieceColor.WHITE);
        board.setPiece(0, 7, whiteRook1);
        board.setPiece(7, 7, blackRook1);
        Rook blackRook2 = new Rook(PieceColor.BLACK);
        Rook whiteRook2 = new Rook(PieceColor.WHITE);
        board.setPiece(0, 0, whiteRook2);
        board.setPiece(7, 0, blackRook2);
    }
}
