package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String player1 = "";
        String player2 = "";
        String winner = "";
        int turnCounter = 1;
        boolean playing = true;
        String[] board = new String[] {"1","2","3","4","5","6","7","8","9"};
        player1 = start(player1);
        if (player1.equals("X")) {
            player2 = "O";
        } else {
            player2 = "X";
        }
        showBoard(board);
        while(playing) {
            if (turnCounter % 2 == 0) {
                selectMove(board, player2);
            } else {
                selectMove(board, player1);
            }
            turnCounter++;
            if(checkForWin(board) != null) {
                winner = checkForWin(board);
                System.out.println("The winner is: " + winner);
                playing = false;
            } else if(checkForDraw(board)) {
                System.out.println("DRAW");
                playing = false;
            }
        }

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
    public static void showBoard(String[] board) {
        for(int i = 0; i < board.length; i++) {
            System.out.print("| " + board[i] + " |");
            if (i == 2 || i == 5) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // asks user for a spot to move to and validates if the input is correct
    public static void selectMove(String[] board, String player) {
        System.out.println("Select a spot: " + player);
        Scanner scan = new Scanner(System.in);

        String move;
        int indexToMove = 0;
        boolean isError;
        do {
            isError = false;
            try {
                move = scan.nextLine();
                indexToMove = Integer.parseInt(move);
            } catch(Exception e) {
                System.out.println("Wrong Input");
                isError = true;
            }
            if ((indexToMove <= 0 || indexToMove > 9) && !isError) {
                System.out.println("Wrong Input");
            }

        } while ((indexToMove <= 0 || indexToMove > 9) || isOccupied(board, indexToMove-1));
        placeMarker(board, indexToMove-1, player);
    }

    // checks if the spot chosen by user is occupied or not
    public static boolean isOccupied(String[] board, int index) {
        if (board[index].equals("X") || board[index].equals("O")) {
            System.out.println("Occupied spot, try different one");
            return true;
        }
        return false;
    }

    // updates the board with new moves
    public static void placeMarker(String[] board, int index, String marker) {
        board[index] = marker;
        showBoard(board);
    }

    // checks the board for winning situation
    public static String checkForWin(String[] board) {

        String[][] winningConditions = {
                {board[0], board[1], board[2]},
                {board[0], board[4], board[8]},
                {board[0], board[3], board[6]},
                {board[2], board[4], board[6]},
                {board[1], board[4], board[7]},
                {board[2], board[5], board[8]},
                {board[3], board[4], board[5]},
                {board[6], board[7], board[8]}
        };

        for (String[] winningCondition : winningConditions) {
            if (winningCondition[0].equals(winningCondition[1]) && winningCondition[1].equals(winningCondition[2])) {
                return winningCondition[0];
            }
        }

        return null;
    }

    // checks the board for a draw
    public static boolean checkForDraw(String[] board) {
        for(int i = 0; i < board.length; i++) {
            if (board[i].equals("X") || board[i].equals("O")) {
                return false;
            }
        }
        return true;
    }
}

