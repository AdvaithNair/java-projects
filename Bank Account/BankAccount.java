/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

/**
 *
 * @author advaithnair
 */


public class BankAccount {
    public static void main(String[] args) {
        BankInfo checkings = new BankInfo(12);
        BankInfo savings = new BankInfo (143200, 99.54);
        
        System.out.println("Checkings Account Number: " + checkings.getAccountNumber());
        System.out.println("Savings Account Number: " + savings.getAccountNumber());
        System.out.println("Savings Balance: $" + savings.getBalance());
        System.out.println("Deposit to Savings: $" + savings.deposit(10));
        System.out.println("Withdraw from Savings: $" + savings.withdrawl(10));
        System.out.println("Savings Monthly Fee: $" + savings.monthlyFee(21));
    }   
}
