/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/

/**
 * Class that implements Comparable */
public class NumberWord implements Comparable {
  
  private int value;
  private String inWords;

/**
 * Initialized fields for the number in both number and letter form */
  public NumberWord(int value, String inWords){
    this.value = value;
    this.inWords = inWords;
  }

/**
 * Get method for value of number */
  public int getValue() {
    return value;
  }

/**
 * Get method for number in letter form */
  public String getInWords() {
    return inWords;
  }

/**
 * Compares the objects in word form */
  public int compareTo(Object obj){
    if ((getInWords().compareTo(((NumberWord)obj).getInWords())) > 0){
      return 1;
    }
    
    else if ((getInWords().compareTo(((NumberWord)obj).getInWords())) < 0) {
      return -1;
    }
    
    else {
      return 0;
    }
  }
  
}