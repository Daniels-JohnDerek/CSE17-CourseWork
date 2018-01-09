/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #1     DEADLINE: September 22 2016
 Program: MP3 Player
*/ 

/**
 * Sets up song format which is then used in the Playlist method */
class Song {
  
  private String title;
  private String artist;
  private String album;
  private int year;
  private int length;
  
 /**
  * Song constructor */
  public Song (String t, String ar, String al, int y, int l){
    title = t;
    artist = ar;
    album = al;
    year = y;
    length = l;
  }
  
  /**
   * Get method for the title of the song */
  public String getTitle () {
    return title;
  }
  
  /**
   * Get method for the artist of the song */
  public String getArtist () {
    return artist;
  }
  
  /**
   * Get method for the album of the song */
  public String getAlbum () {
    return artist;
  }
  
  /**
   * Get method for the year the song came out*/
  public int getYear () {
    return year;
  }
  
  /**
   * Get method for the length of the song */
  public int getLength () {
    return length;
  }
  
  /**
   * Method that prints the song object in a specific way */
  public void printSongRow () {
    String timeString = secsToTimeString(length);
    System.out.printf("%-25s\t%-25s\t%-30s\t%d\t%s\n", title, artist, album, year, timeString);
  }
  
  /**
   * Method that takes the int for lenght and converts it to a string in a hour:minute:second format */
  public String secsToTimeString (int t) {
    int timeRaw = t;
    String timeFormatted;
    if (timeRaw < 3600){
      int minutes = (int)(timeRaw/60);
      int seconds = timeRaw % 60;
      timeFormatted = String.format("%d:%02d", minutes, seconds);
    }
    else {
     int hours = (int)(timeRaw/3600);
     int minutes = (timeRaw - 3600)/60;
     int seconds = (timeRaw - 3600)%60;
     timeFormatted = String.format("%d:%02d:%02d", hours, minutes, seconds);
  }
    return timeFormatted;
  }
  
}
