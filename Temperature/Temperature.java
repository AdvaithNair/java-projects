package temperature;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

//Created by Advaith Nair

public class Temperature {
    public static void F2C(double f) {
        double out = ((f-32)/1.8);
        System.out.println( f + " degrees Fahrenheit is equivalent to " + out + " degrees Celsius");
    }
    
    public static void F2K(double f) {
        double out = (f+459.67)*0.55555555555555555555556;
        System.out.println( f + " degrees Fahrenheit is equivalent to " + out + " degrees Kelvin");
    } 
    
    public static void C2F(double c) {
        double out = ((c*1.8)+32);
        System.out.println(c + " degrees Celsius is equivalent to " + out + " degrees Fahrenheit");
    }
    
    public static void C2K(double c) {
        double out = ((c+273.15));
        System.out.println(c + " degrees Celsius is equivalent to " + out + " degrees Kelvin");
    }    
    
    public static void K2F(double k) {
        double out = ((k * 1.8) - 459.67);
        System.out.println(k + " degrees Kelvin is equivalent to " + out + " degrees Fahrenheit");
    }
    
    public static void K2C(double k) {
        double out = (k - 273.15);
        System.out.println(k + " degrees Kelvin is equivalent to " + out + " degrees Celsius");
    }
        
    public static void validate(String method, double tempDouble) {
        if (method.equals("F2C") || method.equals("f2c") || method.equals("FTOC") || method.equals("FtoC") || method.equals("ftoc")) {
            F2C(tempDouble);
        }
        else if (method.equals("C2F") || method.equals("c2f") || method.equals("CTOF") || method.equals("CtoF") || method.equals("ctof")) {
            C2F(tempDouble); 
        }
        else if (method.equals("K2F") || method.equals("k2f") || method.equals("KTOF") || method.equals("KtoF") || method.equals("ktof")) {
            K2F(tempDouble); 
        }
        else if (method.equals("K2C") || method.equals("k2c") || method.equals("KTOC") || method.equals("KtoC") || method.equals("ktoc")) {
            K2C(tempDouble); 
        }
        else if (method.equals("C2K") || method.equals("c2k") || method.equals("CTOK") || method.equals("CtoK") || method.equals("ctok")) {
            C2K(tempDouble); 
        }
        else if (method.equals("F2K") || method.equals("f2k") || method.equals("FTOK") || method.equals("FtoK") || method.equals("ftok")) {
            F2K(tempDouble); 
        }
        else {
            System.out.println("That's an invalid input. Restart the program to try again.");
            System.exit(1);              
        }    
    }
    
    public static void printAll(double temp) {
        F2C(temp);
        F2K(temp);
        C2F(temp);
        C2K(temp);
        K2F(temp);
        K2C(temp);
    }
    
    public static void readFile(boolean jig) {
        System.out.print("Enter your file name: ");
    
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
    
        try {
            Scanner file = new Scanner(new File(filename)); // Open file
            String temperature = file.nextLine(); // Read temperature
            double tempDouble = Double.parseDouble(temperature);
            String method = file.nextLine();
            if (jig == false) {
                validate(method, tempDouble);
            }
            else {
                printAll(tempDouble);
            }
        }  
        catch (IOException ex) {
            System.out.println("Error opening file with name " + filename + ". Restart the program to try again.");
            in.close();
            System.exit(1);
        }   
    }
    
    public static void readConsole(boolean jig){
        System.out.print("Input Temperature: ");
        Scanner in = new Scanner(System.in);
        String temperature = in.nextLine();
        double tempDouble = Double.parseDouble(temperature);
        
        if (jig == false) {
            System.out.print("Choose Conversion Method (F2C, F2K, C2F, C2K, K2F, K2C): ");
            Scanner in2 = new Scanner(System.in);
            String method = in2.nextLine();
        
            validate(method, tempDouble);
        }
        else {
            printAll(tempDouble);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Temperature Converter! Would you prefer File or Console Input?");
        Scanner in = new Scanner(System.in);
        String inType = in.nextLine();
        
        System.out.println("You selected " + inType + ". Would you like your output to convert all types?");
        Scanner in2 = new Scanner(System.in);
        String outType = in2.nextLine();
        boolean jig = false;
        
        if (outType.equals("Yes") || outType.equals("yes") || outType.equals("Y") || outType.equals("y")){
            jig = true;
        }
        else if (outType.equals("No") || outType.equals("no") || outType.equals("N") || outType.equals("n")){
            jig = false;
        }
        else {
            jig = false;
        }
        
        if (inType.equals("File") || inType.equals("file") || inType.equals("File Input") || inType.equals("file input")){
            readFile(jig);
        }
        else if (inType.equals("Console") || inType.equals("console") || inType.equals("Console Input") || inType.equals("console input")){
           readConsole(jig);
        }
        else {
            System.out.println("That's an invalid input. Restart the program to try again.");
            System.exit(1);   
        }
    }
    
}
