package com.mindsaka;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        TicTac game = new TicTac();
        Souts sout = new Souts();
        sout.gameStartText();



        do {
            System.out.print("Row: ");
            int rows = scan.nextInt();
            System.out.print("Column: ");
            int columns = scan.nextInt();
        game.setRows(rows);
        game.setColumns(columns);
        }
        while(!game.initializeBoard());



        do
        {
            sout.curBoardText();
            game.printBoard();
            int row;
            int col;
            do
            {

                System.out.println("Player " + game.getCurrentPlayerMark() + ", enter an empty row and column to place your mark!");
                System.out.print("Row: ");
                row = scan.nextInt()-1;
                System.out.print("Column: ");
                col = scan.nextInt()-1;
                for (int i = 0; i < 25; ++i){System.out.println();}
            }
            while (!game.placeMark(row, col));
            game.changePlayer();
        }
        while(!game.checkForWin() && !game.isBoardFull());


        if (game.isBoardFull() && !game.checkForWin()) {
            sout.noWinnerText();
        } else {

            sout.curBoardText();
            game.printBoard();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Wins!");


        }

    }
}