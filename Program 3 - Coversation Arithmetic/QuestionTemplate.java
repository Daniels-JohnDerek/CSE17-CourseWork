/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #3     DEADLINE: November 6, 2016
 Program: Conversational Arithmetic
*/

/**
 * A pattern for the arithmetic questions */
public class QuestionTemplate {
  
  private String preText;
  private String middleText;
  private String endText;
  private int operation;

/**
 * Initializes the fields */
  public QuestionTemplate (String preText, String middleText,
                           String endText, int operation){
    this.preText = preText;
    this.middleText = middleText;
    this.endText = endText;
    this.operation = operation;
  }

/**
 * Return true if the question mathes the template */
  public boolean isMatch(String question){
    int preTextIndex = question.indexOf(preText);
    int middleTextIndex = question.indexOf(middleText);
    if (preTextIndex < middleTextIndex)
      return false;
    int endTextIndex = question.indexOf(endText);
    if (middleTextIndex < endTextIndex)
      return false;
    if (preTextIndex < endTextIndex) 
      return false;
    
    return true;
    
  }

/**
 * Returns the subtype of Expression for the question */
  public Expression parseQuestion(String question){
    int preTextIndex = question.indexOf(preText);
    int preTextLength = preText.length();
    int middleTextIndex = question.indexOf(middleText);
    String leftOp;
    String rightOp;
    
    int i = preTextIndex + preTextLength + 1;
    leftOp = question.substring(i);

    int middleTextLength = middleText.length();
    
    int j = middleTextIndex + middleTextLength + 1;
    rightOp = question.substring(j); 
    
    String cleanRightOp = rightOp.trim();
    String cleanLeftOp = leftOp.trim();
    
    return parseQuestion(cleanLeftOp);
    
  }
  
}
    
  