package com.company;

import java.util.Random;
import java.util.Scanner;

public class Game {
    String moves[];

    public Game(String[] moves) {
        this.moves = new String[moves.length];
        for (int i = 0; i < moves.length; i++) {
            this.moves[i] = moves[i];
        }
    }

    public String getMoveName(int moveNumber) {
        return moves[moveNumber];
    }

    public int MakeComputerMove() {
        Random number = new Random();
        return number.nextInt(moves.length);
    }

    public int MakePlayerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Moves:");
        for (int i = 0; i < moves.length; i++) {
            System.out.println((i + 1) + " - " + moves[i]);
        }
        System.out.println("0 - exit");

        System.out.print("Enter your move: ");
        return scanner.nextInt() - 1;
    }

    public String calculateResult(int computerMove, int playerMove) {
        int possibleMove;
        String resultMessage = "";

        if (playerMove == computerMove)
            resultMessage = "It's a draw";

        for (int i = 0; i < moves.length / 2; i++) {
            possibleMove = (playerMove + i + 1) % moves.length;
            if (possibleMove == computerMove)
                resultMessage = "You lose";
        }

        for (int i = 0; i < moves.length / 2; i++) {
            possibleMove = (playerMove - i - 1) % moves.length;
            if (possibleMove < 0) possibleMove += moves.length;
            if (possibleMove == computerMove) {
                resultMessage = "You win";
            }
        }

        return resultMessage;
    }
}
