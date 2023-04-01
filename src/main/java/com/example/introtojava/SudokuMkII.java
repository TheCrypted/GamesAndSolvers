package com.example.introtojava;
import java.util.Arrays;
import static java.util.Objects.isNull;
public class SudokuMkII {
    private static int[][] board  = {
            {2,0,0, 0,7,9, 0,4,1},
            {0,7,5, 0,0,0, 0,9,0},
            {0,0,0, 0,8,4, 0,0,0},

            {9,0,6, 4,0,0, 0,0,5},
            {0,0,0, 0,0,0, 0,0,0},
            {7,0,0, 0,0,2, 6,0,3},

            {0,0,0, 8,4,0, 0,0,0},
            {0,1,0, 0,0,0, 8,3,0},
            {5,8,0, 1,6,0, 0,0,4}
        };

    private static boolean isValid(int[][] board, int entryVal, int col, int row){
        for(int i = 0; i < board[0].length; i++){
            if (board[row][i] == entryVal && i != col){
                return false;
            }
        }
        for(int j = 0; j < board.length; j++) {
            if (board[j][col] == entryVal && j != row) {
                return false;
            }
        }
        int blockRow = row/3;
        int blockCol = col/3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if((board[blockRow*3 + i][blockCol*3 + j] == entryVal) && (blockRow*3 + i != row) && (blockCol*3 + j != col) ) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void displayBoard(int[][] board){
        for (int i = 0; i < board.length; i++){
            if(i%3 == 0){
                System.out.println("------------------------------------");
            }
            for (int j = 0; j < board[0].length; j++){
                if (j%3 == 0){
                    System.out.print(" | ");
                }
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.print("------------------------------------");

    }
    private static int[] freeSpace(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if (board[i][j] == 0){
                    return new int[]{i, j};
                }
        }
        }
        return null;
    }
    private static boolean solve(int[][] board){
        int[] coord = freeSpace(board);
        if (isNull(coord)){
            return true;
        }
        int row = coord[0];
        int col = coord[1];

        for(int i = 1; i < 10; i++) {
            if (isValid(board, i, col, row)) {
                board[row][col] = i;

                if (solve(board)) {
                    return true;
                }
                board[row][col] = 0;
            };
        }

        return false;
    }


    public static void main(String[] args) {
        displayBoard(board);
        System.out.println("\n\nThe Solution to the given Sudoku board is as follows: \n");
        solve(board);
        displayBoard(board);
    }
}
