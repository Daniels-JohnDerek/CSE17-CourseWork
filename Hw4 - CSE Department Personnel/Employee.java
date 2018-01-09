/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Homework     DEADLINE: October 25, 2016
 Program: CSE Department Personnel
*/

/**
 * Super class which contains Faculty */
public class Employee {
  
  protected String name;
  protected String title;
  protected String email;
  
  /** 
   * Constructor which takes in name, title, and email of each employee
   * and creates a new object */
  public Employee (String name, String title, String email){
    this.name = name;
    this.title = title;
    this.email = email;
  }
  
  /*Get method for the name of the employee member */
  public String getName(){
    return name;
  }
  
  /**
   * Get method for the title of the employee member */
  public String getTitle(){
    return title;
  }
  
  /**
   * Get method for the email of the employee member */
  public String getEmail(){
    return email;
  }
  
  /**
   *  A method which takes the information about a faculty member and returns
   * a string with all the information */
  public String toString(){
    return name + "("+ email+ "), Staff," + title;
  }
  
  /**
   * Determines that two objects are equal if they have the 
   * same email. Overrides the equals method */
  public boolean equals(Object o){
    if (o instanceof Employee) {
      Employee other = (Employee)o;
      if (email == other.email){
        return true;
      }
      else {
        return false;
      }
    }
    return false;
  }
  
}
  
  
    
 
    