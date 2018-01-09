/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #2     DEADLINE: October 13, 2016
 Program: Simple Bank
*/

/**
 * This class is the super class of BankAccounts which contains the subclasses
 * of checkingAccount and SavingsAccounts */
public class BankAccount {
  
  int accountNum;
  String customerName;
  double balance;
  
  /**
   * Creates a new bank account when given all the information */
  public BankAccount (int accountNum, String customerName, double balance) {
    this.accountNum = accountNum;
    this.customerName = customerName;
    this.balance = balance;
  }
  
  /** 
   * Creates a new bank account when given accountNum and customerName
   * but not given a balance so the balance is set to zero */
  public BankAccount (int accountNum, String customerName){
    this.accountNum = accountNum;
    this.customerName = customerName;
    this.balance = 0; 
  }
  
  /**
   * A get method for the account number */
  public int getAccountNum(){
    return accountNum;
  }
  
  /**
   * A get method for the name of the customer */
  public String getCustomerName(){
    return customerName;
  }
  
  /**
   * A get method for the balance of the bank account */
  public double getBalance(){
    return balance;
  }
  
  /**
   * A method that calculates the new balance when a customer 
   * makes a deposite to their bank account */
  public void makeDeposit(double depositAmt){
    balance += depositAmt;
  }
  
  /**
   * A method that prints out the information about the BankAccount */
  public void printAccountInfo(){
     System.out.printf("%-5d %-20s %8.2f",accountNum, customerName, balance);
     System.out.println();
  }
  
}


    
  
      
  
  
  