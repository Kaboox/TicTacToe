package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String player1 = "";
        String player2 = "";
        String[][] board = new String[][] {
                {"1","2","3"},
                {"4","5","6"},
                {"7","8","9"}
        };
        player1 = start(player1);
        if (player1.equals("X")) {
            player2 = "O";
        } else {
            player2 = "X";
        }
        System.out.println("Player1: "+ player1 + "Player2: " + player2);
        showBoard(board);
    }

    // starts the game and asks for sign X or O
    public static String start(String player1) {
        System.out.println("Welcome to the Tic Tac Toe Game");
        System.out.println("Now choose your sign X / O");
        Scanner scan = new Scanner(System.in);
        do {
            player1 = scan.nextLine().toUpperCase();
            if (!player1.equals("X") && !player1.equals("O"))
                System.out.println("Wrong input, try again");
        } while(!player1.equals("X") && !player1.equals("O"));
        return player1;
    }

    // displays current state of the board
    public static void showBoard(String[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

