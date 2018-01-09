/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #2     DEADLINE: October 13, 2016
 Program: Simple Bank
*/

/**
 * This class if for checking accounts which is a subclass of BankAccount */
class CheckingAccount
extends BankAccount{
  
  private double monthlyFee;
  
  /**
   * creates a new checking account when given all the following information */
  public CheckingAccount (int accountNum, String customerName, double balance, double monthlyFee){
    super(accountNum, customerName, balance);
    this.monthlyFee = monthlyFee;
  }
  
  /**
   * get method for the monthly fee */
  public double getMonthlyFee(){
    return monthlyFee;
  }
  
  /**
   * a method that sets the monthly fee for the checking accounts */
  public void setMonthlyFee(double fee){
    monthlyFee = fee;
  }
  
  /**
   * a method that subtracts the monthlyFee from the balance */
  public void applyFee(){
    balance -= monthlyFee;
  }
  
  /**
   * A method that prints out the bank account information for a checking account */
  public void printAccountInfo(){
    System.out.printf("%-5d %-20s %8.2f Monthly Fee: $%2.2f",accountNum, customerName, balance, monthlyFee);
    System.out.println();
  }
  
}
  
  
  
  