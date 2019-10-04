/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author advaithnair
 */
public class Sort {
    //the following 5 lines of code allow me to access the file to input
    Scanner consoleInput = new Scanner(System.in);
    String input;
    Scanner fileInput;
    int[] inputArray;
    long startTime;
    
    /**
     * The constructor for my class - pretty much the entire program
     */
    public Sort(){
        System.out.println("Enter a number for the corresponding input file:");
        System.out.println("1: input1.txt  \n2: input2.txt  \n3: input3.txt  \n4: input4.txt");
        input = consoleInput.nextLine(); //simple inputs
        
        if(input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2' 
                && input.charAt(0) != '3' && input.charAt(0) != '4'){         
            System.out.println("Enter a number between 1, 2, 3, or 4:");           
            while (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2'
                    && input.charAt(0) != '3' && input.charAt(0) != '4'){
                input = consoleInput.nextLine();
            }
        } //basically ensures everything is a character and not some extraneous variable
        
        try { //checks file existence - simple try catch
            fileInput = new Scanner(new File("input" + input.charAt(0) + ".txt"));
            System.out.println("Now listing contents of input" + input.charAt(0) + ".txt");
        } 
        catch (FileNotFoundException ex){
            ex.printStackTrace();
            System.exit(0);
        }
        
        //Comma filter
        String infile = fileInput.nextLine();
        String[] inputStringArray = infile.split(",");
        
        inputArray = new int[inputStringArray.length];
        for(int i = 0; i < inputStringArray.length; i++){
            inputArray[i] = Integer.parseInt(inputStringArray[i]);
            System.out.println(inputArray[i]);
        }
        
        //Choosing Sort Type
        System.out.println("\nEnter a number for the sort you want to use.");
        System.out.println("1: Bubble Sort \n2: Selection Sort\n3: Table Sort");
        input = consoleInput.nextLine();             
        if(input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2'
                    && input.charAt(0) != '3'){         
            System.out.println("Enter 1, 2, or 3");           
            while (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2'
                    && input.charAt(0) != '3'){
                input = consoleInput.nextLine();
            }
        }
        
        startTime = System.currentTimeMillis(); //Start the timer at this point
        if (input.equals("1")){
            inputArray = bubbleSort(inputArray);
        }
        if (input.equals("2")){
            inputArray = selectionSort(inputArray);
        }
        if (input.equals("3")){
            inputArray = tableSort(inputArray);
        }
        long totalTime = System.currentTimeMillis() - startTime;
        
        //Create a new file
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(new File("output.txt")));
            String output = "";
            for(int i=0; i<inputArray.length; i++){
                System.out.println(inputArray[i]);
                output += inputArray[i] + ",";
            }
            System.out.println("Time Elapsed: " + totalTime + " ms");
            output += "\nTime Elapsed: " + totalTime + " ms";
            pw.write(output);
            pw.close();
        } 
        
        catch (IOException ex){
            ex.printStackTrace();
            System.exit(0);
        }

    }

    /**
     * Compares two numbers and moves larger number ahead
     *
     * @param array converted input array from input file
     * @return array - output and fully sorted array
     */
    int[] bubbleSort(int[] array){
        for(int k=0; k < array.length; k++){
            for(int i=0; i < array.length - 1; i++){
                if(array[i] > array[i+1]){ //left side number is larger
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    //temp variable switch
                }
            }
        }   
        return array;
    }
    
    /**
     * Move smallest number to front of sequence
     *
     * @param array converted input array from input file
     * @return array - output and fully sorted array
     */
    int[] selectionSort(int[] array){
        for(int k=0; k < array.length; k++){
            int smallNumber = array[k];
            int smallIndex = k;
            for(int i=k; i < array.length; i++){ //move smallest in front
                if (array[i] < smallNumber){
                    smallNumber = array[i];
                    smallIndex = i;
                }
            }
            int temp = array[smallIndex];
            array[smallIndex] = array[k];
            array[k] = temp; //swap
        }      
        return array;
    }
    /**
     * Counts frequency of each number and prints out said number that many times
     *
     * @param array converted input array from input file
     * @return array - output and fully sorted array
     */
    
    int[] tableSort(int[] array){
        int[] tally = new int[1001];
        for(int i=0; i < array.length; i++){
            tally[array[i]]++;
        }
        
        int count = 0;
        //i used for the for loop, j used for actual tally
        for(int i = 0; i < tally.length; i++){
            for(int j = 0; j < tally[i]; j++){
                array[count] = i;
                count++;
            }
        }
        return array;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Sort();
    }
    
}