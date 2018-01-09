/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Perfrom math */
public class WordMath {
  
  public static int ADDITION;
  public static int SUBTRACTION;
  public static int MULTIPLICATION;
  public static int DIVISION;

/**
 * Matches questions to entries in templates */
  public Expression parseQuestion(String question, ArrayList templates) throws InvalidQuestionException{
    int questionIndex = templates.indexOf(question);
    if (questionIndex < 0)
      throw new InvalidQuestionException();
    else {
      return parseQuestion(question, templates); 
    }
  }

  /**
 * Main method */
  public static void main(String[] args){
    if (args.length != 1) {
      System.out.println("Usage: java FileDemo filename");
      System.exit(0);
   }
   
    ArrayList questionTemplates = new ArrayList();
    questionTemplates.add(new QuestionTemplate("What is", "plus", "?", WordMath.ADDITION));
    questionTemplates.add(new QuestionTemplate("Tell me the sum of", "and", "?", WordMath.ADDITION));
    questionTemplates.add(new QuestionTemplate("What do I get if I add", "and", "together?", WordMath.ADDITION));
    questionTemplates.add(new QuestionTemplate("What is", "minus", "?", WordMath.SUBTRACTION));
    questionTemplates.add(new QuestionTemplate("", "less", "is what?", WordMath.SUBTRACTION));
    questionTemplates.add(new QuestionTemplate("What is", "times", "?", WordMath.MULTIPLICATION));
    questionTemplates.add(new QuestionTemplate("What do I get when I multiply", "and", "?", WordMath.MULTIPLICATION));
    questionTemplates.add(new QuestionTemplate("What is", "divided by", "?", WordMath.DIVISION));
    
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a question?");
    
    try {
      String userQuestionInput = input.nextLine();
      int result = (parseQuestion(userQuestionInput, questionTemplates)).evaluate();
      String resultText = result.evaluateInWords();
      System.out.println("The answer is " + resultText);
    }
    
    catch (InvalidQuestionException ex){
      System.out.println(ex.getMessage());
      System.exit(0);
    }
    catch (Exception ex){
      System.out.println("error");
      System.exit(0);
    }
  }
}