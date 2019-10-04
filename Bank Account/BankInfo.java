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
public class BankInfo {    
    private int AccountNum;
    private double Balance;
    
    public BankInfo(int Acct){
        AccountNum = Acct;
    }
    
    public BankInfo(int Acct, double Bal){
        AccountNum = Acct;
        Balance = Bal;
    }
    
    public double deposit(double amt) {
        return Balance + amt;
    }
    
    public double withdrawl(double amt) {
        return Balance - amt;
    }
    
    public double getBalance() {
        return Balance;
    }
    public int getAccountNumber() {
        return AccountNum;
    }
    public double monthlyFee(double amt) {
        if (Balance < 100) {
            return Balance - 10;
        }
        else {
            return Balance - amt;
        }
    }
}
