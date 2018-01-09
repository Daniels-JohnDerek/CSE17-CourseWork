/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Homework     DEADLINE: October 25, 2016
 Program: CSE Department Personnel
*/

/**
 * class for the exception which extends the ArrayStore
 * Exception */
public class DuplicateEmployeeException
extends ArrayStoreException{
  
  private String email;
  
  /**
   * Sets the exception message */
  public DuplicateEmployeeException(String email){
      super("Duplicate employee: " + email);
      }
  
  /**
   * Get method for the email of the employee */
  public String getEmail(){
    return email;
  }
  
}


  