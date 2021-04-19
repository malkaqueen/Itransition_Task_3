package com.company;

import static com.company.GameLauncher.launch;
import static com.company.Validation.validateMoves;

public class Main {

    public static void main(String[] args) {
        launch(validateMoves(args));
    }
}
