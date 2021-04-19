package com.company;

import java.security.NoSuchAlgorithmException;

import static com.company.HMACManagement.createSecretKey;
import static com.company.HMACManagement.hashMessage;

public class GameLauncher {
    public static void launch(String[] moves) {

        Game game = new Game(moves);

        int computerMove = game.MakeComputerMove();
        String secretKey = createSecretKey();
        System.out.println("HMAC: " + hashMessage(game.getMoveName(computerMove), secretKey));

        int playerMove = game.MakePlayerMove();

        if (playerMove == -1) return;
        else {
            System.out.println("Computer move: " + game.getMoveName(computerMove));
            System.out.println("Your move: " + game.getMoveName(playerMove));
            System.out.println(game.calculateResult(computerMove, playerMove));
        }

        System.out.println("HMAC key: " + secretKey);
    }
}
