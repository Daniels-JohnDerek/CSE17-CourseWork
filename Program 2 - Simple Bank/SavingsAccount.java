/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #2     DEADLINE: October 13, 2016
 Program: Simple Bank
*/

/**
 * This class is for savings accounts which is a subclass of BankAccount */
class SavingsAccount
extends BankAccount{
  
  private double interestRate;
  
  /**
   * Creates a new savings accounts when given all the information including the balance */
  public SavingsAccount (int accountNum, String customerName, double balance, double interestRate){
    super(accountNum, customerName, balance);
    this.interestRate = interestRate;
  }
  
  /**
   * Creates a new savings account when given all the information excluding the balance in which case 
   * the balance becomes zero */
  public SavingsAccount (int accountNum, String customerName, double interestRate){
    super(accountNum, customerName);
    this.balance = 0;
    this.interestRate = interestRate;
  }
  
  /**
   * A get method for the interest rate */
  public double getInterestRate(){
    return interestRate;
  }
  
  /**
   * A method that takes the interest rate and applies it to the current 
   * balance of the savings account */
  public void accrueInterest(){
    balance += (balance * (interestRate/100));
  }
  
  /**
   * A method that prints out the bank account information for a savings account */
  public void printAccountInfo(){
    System.out.printf("%-5d %-20s %8.2f Interest Rate: %2.1f%%",accountNum, customerName, balance, interestRate);
    System.out.println();
  }
  
}