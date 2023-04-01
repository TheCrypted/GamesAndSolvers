package com.example.introtojava;
import java.util.Scanner;
class TicTacToe {

    public void displayBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            if(i == 0){
                System.out.println("   |  1  |  2  |  3  |");
                System.out.println("---+-----+-----+-----+");
                for(int j = 0; j < board[i].length; j++){
                    if(j == 0){
                        System.out.print(i+1 + "  |  ");
                        System.out.print(board[i][j] + "  |  ");
                    } else {
                        System.out.print(board[i][j] + "  |  ");
                    }
                }
            } else {
                System.out.println("\n---+-----+-----+-----+");
                for(int j = 0; j < board[i].length; j++) {
                    if(j == 0){
                        System.out.print(i+1 + "  |  ");
                        System.out.print(board[i][j] + "  |  ");
                    } else {
                        System.out.print(board[i][j] + "  |  ");
                    }
                }
            }
        }
    }
    public boolean completionCheck(char[][] board){
        for(char[] row : board){
            for(char value : row){
                if(value == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean valid(String[] listCoord, char[][] board){
        return board[Integer.parseInt(listCoord[0])-1][Integer.parseInt(listCoord[1])-1] == ' ';
    }

    public boolean win(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board[i].length; j++) {
                if ((board[i][j] == board[i][0]) && (board[i][j] != ' ')) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                if ((board[i][j] == board[0][j]) && (board[i][j] != ' ')) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != ' ') || (board[2][0] == board[1][1]
                && board[1][1] == board[0][2] && board[1][1] != ' ') ){
            return true;
        }
        return false;
    }

}

class Tic{

    public static void main(String[] args){
        while(true) {
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);
            char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            TicTacToe game = new TicTacToe();
            game.displayBoard(board);
            while (!game.completionCheck(board)) {
                System.out.println("\nEnter Player1 move: ");
                String player1Ch = sc.nextLine();
                String[] move = player1Ch.split(" ");
                if (game.valid(move, board)) {
                    board[Integer.parseInt(move[0])-1][Integer.parseInt(move[1])-1] = 'X';
                    game.displayBoard(board);
                } else {
                    while (!game.valid(move, board)) {
                        System.out.println("You can play only on empty spaces. ");
                        System.out.println("\nEnter Player1 move: ");
                        player1Ch = sc.nextLine();
                        move = player1Ch.split(" ");
                    }
                    board[Integer.parseInt(move[0])-1][Integer.parseInt(move[1])-1] = 'X';
                    game.displayBoard(board);
                }
                if (game.win(board)) {
                    System.out.println("Congratulations!!! X's wins");
                    break;
                }
                if (game.completionCheck(board)) {
                    break;
                }
                System.out.println("\n Enter Player2 move: ");
                String player2Ch = sc2.nextLine();
                String[] move2 = player2Ch.split(" ");
                if (game.valid(move2, board)) {
                    board[Integer.parseInt(move2[0]) - 1][Integer.parseInt(move2[1]) - 1] = 'O';
                    game.displayBoard(board);
                } else {
                    while (!game.valid(move2, board)) {
                        System.out.println("You can play only on empty spaces. ");
                        System.out.println("\nEnter Player2 move: ");
                        player2Ch = sc2.nextLine();
                        move2 = player2Ch.split(" ");
                    }
                    board[Integer.parseInt(move2[0]) - 1][Integer.parseInt(move2[1]) - 1] = 'O';
                    game.displayBoard(board);
                }
                if (game.win(board)) {
                    System.out.println("Congratulations!!! O's wins");
                    break;
                }
            }
            if (!game.win(board)) {
                System.out.println("It's a draw...");
            }
            System.out.println("Do you wish to play again? (Y/Anything else) ");
            String replay = sc3.nextLine();
            if (replay.toLowerCase().equals("y")) {
                continue;
            } else {
                break;
            }


        } System.out.println("Thanks for playing :D");
    }
}

