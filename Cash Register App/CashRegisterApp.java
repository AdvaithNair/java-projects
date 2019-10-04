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
public class CashRegisterApp {
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        CashRegisterClass register = new CashRegisterClass();
        
        register.recordPurchase(20.37); //brings in purchase
        register.enterDollars(20);
        register.enterQuarters(2);
        register.enterPennies(33);
        register.enterNickels(3); //enters all the currencies
        //register.receivePayment(23, 2, 0, 0, 0);
       // System.out.println("Change");
        
        System.out.println(register.giveChange());
        System.out.println(register.getItemCount()); //prints values and findings
    }
    
}
