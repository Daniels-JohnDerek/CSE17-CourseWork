/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/

/**
 * Creates class for invalidquestion exception */
public class InvalidQuestionException
  extends Exception {
  
  public InvalidQuestionException() {
    super("Question not understood");
  }
  
}

