/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Program #5    DEADLINE: December 9, 2016
 Program Description: Playing Cards
*/ 

import java.util.*;

/**
 * Represents standard deck of 52 cards */
public class Deck {
  
  /**
   * LinkedList of cards in deck */
  private MyLinkedList<Card> cards;
  
  /**
   * Creates deck with cards in order based on suit then rank */
  public Deck() {
    cards = new MyLinkedList<Card>();
    for(int i = 0; i < 4; i++){
      String x = "CDHS";
      char c = x.charAt(i);
      for(int j = 1; j < 14; j++){
        Card xyz = new Card(c,j);
        cards.add(xyz);
      }
    }
  }
  
  /**
   * Shuffles cards */
  public void shuffle(){
    MyLinkedList<Card> shuffledSub = new MyLinkedList<Card>();
    Random randomNum = new Random();
    for( int i = 0; i < 30; i++){
      int start = (randomNum.nextInt(51) + 1);
      int end = (randomNum.nextInt(51) + 1);
      if (start > end){
        while(start > end){
          end = (randomNum.nextInt(51) + 1);
        }
      }
      shuffledSub = cards.extractSublist(start, end);
      cards.prepend(shuffledSub);
    }
  }
  
  /**
   * Removes first card from deck and returns it */
  public Card Draw() {
    if(cards.size == 0)
      return null;
    else {
      return cards.removeFirst();
    }
  }
  
  /**
   * removes card c from hand and places it in deck then replaces
   * it with the top card from the deck */
  public void exchangeCard(Hand h, Card c){
    if(cards.size > 0){
      boolean location = h.contains(c);
      if(location){
        h.removeCard(c);
        cards.addLast(c);
        h.addCard(cards.removeFirst());
      }
      else {
      }
    }
  }
 
  /**
   * Deals the cards from the deck to the different hands */
  public Hand[] deal(int numHands, int handSize){
    Hand[] hands = new Hand[numHands];
    for(int i = 0; i < numHands; i++){
      hands[i] = new Hand();
    }
    
    for(int i = 0; i < handSize; i++){
      for(int j = 0; j < numHands; j++){
        if(cards.size == 0)
          return hands;
        else { 
          hands[j].addCard(cards.removeFirst());
        }
      }
    }
    return hands;
  }  
  
  /**
   * Return a string listing the contents of the deck in order */
  public String toString(){
    return cards.toString();
  }
  
  /**
   * Main method */
  public static void main(String[] args) {
    Deck myDeck = new Deck();
    System.out.println("Initial Deck:");
    System.out.println(myDeck.toString());
    myDeck.shuffle();
    System.out.println("Deck after shuffle:");
    System.out.println(myDeck.toString());
    System.out.println("Dealing...");
    Hand[] myHands = myDeck.deal(4,5);
    for (int i=0; i < myHands.length; i++)
      System.out.println("Hand " + i + ": " + myHands[i]);
    System.out.println("Deck after deal:");
    System.out.println(myDeck.toString());
    System.out.println("Hand 0 exchanging first card:");
    myDeck.exchangeCard(myHands[0], myHands[0].getCard(0));
    System.out.println("New Hand 0: " + myHands[0]);
    System.out.println("Deck after exchange:");
    System.out.println(myDeck.toString());  
  }
  
}
        