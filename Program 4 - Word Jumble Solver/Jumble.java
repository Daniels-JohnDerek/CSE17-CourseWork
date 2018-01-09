/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #4  DEADLINE: November 19,2016
 Program Description: Word Jumble Solver
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * The class which hold the main method and the methods that find
 * the different permutations of the word */
public class Jumble {
  
  /**
   * The method that calls the second findPermutations method and 
   * creates the ArrayList that holds the permutations */
  public static String[] findPermutations(String s){
    String s2 = "";
    ArrayList<String> permutations = new ArrayList<String>();
    findPermutations(s, s2, permutations);
    String[] words = permutations.toArray(new String[permutations.size()]);
    return words;
  }
  
  /**
   * Takes the information from the first findPermutations method and recursively finds
   * all the different ways to arrange the input word */
  private static void findPermutations(String s1, String s2, ArrayList<String> permutations){
    String remainder;
    String word = s1;
    String letter = s2;
    int print = 0;
    
    if( s1.length() == 1){
        permutations.add(s2 + s1);
    }
    else {
      for (int i = 0; i < word.length(); i++){
        remainder = word.substring(0,i) + word.substring( i + 1, word.length());
        findPermutations(remainder, letter + word.charAt(i), permutations);
      }
    }
  }
  
  
  /**
   * Main method */
  public static void main (String[] args) throws Exception {
    
    Scanner input = new Scanner(System.in);
    
    int maxLength = 0; 
    
    /**
     * Checks input from user */
    if(args.length == 2){
      maxLength = input.nextInt();
    }
    else if(args.length == 1){
      maxLength = 10;
    }
    else {
      System.exit(0);
    }
    
    Dictionary dictionary = new Dictionary(maxLength);
    
    /**
     * Finds and reads the file */
    try{
    Scanner fileReader = new Scanner(new File ("us10.dic"));
    
    int counter = 0;
    
    while(fileReader.hasNext()){
      String wordInput = fileReader.nextLine();
      if(wordInput.length() <= maxLength){
        dictionary.addEntry(wordInput);
        counter++;
      }
      else {
        break;
      }
    }
    
    System.out.println("Read in " +counter+ " words.");
    
    /** 
     * Checks the input from the user */
    while(true){
      
      String readString;
      
      System.out.println("Enter a scrambled word: ");
      if(input.hasNextLine()){
        readString = input.nextLine();
      } 
      else {
        readString = null;
      }
      
      if(readString.isEmpty()){
        System.out.println("Goodbye!");
        System.exit(0);
      }
      else if (readString.length() >= 10){
        System.out.println("Word is too long. Try another one!");
      }
      
      /**
       * Checks the words from the file to check if the permutation is an
       * actual word */
      else{
        String s1 = readString;
        String[] resultWords = findPermutations(s1);
        ArrayList<String> foundWords = new ArrayList<String>();
        
          for(int i = 0; i < resultWords.length; i++){
            boolean realWord = dictionary.lookup(resultWords[i]);
            if(realWord == true){
            foundWords.add(resultWords[i]);
            }
          }
          
          /**
           * Delete one of the permutation of a word has the multiple of the same
           * permutation */
          for(int i = 0; i < foundWords.size(); i++){
          for(int j = 0; j < foundWords.size(); j++){
            if (i == j) {
              continue;
            }
            else if ((foundWords.get(i).compareTo(foundWords.get(j))) == 0){
              foundWords.remove(j);
            }
          }
          }
        
        if (foundWords.size() >= 1) {
          System.out.println("The words formed from '" + s1 + "' are:");
          for (int i = 0; i < foundWords.size(); i++){
            System.out.println(foundWords.get(i));
          }
        }
        else {
          System.out.println("No words are formed from '" + s1 + "'");
        }
      }
      
    }
  }
  catch (Exception ex){
      System.out.println("Something went wrong try again");
      System.exit(0);
   }
  
}
}
  
 