/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/

import java.util.ArrayList;
import java.util.Collections;

/**
 * Creates class that converts numbers to words and words to numbers */
public class NumberConverter {
  
  private static final String[] FIRST_NUMBERS = {
    "zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven",
    "twelve ","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"
  };
         
  private static final String[] TENS_NUMBERS = {
    "twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"
  };
  
  private ArrayList numbersList;

/**
 * Creates an array of al the objects and sorts them */
  public NumberConverter() {
    ArrayList numbersList = new ArrayList();

    for(int i = 0; i < 20; i++){
      numbersList.add(new NumberWord(i,FIRST_NUMBERS[i]));
    }
    
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 10; j++) {
        if(j == 0){
          numbersList.add(new NumberWord(((i + 2) * 10),TENS_NUMBERS[i]));
        }
        else {
          numbersList.add(new NumberWord((((i + 2) * 10) + j), (TENS_NUMBERS[i] + "-" + FIRST_NUMBERS[j])));
        }
      }
    }  
  
    java.util.Collections.sort(numbersList);
  }
  

/**
 * Searches for a number in word form using binary search */
  private int lookupValueOfWord (String numberWord){
    int low = 0;
    int high = numbersList.size() - 1;
    String key = numberWord;
    
    while(low <= high){
      int mid = ((high + low) / 2);
      if ((key.compareTo(((NumberWord)(numbersList.get(mid))).getInWords())) < 0){
        high = mid - 1;
      }
      else if ((key.compareTo(((NumberWord)(numbersList.get(mid))).getInWords())) == 0){
        return (((NumberWord)numbersList.get(mid)).getValue());
      }
      else {
        low = mid + 1;
      }
      
    }
    return -1;
  }
  

/**
 * Converts words to numbers */
  public int toNumber(String numberWords){
    
    int stringPosition = lookupValueOfWord(numberWords);
    
    if(stringPosition == -1) {
      return stringPosition;
    }
    
    else { 
      return ((NumberWord)(numbersList.get(stringPosition))).getValue();
    }
  }

/**
 * Converts numbers to their equilivant in word form */
  public String toWords(int value){
    
    boolean found = false;
    
    for(int i = 0; i < numbersList.size(); i++){
      if(value == ((NumberWord)numbersList.get(i)).getValue()) {
        found = true;
        return ((NumberWord)numbersList.get(i)).getInWords();
      }
      else {
        continue;
      }
    }
    return ("not a number I can put into words (" + value + ") ");
  }
}
      
      
    
      
      
    
    