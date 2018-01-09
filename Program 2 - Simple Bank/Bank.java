/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #2     DEADLINE: October 13, 2016
 Program: Simple Bank
*/

import java.util.Scanner;
import java.io.File;

/**
 * The class is for the whole bank which includes an array which contains
 * all the of the different BankAccounts */
public class Bank {
  
  private String name;
  private BankAccount[] accounts;
  private int totalAccounts;
  public final int MAX_ACCOUNTS = 20;
  
  /**
   * Creates new bank which in String input as the name of the bank
   * and creates the array of bank accounts */
  public Bank(String name){
    this.name = name;
    totalAccounts = 0;
    accounts = new BankAccount[MAX_ACCOUNTS];
  }
  
  /**
   *  A get method for the name of the bank */
  public String getName(){
    return name;
  }
  
  /**
   * Adds an account to the array of bank accounts and increases
   * the number of totalAccounts */
  public void addAccount(BankAccount newAcct){
    accounts[totalAccounts] = newAcct;
    totalAccounts++;
  }
  
  /**
   * Prints all the information for each BankAccount
   * in the accounts[] array */
  public void printBankSummary(){
    String bankName = getName();
    System.out.println("Bank Name: " +bankName);
    for(int i = 0; i < totalAccounts; i++){
      accounts[i].printAccountInfo();
    }
    System.out.println();
  }
  
  /**
   * This method determines which bank accounts are Saving Accounts
   * and then applies interest to the correct accounts */
  public void accrueInterestToSavingsAccounts(){
    for(int i = 0; i < totalAccounts; i++){
      if(accounts[i] instanceof SavingsAccount){
        SavingsAccount m = ((SavingsAccount)accounts[i]);
        m.accrueInterest();
        accounts[i] = m;
      }
    }  
  }
  
  /**
   * This method determines which accounts are checkings accounts
   * and then applies the checking fee to the appropriate
   * accouts */
  public void applyFeesToCheckingAccounts(){
    for(int i = 0; i < totalAccounts; i++){
      if(accounts[i] instanceof CheckingAccount){
        CheckingAccount m = (CheckingAccount)accounts[i];
        m.applyFee();
        accounts[i] = m;
      }
    }
  }
  
  /**
   * This method reads the bank accounts from the bank account statement
   * or the textfil and then detemines which type the account is and then creates 
   * the approprate account with the given information */
  public void loadAccountsFromFile(File acctFile) throws Exception {
    Scanner input = new Scanner(acctFile).useDelimiter("\\t|[\\n\\r\\f]+");
    String checkingsAcc = "C";
    String savingsAcc = "S";
    while (input.hasNext()){
      if(input.next().equals(checkingsAcc)){
        int accNum = input.nextInt();
        String name = input.next();
        float bal = input.nextFloat();
        float fee = input.nextFloat();
        BankAccount c = new CheckingAccount(accNum, name, bal, fee);
        addAccount(c);
        String skip = input.nextLine();
      }
      else {//(input.next().equals(savingsAcc)){
        int accNum = input.nextInt();
        String name = input.next();
        float bal = input.nextFloat();
        float i = input.nextFloat();
        float iPercentage = i * 100;
        BankAccount c = new SavingsAccount(accNum, name, bal, iPercentage);
        addAccount(c);
        String skip = input.nextLine();
      }
    }
    input.close();
  }
  
  /**
   * Main method */
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    boolean cont;
    if(in.nextLine().equals("java Bank acctinfo.txt")){ //Checks user input
      cont = true;
    }
    else {
       System.out.println("Incorrect command-line argument"); 
//If the user doesnt input the correct line
       cont = false;
    }
    
    if(cont){
      String bName = "Java S&L";
      Bank bank = new Bank (bName); //Creates new Bank
      
      java.io.File acctFile = new java.io.File("acctinfo.txt");
      //New file 
      bank.loadAccountsFromFile(acctFile); //
      
      bank.printBankSummary();
      bank.accrueInterestToSavingsAccounts();
      bank.applyFeesToCheckingAccounts();
      
      bank.printBankSummary();
    }
       
  }
}
         
         
      
    
      
      
      
        
           
        
    
          
    
    
    