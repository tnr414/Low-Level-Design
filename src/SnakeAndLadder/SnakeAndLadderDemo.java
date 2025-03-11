package SnakeAndLadder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SnakeAndLadderDemo {
    public static void main(String[] args) {
        Player rahul = new Player(1, "Rahul");
        Player raj = new Player(2, "Raj");
        Board board = new Board(10);
        Dice dice = new Dice();
        Deque<Player> players = new ArrayDeque<>();
        players.addLast(rahul);
        players.addLast(raj);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of snake and ladder");

        int noOfSnake = sc.nextInt(), noOfLadders = sc.nextInt();

        addSnakes(board, noOfSnake);
        addLadders(board, noOfLadders);
        Game game = new Game(board, players, dice);

        String winner = game.play();
        System.out.println(winner + " won the game");
    }

    private static void addSnakes(Board board, int noOfSnakes) {
        while (noOfSnakes > 0) {
            int start = ThreadLocalRandom.current().nextInt(0, 100);
            int end = ThreadLocalRandom.current().nextInt(0, 100);

            if (start > end) {
                Cell cell = board.getCell(start);
                Jump jump = new Jump(start, end);
                cell.setJump(jump);
                noOfSnakes--;
            }
        }
    }

    private static void addLadders(Board board, int noOfLadders) {
        while (noOfLadders > 0) {
            int start = ThreadLocalRandom.current().nextInt(0, 100);
            int end = ThreadLocalRandom.current().nextInt(0, 100);

            if (start < end) {
                Cell cell = board.getCell(start);
                Jump jump = new Jump(start, end);
                cell.setJump(jump);
                noOfLadders--;
            }
        }
    }
}
