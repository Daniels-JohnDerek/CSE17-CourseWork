/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Homework     DEADLINE: October 25, 2016
 Program: CSE Department Personnel
*/

/**
 * A class Faculty which extends the class employee */
public class Faculty
extends Employee{
  
  private String research;
 
  /**
   * Constructor which includes name, title, email, and research of the corresponding
   * faculty in the CSE department */
  public Faculty (String name, String title, String email, String research){
    super(name, title, email);
    this.research = research;
  }
  
  /**
   * A get method for the reasearch of the faculty member */
  public String getResearch(){
    return research;
  }
  
  /**
   * A method which takes the information about a faculty member and returns
   * a string with all the information */
  public String toString(){
    return name + "("+ email+ "), Staff," + title + "\n\t" +research;
  }
  
}
  
  
  
  
