/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/

/**
 * Creates the abtract class expression that will be the super class
 * for all of the add,subtract,divide,and multiply classes */
public abstract class Expression {
  
  protected int leftOpInt;
  protected int rightOpInt;
  public static NumberConverter numConvertor;

/**
 * Creates new Expression with the two numbers in String form */
  public Expression(String leftOp, String rightOp) throws InvalidQuestionException{
    int leftValue = numConvertor.toNumber(leftOp);
    int rightValue = numConvertor.toNumber(rightOp);
    if(leftValue < 0) {
      throw new InvalidQuestionException();
    }
    else {
     leftOpInt = leftValue; 
    }
    if(rightValue < 0){
      throw new InvalidQuestionException();
    }
    else {
      rightOpInt = rightValue;
    }
  }

/**
 * Abstraction method in which the math takes place in the subclasses */
  public abstract int evaluate();
  
/**
 * Evaluates the two numbers and converts them into number form */  
  public String evaluateInWords() {
    int valueInt = evaluate();
    String valueToString = numConvertor.toWords(valueInt);
    return valueToString;
  }
  
}

  