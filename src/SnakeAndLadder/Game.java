package SnakeAndLadder;

import java.util.Deque;

public class Game {
    Board board;
    Deque<Player> players;
    Dice dice;

    public Game(Board board, Deque<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
    }

    String play() {
        while (true) {
            Player currentPlayer = players.removeFirst();
            System.out.println(currentPlayer.getName() + " is current at " + currentPlayer.getPosition());
            int diceNumber = dice.roll();
            int boardSize = board.getSize();
            System.out.println(currentPlayer.getName() +  " rolled dice and got " + diceNumber);
            int nextPosition = currentPlayer.getPosition() + diceNumber;
            if (nextPosition >= boardSize * boardSize) {
                return currentPlayer.getName();
            }
            Cell currentCell = board.getCell(nextPosition);
            Jump hasJump = currentCell.getJump();
            if (hasJump != null) {
                System.out.println(hasJump.getStart() < hasJump.getEnd() ? "Ladder" : "Snake");
                nextPosition = hasJump.getEnd();
            }
            currentPlayer.setPosition(nextPosition);
            System.out.println(currentPlayer.getName() + " moved to position number " + nextPosition);
            players.addLast(currentPlayer);
        }
    }
}
