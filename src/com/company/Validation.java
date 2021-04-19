package com.company;

import java.util.Arrays;
import java.util.HashSet;

import static java.lang.String.format;

public class Validation {
    public static String[] validateMoves(String[] moves){
        String validationMessage = """
                                        (-_-)
                                !!!Odd number of moves!!!
                                  !!!At least 3 moves!!!
                                    !!!No same moves!!!
                                            
                                Example Terminal Command:
                java -jar <your_file_name> rock paper scissors lizard spock
                                        (-_-)
                """;
        try {
            if (moves.length <= 1 || moves.length % 2 == 0) {
                throw new Exception(format("Incorrect moves number\n%s", validationMessage));
            }
            if(moves.length != new HashSet<>(Arrays.asList(moves)).size()){
                throw new Exception(format("Same moves\n%s", validationMessage));
            }
        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return moves;
    }
}
