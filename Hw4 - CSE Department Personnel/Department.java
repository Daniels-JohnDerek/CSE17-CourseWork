/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Homework     DEADLINE: October 25, 2016
 Program: CSE Department Personnel
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class for the whole department which contains an array of 
 * all the employees */
public class Department{
  
  java.util.ArrayList people;
  
  /**
   * Creates a new department which creates an empty arrayList */
  public Department (){
    ArrayList people = new ArrayList();
  }
  
  /**
    * Adds a person to the ArrayList if the emails are different. 
    * If the emails are the same then it will throw an exception */
  public void addPerson (Employee emp){
    String presentEmail = emp.getEmail();
    for(int i = 0; i < people.size();i++){
      Employee temp = (Employee)(people.get(i));
      if((presentEmail).equals(temp.getEmail())){
        throw new DuplicateEmployeeException(presentEmail);
      }
      else{
        continue;
      }
      
    }
    people.add(emp);
  }
  
  /**
   * Prints the employees information */
  public void printPeople() {
    for(int i = 0; i < people.size(); i++){
      Employee temp = (Employee)(people.get(i));
      String staffInfo = temp.toString();
      System.out.println(staffInfo);
    }
  }
  
  public static void main(String[] args){
    
   if (args.length != 1) {
      System.out.println("Usage: java FileDemo filename");
      System.exit(0);
   }
    

      Department lehighCSE = new Department();
      System.out.println("Reading people from file...");
      

      String filename = args[0];
      File file = new File (filename);
      Scanner input = null;
    
      
      try{
        input = new Scanner(file);
        
      }
      catch (FileNotFoundException ex){
        System.out.println("ERROR: Couldn't read from file " + filename);
        System.exit(1);
      }
      
      
     
      input.useDelimiter("\\t|[\\n\\r\\f]+");
      
      while (input.hasNext()){
      
        if(input.next().equals("S")){
          String name = input.next();
          String title = input.next();
          String email = input.next();
          Employee newEmployee = new Employee(name,title,email);
          try{
            lehighCSE.addPerson(newEmployee);
          }
          catch (DuplicateEmployeeException ex){
            System.out.println("Skipping deplicate for " + email);
          }
          
        }
        else if(input.next().equals("F")){
          String name = input.next();
          String title = input.next();
          String email = input.next();
          String research = input.next();
          Faculty newFaculty = new Faculty(name,title,email,research);
          try{
            lehighCSE.addPerson(newFaculty);
          }
          catch (DuplicateEmployeeException ex){
            System.out.println("Skipping deplicate for " + email);
          }
        }
        else {
          System.out.println("Skipping name. Wrong type: " + input.next());
          String throwAway = input.next();
          String throwAway1 = input.next();

        }
      }
      
      System.out.println("CSE People: (" + lehighCSE.people.size() + " total)");
      
      for(int i = 0; i < lehighCSE.people.size(); i++){
        Employee temp = (Employee)(lehighCSE.people.get(i));
        String printInfo = temp.toString();
        System.out.println(printInfo);
      }
      
    }
    
  }
                


  
    
    
  
  