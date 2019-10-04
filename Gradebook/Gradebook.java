/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebook;

import java.util.Scanner;
/**
 *
 * @author advaithnair
 */

public class Gradebook {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        int gradeHigh = -1000; //highest grade
        int gradeLow = 1000;//lowest grade
        
        int grades[]; //the int array
        int gradeInput; //temp  
        
        double gradeSum = 0; //sum of grades
        int gradeCount = 0; //number of grades
        double gradeAverage; //avg grades, assigned later when relevant
        
        boolean exitSwitcher1 = false;
        boolean exitSwitcher2 = false; //i'm using booleans to exit two loops
        
        while(exitSwitcher1 == false){  //used to determine user input mess ups and all
            try{
                System.out.println("How many grades are there?");
                gradeCount = Integer.parseInt(in.nextLine());
                if (gradeCount < 1 || gradeCount > 20){ //ensures that the number of grades inputted is in between 1 and 20
                       System.out.println("Your number isn't between 1 and 20. Try again.");
                } 
                else{
                    exitSwitcher1 = true; //exits input, initiates rest of program
                }
             }
             catch(NumberFormatException ex){
                 System.out.println("Error: Input was not of numerical nature. You must input an integer value. Try again.");  
             }

            if(exitSwitcher1 == true){ //this only works if input passes the initial check

                grades = new int[gradeCount]; //declare array
                for(int idk = 0; idk < grades.length; idk++){ //used to input each grade
                    grades[idk] = idk;
                    System.out.println("Enter grade " + (idk + 1) + ":");
                    
                    try{
                        gradeInput = Integer.parseInt(in.nextLine());
                        grades[idk] = gradeInput;
                        gradeSum = gradeSum + gradeInput; //add the grade values
                        exitSwitcher2 = true;
                    }
                    catch(NumberFormatException ex){
                        System.out.println("Error: Input was not of numerical nature. You must input an integer value. Try again.");
                        //literally the same thing as before
                    }
                }

                for(int i = 0; i < grades.length; i++){ //sorts to highest and lowest grade     
                    if(grades[i] > gradeHigh){
                        gradeHigh = grades[i]; //check if a value is higher than the highest
                    }
                    if(grades[i] < gradeLow){
                        gradeLow = grades[i]; //checks if a value is lower than the lowest
                    }
                }
                                    
                gradeAverage = gradeSum/gradeCount;
                System.out.println("Highest Grade: " + gradeHigh);
                System.out.println("Lowest Grade: " + gradeLow);
                System.out.println("Average Grade: " + (gradeAverage)); //simple outputs

                if((gradeAverage) >= 90){ //prints the final grade
                    System.out.println("Final Grade: A");
                }
                else if ((gradeAverage) >= 80){
                    System.out.println("Final Grade: B");
                }
                else if ((gradeAverage) >= 70){
                    System.out.println("Final Grade: C");
                }
                else if ((gradeAverage) >= 60){
                    System.out.println("Final Grade: D");
                }
                else{
                    System.out.println("Final Grade: F");
                }

            }

        }
    }
}
