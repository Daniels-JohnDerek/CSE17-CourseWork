/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/


/**
 * Class for division of expression that is a subclass of Expression */
public class DivisionExpression 
  extends Expression {

/**
 *Creates new division expression */
  public DivisionExpression(String leftOpInt, String rightOpInt) throws InvalidQuestionException{
    super(leftOpInt, rightOpInt);
  } 

/**
 * divides the given integers */  
  public int evaluate(){
    int product = this.leftOpInt / this.rightOpInt;
    return product;
  }
}