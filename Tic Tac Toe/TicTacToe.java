/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.Scanner;

/**
 *
 * @author advaithnair
 */
public class TicTacToe {
    //board array and players
    int[][] board = new int[3][3];
    final int N = 0; //n for nothing
    final int X = 1;
    final int O = 2;
    
    //variables for turn counter
    final boolean X_TURN = true;
    final boolean O_TURN = false;
    boolean turn = X_TURN;
    
    //variables for the whiles for replay
    boolean playAgain = true;
    boolean repeat;
    
    //counters
    int X_COUNT = 0;
    int O_COUNT = 0;
    int TIE_COUNT = 0;
    
    Scanner scanner;
    String input = "";
    
    public boolean checkWin(int player) { //for all wins
        //row check
        if(board[0][0] == player && board[0][1] == player && board[0][2] == player){
            return true;
        }
        if(board[1][0] == player && board[1][1] == player && board[1][2] == player){
            return true;
        }
        if(board[2][0] == player && board[2][1] == player && board[2][2] == player){
            return true;
        }
        
        //column check
        if(board[0][0] == player && board[1][0] == player && board[2][0] == player){
            return true;
        }
        if(board[0][1] == player && board[1][1] == player && board[2][1] == player){
            return true;
        }
        if(board[0][2] == player && board[1][2] == player && board[2][2] == player){
            return true;
        }
        
        //diagonal check
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[2][0] == player && board[1][1] == player && board[0][2] == player){
            return true;
        }
        
        return false;
    }
    
    public void printBoard(){
        System.out.println(" \t1\t2\t3"); // xo system chosen for board
        for(int row = 0; row < board.length; row++){
            String output =(char)('a'+row) + "\t";
            for(int col = 0; col < board[0].length; col++){
                
                if(board[row][col] == N){
                    output += " \t";
                }
                else if (board[row][col] == X){
                    output += "X\t";
                }
                else if(board[row][col] == O){
                    output += "O\t";
                }
            }
            System.out.println(output);
        }
    }
    
    public boolean checkTie(){ //if board is complete and xo no wins, it's tie
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){ //cheks for full row and column
                if (board[row][col] == N){
                    return false;
                }
            }
        }
        return true;
    }
    
    public TicTacToe() { //print board everytime input is read
        scanner = new Scanner(System.in);
        
        while(playAgain == true){
        System.out.println("Welcome to Tic Tac Toe! Please enter in the format RowColumn. For example, type 'a1' for row a and column 1.");
            while(checkWin(X) == false && checkWin(O) == false && checkTie() == false){ //checks for win every time
                playAgain = false;
                printBoard();
                input = scanner.nextLine();
                if(input.length() != 2){ //checks for proper input
                    System.out.println("Enter a letter followed by a number");
                }
                else if(input.charAt(0) != 'a' && input.charAt(0) != 'b' && input.charAt(0) != 'c'){
                    System.out.println("The row must be a, b, or c");
                }
                else if(input.charAt(1) != '1' && input.charAt(1) != '2' && input.charAt(1) != '3') {
                    System.out.println("The column must be 1, 2, or 3");
                }
                else {
                    int row = input.charAt(0) - 'a';
                    int col = input.charAt(1) - '1';
                    if(board[row][col] == N){
                        if(turn == X_TURN){
                            board[row][col] = X;
                            turn = O_TURN;
                        }
                        else{
                            board[row][col] = O;
                            turn = X_TURN;
                        }
                    }
                    else{
                        System.out.println("That spot is already chosen");
                    }
                }  
            }
            printBoard();

            if(checkWin(X) == true){ //if x wins
                System.out.println("X wins!");
                X_COUNT++;

            }

            else if(checkWin(O) == true){ //if o wins
                System.out.println("O wins!");
                O_COUNT++;
            }

            else if(checkTie() == true){ //if it's a tie
                System.out.println("It's a tie!");
                TIE_COUNT++;
            }
            System.out.println("  X Wins: " + X_COUNT + "\n  O Wins: " + O_COUNT + "\n  Ties: " + TIE_COUNT);
            System.out.println("Wanna play again? Type in 'true' for yes or 'false' for no.");

            repeat = true;

            while(repeat == true){ // asking user if they want to play again and creating a new board if yes
            boolean again = scanner.nextBoolean();

                if(again == true){ 
                    for(int row = 0; row < board.length; row++){
                        for(int col = 0; col < board[0].length; col++){
                            board[row][col] = N; //reset board
                        }
                    }
                    repeat = false;
                    playAgain = true;
                }
                else if(again == false){
                    playAgain = false;
                    repeat = false;
                    System.out.println("Thank you for playing!");
                }
                else{
                    System.out.println("You didn't type in 'true' or 'false' correctly. Please try again with the two options inside the quotations.");
                    repeat = true;
                } 
            }
        }
    }
    
    public static void main(String[] args) {
        new TicTacToe();
    }
    
}
