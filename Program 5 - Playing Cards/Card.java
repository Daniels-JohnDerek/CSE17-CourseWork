/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #5    DEADLINE: December 9, 2016
 Program Description: Playing Cards
*/ 

/**
 * Represents a playing card */
public class Card {
  
  /**
   * Suit of the card like diamonds 
   * and the rank of the card like King */
  private char suit;
  private int rank;
  
  /**
   * Creates a card with the given rank and suit*/
  public Card (char suit, int rank){
    String x = "CDHS";
    char c = x.charAt(0);
    char d = x.charAt(1);
    char h = x.charAt(2);
    char s = x.charAt(3);
    if( rank > 13 && rank < 1)
      throw new IllegalArgumentException("Not in range");
    if( suit == (c)||suit == (d)||suit == (h)||suit == (s)){
      this.suit = suit;
      this.rank = rank;
    }
    else {
      throw new IllegalArgumentException("Not in range");
    }
    
  }
  
  /**
   * Return for suit */
  public char getSuit(){
    return suit;
  }
  
  /**
   * Return for rank */
  public int getRank(){
    return rank;
  }
  
  /**
   * Return a description of the card based on 
   * suit and rank example: AD for Ace of diamonds */
  public String toString(){
    String returnString;
    String rankWord = null;
    if(rank < 2 || rank > 10){
      if(rank == 1)
        rankWord = "A";
      else if(rank == 11)
        rankWord = "J";
      else if(rank == 12)
        rankWord = "Q";
      else if(rank == 13)
        rankWord = "K";
      returnString = (rankWord + suit);
    }
    else {
      returnString = ("" + rank + suit);
    }
    
    return returnString;
  }
  
  /**
   * Checks if two cards have the same suit and rank */
  public boolean equals(Object o){
    char suit1 = this.getSuit();
    char suit2 = getSuit();
    if(suit1 != suit2)
      return false;
    else {
      int rank1 = this.getRank();
      int rank2 = getRank();
      if(rank1 == rank2)
        return true;
      else 
        return false;
    }
  }
}
  
  
  