//Created by Advaith Nair
package guessinggame;

import java.util.Scanner;
import java.lang.Math;

public class GuessingGame {
    public static int autoRandomize (int min, int max) {
        int range = max - min + 1; //range calculation
        return (int)(Math.random() * range) + min; //truncation + randomize
    } //makes randomizing really really simple
    
    public static void main(String[] args) {
        boolean facts = false; //set to true to exit while loop
        
        int rand = autoRandomize(1,50); //baseline for the rest of the program
        //System.out.println("Random Number:" + rand);
        //above line is for testing purposes only
        System.out.println("Welcome to Guessing Game! Take your first guess!");

        while (facts == false) {
            //int scanner setup
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            
            //this stuff is pretty self explanatory, just simple if/else clauses
            if (x > rand) {
                System.out.println("Guessed too high. Try again.");
            }
            else if (x < rand) {
                System.out.println("Guessed too low. Try again.");     
            }
            else if (x == rand) {
                System.out.println("You got it right! Good job bro! Wanna play again? Press 1 for yes and 2 for no");
                Scanner yn = new Scanner(System.in);
                int b = yn.nextInt();
                if (b == 1){
                    System.out.println("Let's do it again then!");
                    rand = autoRandomize(1,50);
                    facts = false;
                }
                else if (b == 2) {
                    System.out.println("Thanks for playing!");
                    facts = true;
                }
                else {
                    System.out.println("That's not a valid answer, so I assume that means no. Thanks for playing!");
                    facts = true;
                }
            }
        }
    }
    
}
