package com.company;

import java.security.NoSuchAlgorithmException;

public class GameLauncher {
    public static void launch(String[] moves) {

        Encryption crypt = new Encryption();
        Game game = new Game(moves);

        int computerMove = game.MakeComputerMove();
        System.out.println("HMAC: " + crypt.hashMessage(game.getMoveName(computerMove)));

        int playerMove = game.MakePlayerMove();

        if (playerMove == -1) return;
        else {
            System.out.println("Computer move: " + game.getMoveName(computerMove));
            System.out.println("Your move: " + game.getMoveName(playerMove));
            System.out.println(game.calculateResult(computerMove, playerMove));
        }

        System.out.println("HMAC key: " + crypt.getSecretKey());
    }
}
