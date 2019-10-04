/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;
import java.util.Random;

/**
 *
 * @author advaithnair
 */

public class Run {
    public static void main(String[] args) 
    {
        Random random = new Random(); //randomize

        int[] dieRoll = new int[20];
        for (int i = 0; i < dieRoll.length; i++) 
        {
            dieRoll[i] = random.nextInt(6) + 1;
        } //creates sequence

        System.out.println("Sequence: ");
        
        run(dieRoll); //splits into run or not
       // runCounter(dieRoll); //sorts and identifies
    }

    public static void run(int[] dieRoll) 
    {
        boolean inRun = false; //my own switch statement
        int prevNum = dieRoll[0]; //temp variable
        
        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int fourCount = 0;
        int fiveCount = 0;
        int sixCount = 0; //for counting each variable type
        
        int sumCount = 0; 
        int runCount = 0; //self explanatory

        int tempCount = 0;
        int finalCount = 0; //both for the lengths
        
        for (int i = 0; i < dieRoll.length - 1; i++) {
            if (inRun) {
                tempCount++;
                if (dieRoll[i] != prevNum) {//if the run ends
                    System.out.print(") ");
                    if (tempCount > finalCount) { //if it's longer than the previous, it's the longest
                        finalCount = tempCount;
                    }
                    tempCount = 0;
                    runCount++; //counts run count based off parantheses ending
                    inRun = false; //switches out
                }
            } 
            else if (!inRun) 
            {
                if (dieRoll[i] == dieRoll[i + 1]){
                    System.out.print("(");
                    inRun = true; //swithc out
                } 
                else {
                    System.out.print(" ");
                }
            }

            prevNum = dieRoll[i];
            System.out.print(dieRoll[i] + " ");
        }

        if (inRun && dieRoll[dieRoll.length - 1] == prevNum) {
            System.out.print(" " + dieRoll[dieRoll.length - 1] + ")");
            runCount++; //count after parantheses
        } 
        else if (inRun && dieRoll[dieRoll.length - 1] != prevNum) {
            System.out.print(") " + dieRoll[dieRoll.length - 1]);
            runCount++; //count after paranth
        } 
        else {
            System.out.print(" " + dieRoll[dieRoll.length - 1]);
        }
        
        for (int j = 0; j < dieRoll.length - 1; j++) {
            if (dieRoll[j] == 1) {
                oneCount++;
            }
            else if (dieRoll[j] == 2) {
                twoCount++;
            }
            else if (dieRoll[j] == 3){
                threeCount++;              
            }
            else if (dieRoll[j] == 4){
                fourCount++;              
            }
            else if (dieRoll[j] == 5){
                fiveCount++;              
            }
            else if (dieRoll[j] == 6){
                sixCount++;              
            } //simple count incrementation
        }
        System.out.println("\n1: " + oneCount + "\n2: " + twoCount + "\n3: " + 
                threeCount + "\n4: " + fourCount + "\n5: " + fiveCount + 
                "\n6: " + sixCount); //print each number
        
        sumCount =  (oneCount) + (2*twoCount) + (3*threeCount) + (4*fourCount) + 
                (5*fiveCount) + (6*sixCount); //sum by multiplying counts
        
        System.out.println("Sum: " + sumCount);
        System.out.println("Runs: " + runCount);
        System.out.println("Length: " + finalCount); //simple prints   
    }
    
}
