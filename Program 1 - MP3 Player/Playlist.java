/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #1     DEADLINE: September 22 2016
 Program: MP3 Player
*/ 

import java.util.Scanner;

/**
 * Takes information form song class and organized them in a playlist style */
class Playlist {

  private String name;
  private Song[] songs;
  private int numSongs;
  public final int DEFAULT_CAPACITY = 10;
  
  /**
   * Constructor that has a default capacity of 10 */
  public Playlist (String name){
    this.name = name;
    numSongs = 0;
    songs = new Song[DEFAULT_CAPACITY];
  }
  
  /**
   * Constructs that allows for input for capacity */
  public Playlist (String name, int capacity){
    this.name = name;
    numSongs = 0;
    songs = new Song[capacity];
  }
  
  /**
   * Get method for the name of the playlist */
  public String getName() {
    return name;
  }
  
  /**
   * Get method for a song in a specific position in the playlist */
  public Song getSong (int position) {
    return songs[(position - 1)];
  }
  
  /**
   * Get method for the number of songs in the playlist */
  public int getNumSongs () {
    return numSongs;
  }
  
  /**
   * Get method for the combined time of all the songs in the playlist */
  public int getTotalTime () {
    int timeTotal = 0;
    for (int i = 0; i < numSongs; i++){
      timeTotal += songs[i].getLength();
    }
    return timeTotal;
  }
  
  /**
   * Method that adds a song to the playlist */
  public void addSong (Song song) {
    int numOfSongs = getNumSongs();
    if(numOfSongs < songs.length){
      songs[numOfSongs] = song;
    }
    numSongs++;
  }
  
  /**
   * Method that prints all the songs in the playlist and the total time,number of songs, and name of playlist */
  public void printList () {
    System.out.println(getName());
    int times = getTotalTime();
    Song temp = new Song("", "", "", 0, 0);
    String timeFormat = temp.secsToTimeString(times);
    System.out.println("Total time " + timeFormat);
    System.out.println("Contains " +getNumSongs()+ " songs");
    for (int i = 0; i < numSongs; i++){
      System.out.print( (i + 1) + "\t");
      songs[i].printSongRow();
    }
  }
  
  

      
public static void main (String[] args) 
{
  
  Scanner input = new Scanner(System.in);
  
  System.out.println("Name your playlist: ");
  
  String playlistName = input.nextLine();
  boolean runProgram = true;
  
  Playlist playlistVar = new Playlist(playlistName);
  
  //Loop for user interface
  while (runProgram) 
  {
    System.out.println("Command [1=Add, 2=Sort, 3=Print, 0=quit]?");
    int choice = input.nextInt();
    
    //When the user enters a 1 to add a new song
    if (choice == 1)
    {
      System.out.println("Add a song.");
      String clear = input.nextLine();
      
      System.out.println("Song title? ");
      String t = input.nextLine();
      
      System.out.println("Artist? ");
      String ar = input.nextLine();
      
      System.out.println("Album? ");
      String al = input.nextLine();
      
      System.out.println("Year? ");
      int y = input.nextInt();
      
      System.out.println("Time (seconds)? ");
      int l = input.nextInt();
      
      Song song = new Song (t,ar,al,y,l);
      playlistVar.addSong(song);
      
    }
    
    //When the user enters a 2 to sort the songs in the playlist
    else if (choice == 2)
    {
      System.out.println("Sorting playlist by year.");
      
      for (int i = 0; i < playlistVar.getNumSongs(); i++)
      {
        int minIndex = i;
        for (int j = i + 1; j < playlistVar.getNumSongs(); j++)
        {
          if (playlistVar.songs[j].getYear() < playlistVar.songs[minIndex].getYear())
          {           
            minIndex = j;
          }
        }
  
          Song temp = null;
          temp = playlistVar.songs[i];
          playlistVar.songs[i] = playlistVar.songs[minIndex];
          playlistVar.songs[minIndex] = temp;
        
      }
    }
    
    //When the user enters a 3 to print the playlist
    else if(choice == 3)
    {
      playlistVar.printList();
    }
    
    //When the user enter a 0 to exit the program
    else if(choice == 0)
    {
      runProgram = false;
      break;
    }
    
    //When the user enter anything else
    else
    {
      System.out.println("Invalid command. Try again.");
    }
    
  }
}
}

          
            
            
    
    
      
      
  
  
  
  
  
  
  

  
  
  
  
    
