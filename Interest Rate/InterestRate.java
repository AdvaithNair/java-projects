/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestrate;

import java.util.Scanner;

/**
 *
 * @author advaithnair
 */
public class InterestRate {

    public static int percentFilter(String input){
        char[] toChar = input.toCharArray();
        char[] newChar = {'0', '0'};
        for(int i = 0; i < toChar.length-1; i++){
            System.out.println(toChar[i]);
            newChar[i] = toChar[i];
            System.out.println(newChar[i]);
        }
        return Integer.parseInt(new String(newChar));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean switcherOne = false;
        boolean switcherTwo = false;
        boolean switcherThree = false;
        boolean switcherFour = false;
        
        //Input Purchase Price   
        double price = 0;
        while (switcherOne == false) {
            try{
                System.out.print("Enter Purchase Price: $");
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                price = Double.parseDouble(input);
                while (price < 0) {
                    System.out.print("Error: You cannot buy something for negative money. Try Again.\n");
                    System.out.print("Enter Purchase Price: $");
                    input = in.nextLine();
                    price = Double.parseDouble(input);
                }
                switcherOne = true;
            }
            catch(NumberFormatException ex){
                System.out.println("Error: Input was not of numerical nature. You must input an integer value. Try again.");  
            }
        }
        
        //Input Interest Rate
        double iRate = 0;
        while (switcherTwo == false) {
            try{
                System.out.print("Enter Interest Rate Percent (without % sign): ");
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                char[] trial = input.toCharArray();
                iRate = 0;
                iRate = (Double.parseDouble(input))/100;
                switcherTwo = true;
            }
            catch(NumberFormatException ex){
                System.out.println("Error: Input was not of numerical nature. You must input an integer value. Try again.");  
            }
        }
            
        //Input Down Payment
        double dPayment = 0;
        while (switcherThree == false) {
            try{
                System.out.print("Enter Down Payment Percent (without % sign): ");
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                dPayment = (Double.parseDouble(input))/100;
                switcherThree = true;
            }
            catch(NumberFormatException ex){
                System.out.println("Error: Input was not of numerical nature. You must input an integer value. Try again.");  
            }
        }
        
        double mPayment = 0;
        
        //Input Monthly Payment
        while (switcherFour == false) {
            try{
                System.out.print("Enter Monthly Payment Percent (without % sign): ");
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                mPayment = (Double.parseDouble(input))/100;
                switcherFour = true;
            }
            catch(NumberFormatException ex){
                System.out.println("Error: Input was not of numerical nature. You must input an integer value. Try again.");  
            }
        }
        
        /*
        //Tester Variables
        double price = 950;
        double iRate = 0.12;
        double dPayment = 0.10;
        double mPayment = 0.05;
        */
        
        //Calculation Variables
        int month = 1;
        double balanceOwed = price*(1-dPayment);
        double interest = (balanceOwed*iRate)/12;
        double payment = balanceOwed*mPayment;
        double principal = payment - interest;
        double balanceRemaining = balanceOwed - principal;
        double totalInterest = 0;
        
        //Printing Input Table
        System.out.printf("\nPurchase Price \t $%5.2f %n", price);
        System.out.printf("Interest Rate \t %2.0f %n", iRate*100);
        System.out.printf("Down Payment \t %2.0f \t $%4.2f %n", dPayment*100, dPayment*price);
        System.out.printf("Monthly Payment  %2.0f \t $%4.2f %n", mPayment*100, payment);

        //Output Table
        System.out.printf("\nMonth \t Current Total Balance \t Interest \t Principal "
                + "\t Payment \t Balance\n");
 
        while (balanceOwed > 0) {
            //Calculuations
            interest = (balanceOwed*iRate)/12;
            if (balanceOwed > payment) {
                principal = payment - interest;
                balanceRemaining=balanceOwed-principal;              
            }
            else {
                payment = balanceRemaining + interest;
                principal = balanceRemaining;     
                           
                balanceRemaining = 0;
            }
            
            //Changes printing based on double values (looks better)
            if (interest >= 10) {
            System.out.printf("%d \t $%4.2f \t\t $%4.2f \t $%4.2f \t $%4.2f \t $%4.2f "
                    + "%n", month, balanceOwed, interest, principal, payment, 
                    balanceRemaining); 
            }
            else {
            System.out.printf("%d \t $%4.2f \t\t $%4.2f \t\t $%4.2f \t $%4.2f \t $%4.2f "
                    + "%n", month, balanceOwed, interest, principal, payment, 
                    balanceRemaining);                 
            }
            month++;
            balanceOwed = balanceOwed - principal;
            totalInterest=totalInterest+interest;
        }
        System.out.printf("\nTotal Interest Paid: $%5.2f %n", totalInterest);
        month = 0;
    }
    
}
