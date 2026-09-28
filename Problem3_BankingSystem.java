/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

abstract class BankAccount {
    
    private String accNo;
    protected double balance;

    
    public BankAccount(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public String getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }

    
    public abstract void withdraw(double amt);
}



class SavingsAccount extends BankAccount {

    public SavingsAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
        } 
        else if (amt > balance) {
            System.out.println("Error: Insufficient Funds. Savings cannot go below 0.");
        } 
        else {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        }
    }
}

class CurrentAccount extends BankAccount {

    private double overdraftLimit = 1000.0;

    public CurrentAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
        } 
        else if (amt > balance + overdraftLimit) {
            System.out.println("Error: Withdrawal exceeds overdraft limit.");
        } 
        else {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        }
    }
}


public class Problem3_BankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Select Account Type (1-Savings, 2-Current): ");
        int choice = sc.nextInt();

        System.out.print("Enter Acc No and Initial Balance: ");
        String num = sc.next();
        double bal = sc.nextDouble();

        BankAccount account;

        if (choice == 1) {
            account = new SavingsAccount(num, bal);
        } 
        else if (choice == 2) {
            account = new CurrentAccount(num, bal);
        } 
        else {
            System.out.println("Error: Invalid Account Type.");
            sc.close();
            return;
        }

        System.out.print("Enter withdrawal amount: ");
        double amt = sc.nextDouble();

        account.withdraw(amt);

        System.out.println("Remaining Balance: " + account.getBalance());

        sc.close();
    }
}
