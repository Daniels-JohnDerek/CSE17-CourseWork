/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/

/**
 * Class for multiplication of expression that is a subclass of Expression */
public class MultiplicationExpression 
  extends Expression {

/**
 *Creates new multiplication expression */
  public MultiplicationExpression(String leftOpInt, String rightOpInt) throws InvalidQuestionException{
    super(leftOpInt, rightOpInt);
  } 

/**
 * multiplies the given integers */
  public int evaluate(){
    int product = this.leftOpInt * this.rightOpInt;
    return product;
  }
}