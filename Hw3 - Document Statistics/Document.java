/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Homework #3     DEADLINE: September 30 2016
 Program Description: Document Statistics
*/ 

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
 

class Document {
  
  private int numTerms;
  private Term[] terms;
  
  public Document () {
    terms = new Term[50];
    numTerms = 0;
  }
  
  public void addToken (String entry){
    boolean existance = false;
    if (numTerms < 50){
      for(int i = 0; i < numTerms; i++){
        if(terms[i].equals(entry)){
          existance = true;
          terms[i].addToFrequency(1);
        }
      }
      if (!existance){
        Term newTerm = new Term(entry);
        numTerms++;
        terms[numTerms] = newTerm;
      }
    }
  }
  
  private String findIndexOfTerms (String existingToken){
    String index = "-1";
    for (int i = 0; i < numTerms; i++){
      if(terms[i].equals(existingToken)){
        index = ""+i;
      }
    }
    return index;
  }
  
  public void printTermFreqs(){
    System.out.println("Term\tFrequency");
    System.out.println("_____     __________");
    for (int i = 0; i < numTerms; i++) {
      System.out.printf("%-10s \t %d\n", terms[i],i);
    }
  }
  
  public int getLetterCount (String letter){
    int totalLetter = 0;
    for(int i = 0; i < numTerms; i++){
      totalLetter += terms[i].getLetterCount(letter);
    }
    return totalLetter;
  }
  
  public static void main (String[] args) throws Exception{
    File file = new File("howmuch.txt");
    
    Scanner input = new Scanner(file);
    Scanner myScanner = new Scanner(System.in);
    
    String correctCommand = "java Document howmuch.txt";
    String commandLine = myScanner.nextLine();
    
    if (commandLine.equals(correctCommand)){
    
    
      PrintWriter output = new PrintWriter(file);
      output.println("How much wood would a woodchuck chuck if a woodchuck could chuck wood");
      output.close();
      
    
      Document doc = new Document();
      
      while(input.hasNext()){
        int counter = 0;
        doc.addToken(input.next());
        counter++;
      }

      doc.printTermFreqs();
      
      System.out.println("Enter a letter and I’ll count its occurrences: ");
      String stringLength = input.nextLine();
      
      if (stringLength.equals("1")){
        System.out.println("That is not a single character!");
      }
      
      else{ 
        int occurances = doc.getLetterCount(stringLength);
        System.out.println("The letter " + stringLength + " appears " +occurances+ " times.");
      }
      

   }
    
    else{
      System.out.println("Usage: java Document filename");
    }
  }  
    
}
  
        
        
        
  
  