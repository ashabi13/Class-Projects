import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class blackJack {
  public static void main (String[] args) {
    House dealer = new House();
    Player aPlayer = new Player();
    
    dealer.startGame(aPlayer);
  }
}

class House {
  private Card[] hCards = new Card[2];
  boolean hitMe = true;
  
  House() { // initialize house's cards
    for (int k = 0; k < hCards.length; k++) {
      hCards[k] = new Card();
      hCards[k].value = (int) ((12 * Math.random()) + 1);
      hCards[k].suit = (int) ((3 * Math.random()) + 1);
    }
  }
  
  void startGame(Player p) {
    Scanner input = new Scanner(System.in);
    // initialize player's cards
    for (int k = 0; k < p.cLength; k++) {
      p.c.get(k).setValue((int) ((12 * Math.random()) + 1));
      p.c.get(k).setSuit((int) ((3 * Math.random()) + 1));
    }

    while (hitMe) {
      hitMe = false;
      // show dealer's first card
      System.out.println("The house has:");
      printCard(hCards[0]);
      System.out.println("");

      // show player's cards
      System.out.println("Your cards are:");
      for (int k = 0; k < p.cLength; k++) {
        printCard(p.c.get(k));
      }
      System.out.print("\nHit me? (y/n): ");

      // hit the player if he wants
      String userHitMe = input.next();
      hitMe = (userHitMe.equals("y") ? true : false);
      if (hitMe)
        p.hitMe();
    }

    // reveal all cards

    // show dealer's first card
    System.out.println("\n\nThe house has:");
    for (int k = 0; k < hCards.length; k++) {
      printCard(hCards[k]);
    }

    // show player's cards
    System.out.println("\n\nYour cards are:");
    for (int k = 0; k < p.cLength; k++) {
      printCard(p.c.get(k));
    }

    // determine winner
    System.out.println("\n\n" + getWinner(hCards, p.c) + "\n\n");
  }
  
  public void printCard(Card card){
    String value = "";
    String suit = "";
    switch (card.getValue()){
      case 1:
        value = "A";
        break;
      case 11:
        value = "J";
        break;
      case 12:
        value = "Q";
        break;
      case 13:
        value = "K";
        break;
      default:
        value = Integer.toString(card.getValue());
    }
    System.out.println(" ----------- ");
    System.out.println("/           \\");
    System.out.println("|"+value+"          |");
    switch(card.getSuit()){
      case 1:
        System.out.println("|     _     |");
        System.out.println("|    (_)    |");
        System.out.println("|   (_)_)   |");
        System.out.println("|    /_\\    |");
        System.out.println("|           |");
        break;
      case 2:
        System.out.println("|           |");
        System.out.println("|    /\\     |");
        System.out.println("|   <  >    |");
        System.out.println("|    \\/     |");
        System.out.println("|           |");
        break;
      case 3:
        System.out.println("|    _ _    |");
        System.out.println("|   / ^ \\   |");
        System.out.println("|   \\   /   |");
        System.out.println("|    \\ /    |");
        System.out.println("|     '     |");
        break;
      case 4:
        System.out.println("|     ,     |");
        System.out.println("|    / \\    |");
        System.out.println("|   (_ _)   |");
        System.out.println("|    /_\\    |");
        System.out.println("|           |");
        break;
    }
    System.out.println("|          "+value+"|");
    System.out.println("\\___________/");

  }
  
  

  String getWinner(Card[] house, ArrayList<Card> player) {
    int hTotal = 0;
    int pTotal = 0;
    int hasAce = 0;

    // calculate house's total
    for (int k = 0; k < house.length; k++) {
      hTotal += getTrueValue(house[k].value);
      hasAce += (house[k].value == 1) ? 1 : 0;
    }
    while ((hTotal <= 21) && (hasAce > 0)) {
      int newTotal = hTotal + 10;
      hasAce--;
      if (newTotal <= 21) 
        hTotal = newTotal;
    }
    
    // calculate player's total
    for (int k = 0; k < player.size(); k++) {
      pTotal += getTrueValue(player.get(k).getValue());
      hasAce += (player.get(k).getValue() == 1) ? 1 : 0;
    }
    while ((pTotal <= 21) && (hasAce > 0)) {
      int newTotal = pTotal + 10;
      hasAce--;
      if (newTotal <= 21) 
        pTotal = newTotal;
    }
    
    if ((pTotal >= hTotal) && (pTotal <= 21))
      return "House: " + hTotal + "\nPlayer: " + pTotal + "\nYou win!\n";
    return "House: " + hTotal + "\nPlayer: " + pTotal + "\nHouse wins :(\n";
  }
  
  int getTrueValue(int cVal) {
    int newVal = 0;
    switch (cVal) {
      case 11: newVal = 10; break;
      case 12: newVal = 10; break;
      case 13: newVal = 10; break;
      default: newVal = cVal; break;
    }
    return newVal;
  }
}

class Card {
  protected int value = 0;
  protected int suit = 0; // C=1,D=2,H=3,S=4
  
  Card() {
    value = 0;
    suit = 0;
  }

  void setValue(int newVal) {
    value = newVal;
  }

  void setSuit(int newSuit) {
    suit = newSuit;
  }

  int getValue() {
    return value;
  }

  int getSuit() {
    return suit;
  }
}

class Player {
  int cLength = 2;
  ArrayList<Card> c = new ArrayList<>();
  
  Player() { 
    for (int k = 0; k < cLength; k++) {
      c.add(new Card());
    }
  }
  
  void hitMe() {
    c.add(new Card());
    c.get(cLength).setValue((int) ((12 * Math.random()) + 1));
    c.get(cLength).setSuit((int) ((3 * Math.random()) + 1));
    cLength++;
    for (int k = 0; k < 40; k++)
      System.out.println("");
  }
}
