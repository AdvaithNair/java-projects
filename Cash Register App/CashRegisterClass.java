/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregisterapp;

/**
 *
 * @author advaithnair
 */
public class CashRegisterClass {
    public static final double QUARTER_VALUE = 0.25;
    public static final double DIME_VALUE = 0.10;
    public static final double NICKEL_VALUE = 0.05;
    public static final double PENNY_VALUE = 0.01;
    //values of each coin
    
    public double balance = 0; //balance starts at 0

    private double payment;
    private double purchase;
    private int counter;
    //only variables needed internally in the class
    
    public CashRegisterClass() {
    //Creating blank cash register
        payment = 0;
        purchase = 0;
        counter = 0;
    }
    
    public void recordPurchase (double amount){
        purchase = purchase + amount; //adds amt to current purchase counter
        counter = 0; //reset counter after purchase
    }
    
    public void receivePayment (double dollars, double quarters, double dimes, double nickels, double pennies){
        payment = dollars + (quarters*QUARTER_VALUE) + (dimes*DIME_VALUE) + (nickels*NICKEL_VALUE) + (pennies*PENNY_VALUE);  
        //adds payment thru all currencies, condensed version of enterDollars and quarters function
    }
    
    public void enterDollars (int dollars) {
        payment = payment + dollars;
        counter = counter + dollars;
    }
    
    public void enterQuarters (int quarters) {
        payment = payment + (quarters*QUARTER_VALUE);
        counter = counter + quarters;
    }
    
    public void enterDimes (int dimes) {
        payment = payment + (dimes*DIME_VALUE);
        counter = counter + dimes;
    }
    
    public void enterNickels (int nickels) {
        payment = payment + (nickels*NICKEL_VALUE);
        counter = counter + nickels;
    }
    
    public void enterPennies (int pennies) {
        payment = payment + (pennies*PENNY_VALUE);
        counter = counter + pennies;
    }
    //the five functions above follow the same mathematical concept as the revievePayment function except it seperates it and adds to the counter
    
    public int getItemCount(){
        return counter; //self-explanatory
    }
    
    public double giveChange (){
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        return change; //it sets payment and purchase to 0 prior to returning
    }
}
