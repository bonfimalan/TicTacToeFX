package test;

import game.TicTacToe;

public class TicTacToeTest {
    public static void test() {
        try {
            System.out.println("Line");

            TicTacToe game = new TicTacToe();

            System.out.println(game.play(0, 0));
            System.out.println(game.play(1, 0));
            System.out.println(game.play(0, 1));
            System.out.println(game.play(1, 1));
            System.out.println(game.play(0, 2));
            System.out.println(game.play(1, 2));

            System.out.println("\nColumn");

            game = new TicTacToe();
            
            System.out.println(game.play(0, 0));
            System.out.println(game.play(0, 1));
            System.out.println(game.play(1, 0));
            System.out.println(game.play(1, 1));
            System.out.println(game.play(2, 0));
            System.out.println(game.play(2, 1));


            System.out.println("\nLeft to right");

            game = new TicTacToe();

            System.out.println(game.play(0, 0)); // X
            System.out.println(game.play(2, 0)); // O
            System.out.println(game.play(1, 1)); // X
            System.out.println(game.play(2, 1)); // O
            System.out.println(game.play(2, 2)); // X

            System.out.println("\nRight to left");

            game = new TicTacToe();
            
            System.out.println(game.play(2, 0)); // X
            System.out.println(game.play(1, 2)); // O
            System.out.println(game.play(1, 1)); // X
            System.out.println(game.play(2, 1)); // O
            System.out.println(game.play(0, 2)); // X
        }
        catch(Exception e) { 
            System.out.println("Exception");
        }
    }
}
