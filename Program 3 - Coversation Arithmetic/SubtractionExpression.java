/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/

/**
 * Class for subtraction of expression that is a subclass of Expression */
public class SubtractionExpression 
  extends Expression {

/**
 *Creates new subtraction expression */
  public SubtractionExpression(String leftOpInt, String rightOpInt) throws InvalidQuestionException{
    super(leftOpInt, rightOpInt);
  } 

/**
 * Subtracts the given integers */  
  public int evaluate(){
    int product = this.leftOpInt - this.rightOpInt;
    return product;
  }
}

    
    