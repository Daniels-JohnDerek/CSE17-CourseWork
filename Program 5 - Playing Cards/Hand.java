/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #5    DEADLINE: December 9, 2016
 Program Description: Playing Cards
*/ 

/**
 * Represent the set of cards help by the player */
public class Hand{
  
  /**
   * LinkedList of card help by player */
  private MyLinkedList<Card> cards;
  
  /**
   * creates an empty hand */
  public Hand() {
    cards = new MyLinkedList<Card>();
  }
  
  /**
   * Add card c to the hand */
  public void addCard(Card c){
    cards.add(c);
  }
  
  /**
   * Remove card c from hand
   * Does nothing if card is not in hand */
  public void removeCard(Card c){
    int placeMarker = cards.indexOf(c);
    if(cards.size == 0){
    }
    else if (placeMarker < 0){
    }
    else {
      cards.remove(placeMarker);
    }
  }
 
  /**
   * Returns card at specified index */
  public Card getCard(int index){
    return cards.get(index);
  }
  
  /**
   * Returns true if card is in hand */
  public boolean contains(Card c){
    return cards.contains(c);
  }
  
  /**
   * Returns number of cards in hand */
  public int size(){
    return cards.size;
  }
  
  /**
   * Returns description of cards in hand */
  public String toString(){
    String allCards = null;
    for(int i = 0; i < cards.size; i++){
      allCards += cards.get(i).toString();
    }
    return allCards;
  }
  
  
}
      

  
  
  
  
  