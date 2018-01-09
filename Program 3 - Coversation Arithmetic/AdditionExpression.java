/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/

/**
 * Class for addition of expression that is a subclass of Expression */
public class AdditionExpression extends Expression{


/**
 * Create new AdditionExpression */
  public AdditionExpression(String leftOpInt, String rightOpInt) throws InvalidQuestionException{
    super(leftOpInt, rightOpInt);
  } 

/**
 * Adds the given integers */  
  public int evaluate(){
    int product = this.leftOpInt + this.rightOpInt;
    return product;
  }
  
}
