/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #4  DEADLINE: November 19,2016
 Program Description: Word Jumble Solver
*/

import java.util.ArrayList;

/**
 * This class handles the words that are inputted in from the file
 * and is used to cross reference the permutation and actual words */
public class Dictionary {
  
  public int maxWordLength;
  public ArrayList<String> dictionaryList;
  
  /**
   * Creates a new dictionary when an int in inputted and uses the int
   * to determine the maxWordLength */
  public Dictionary(int maxWordLength){
    this.maxWordLength = maxWordLength;
    dictionaryList = new ArrayList<String>();
  }
  
  /** 
   * No arg constructor and sets the maxWordLength to 10 */
  public Dictionary() {
    this.maxWordLength = 10;
    dictionaryList = new ArrayList<String>();
  }
 
  /**
   * Adds a word from the file into the dictionary  */
  public void addEntry(String word){
    dictionaryList.add(word);
  }
  
  /**
   * Uses binary search to check in the permutation from the user 
   * input is an actual word */
  public boolean lookup(String s){
    int lowBounds = 0;
    int highBounds = 0;
    
    /** 
     * Sets the bounds to search for the certain words */
    for(int i = 0; i < dictionaryList.size(); i++){
      if (dictionaryList.get(i).length() == s.length()){
        lowBounds = i;
        break;
      }
    }
    
    for(int i = 0; i < dictionaryList.size(); i++){
      if (dictionaryList.get(i).length() == s.length() + 1){
        highBounds = i - 1;
        break;
      }
    }
        
    return lookup(s, dictionaryList, lowBounds, highBounds);
  }
  
  /**
   * Second loopup method in which the actual binary search takes place using the 
   * variables determined from the first loopup method */
  private boolean lookup(String s, ArrayList<String> dictionaryList, int low, int high){
    
    if(low > high){
      return false;
    }
    
    int mid = (low + high) / 2;
    
    if (dictionaryList.get(mid).equals(s)) {
      return true;
    }
    else if (dictionaryList.get(mid).compareTo(s) > 0){
      return lookup(s, dictionaryList, low, mid - 1);
    }
    else {
      return lookup(s, dictionaryList, mid + 1, high);
    } 
                              
  }


}
                      