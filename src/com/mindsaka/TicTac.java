package com.mindsaka;


import javax.management.monitor.Monitor;
import java.io.IOException;


public class TicTac {

    private char[][] board;
    private char currentPlayerMark;
    private int rows;
    private int columns;


    public TicTac() {

        currentPlayerMark = 'x';

    }




    public void setRows(int rows) {

        this.rows = rows;
    }

    public void setColumns(int columns) {

        this.columns = columns;
    }

    public int getRows()
    {
        return rows;
    }

    public int getColumns() {

        return columns;
    }




    public char getCurrentPlayerMark() {


        return currentPlayerMark;
    }



    public boolean initializeBoard() {

        if(rows == columns) {

            board = new char[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    board[i][j] = '-';
                }
            }
        }else{


            System.out.println("The number of columns and rows should be the same!");

            return false;


        }
        return true;
    }

    public void printLines() {

        for (int i = 0; i < (columns * 4) + 1; i++) {

            System.out.print("-");
        }
        System.out.println("");
    }



    public void printBoard() {


        printLines();


        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();

        }

        printLines();
    }



    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }



    public boolean checkForWin() {
        if (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin()) {
            return true;
        } else {
            return false;
        }

    }



    private boolean checkRowsForWin() {
        int count = 0;
        char temp;

        for (int i = 0; i < rows; i++) {
            temp = board[i][0];
            for (int j = 0; j < columns; j++) {
                if (board[i][j] != '-' && board[i][j] == temp) {
                    count++;
                }
                if (count == columns) {
                    return true;
                }
            }
            count = 0;
        }
        return false;
    }


    // Loop through columns and see if any are winners.
    private boolean checkColumnsForWin() {
        int count = 0;
        char temp;
        for (int i = 0; i < rows; i++) {
            temp = board[0][i];
            for (int j = 0; j < columns; j++) {
                if (board[j][i] != '-' && board[j][i] == temp) {
                    count++;
                }
                if (count == rows) {
                    return true;
                }
            }
            count = 0;
        }
        return false;
    }



    private boolean checkDiagonalsForWin() {

        int columnOfThatRow = 0;
        int count = 0;
        char temp;
        temp = board[0][0];
        for (int i = 0; i < rows; i++) {

            if (board[i][columnOfThatRow] != '-' && board[i][columnOfThatRow] == temp) {
                count++;
            }
            if (count == rows) {
                return true;
            }
            columnOfThatRow++;
        }

        return false;
    }



    public void changePlayer() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        } else {
            currentPlayerMark = 'x';
        }
    }


    public boolean placeMark(int row, int col) {


        if ((row >= 0) && (row < rows)) {
            if ((col >= 0) && (col < columns)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            } else {
                error("COLUMN");
            }
        } else {
            error("ROW");
        }

        return false;
    }

    public void error(String desc) {

        System.out.println("Error! Choose " + desc + " between grid range: " + rows + " x " + columns);
    }
}
