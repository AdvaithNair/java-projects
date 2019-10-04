/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicsquareproject;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author advaithnair
 */

public class MagicSquare {

    private int square[][];
    private int n;
    
    /** Constructor of the class 
     *
     * @param square magic square array which will be filled in
     * @param n side length value for the magic square, which is taken from user
     * @param row row incrementation
     * @param column column incrementation
     */
    public MagicSquare(int n) {
        square = new int[n][n];
        this.n = n;
        
        //Creates the Magic Square Itself
        for (int rows = 0; rows < n; rows++) {
            for (int columns = 0; columns < n; columns++) {
                square[rows][columns] = 0;
            }               
        }
        
        //Initializes the 1
        int row = n-1;
        int column = n/2;
        square[row][column] = 1;
        
        int count = 1;
        
        //Places values in the arrays
        while (n*n > count){
            count++;            
            
            //Right Corner
            if (((row + 1) == n) && (column + 1) == n){
                row = 0;
                column = 0;
                square[row][column] = count;
            }
            
            //Max Row
            else if (((row + 1) == n) && (column + 1) < n){
                row = 0;
                column++;
                square[row][column] = count;
            }
            
            //Max Column
            else if (((column + 1) == n) && (row + 1) < n){
                column = 0;
                row++;
                square[row][column] = count;
            }
            
            //Normal
            else {
                row = row + 1;
                column = column + 1;
                square[row][column] = count;
            }
            
            //Overlap Detection
            if (count % n == 0){
                row = row - 2;
                column = column - 1;
            }
        }
    }
    
    /** This method prints each individual value of the magic square, which is already calculated 
     *
     * @return the array gets printed throughout this process
     * @param output the output string that we can print
     */
    public String toString(){
        String output="";
        // code to create your output string
        for (int row = 0; row < n; row++) {
            System.out.print("\n");
            for (int column = 0; column < n; column++) {
                System.out.print(square[row][column] + "\t");
                }               
        }
        System.out.println(output);
    
        return output;
    }
    
}
