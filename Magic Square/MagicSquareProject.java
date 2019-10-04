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
public class MagicSquareProject {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        //Starting Variables
        int sideLength = 0;
        boolean switcherOne;
        System.out.println();
        
        //Input Method
        try{
            //Simple Ask
            System.out.print("Enter Side Length (Odd Integer Only): ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            sideLength = Integer.parseInt(input);
            
            //Blocks Negatives
            while (sideLength < 0) {
                System.out.print("Error: You have a negative side length. Try Again.\n");
                System.out.print("Enter Side Length (Odd Integer Only): ");
                input = in.nextLine();
                sideLength = Integer.parseInt(input);
            }
            
            //Blocks Evens
            while(sideLength % 2 == 0) {
                System.out.println("Input Failure. Please Enter an Odd Number. Try Again.");
                System.out.print("Enter Side Length (Odd Integer Only): ");
                input = in.nextLine();
                sideLength = Integer.parseInt(input);
            }
            
            //Exit
            switcherOne = true;
        }
        catch (NumberFormatException ex){
            //Error  Message
            System.out.println("Error: Input was not of numerical nature. You must input an integer value. Try again.");  
        }
        
        //Init Class
        MagicSquare main = new MagicSquare(sideLength);
        
        //Print
        System.out.println(main.toString());
    }
    
}