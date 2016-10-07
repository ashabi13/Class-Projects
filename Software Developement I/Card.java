import java.lang.*;
import java.io.*;
import java.util.*;



class Card{
    protected int value = 0;//1=A or and 2-10 are themselves, 11-13 are face cards
    protected int suit = 0;//1=Clubs, 2=Diamonds, 3=Spades, 4=Hearts

    Card(){
        value = 0;
        suit = 0;
    }

    void setValue(int newVal){
        value = newVal;
    }

    void setSuit(int newSuit){
        suit = newSuit;
    }

    int getValue(){
        return value;
    }

    int getSuit(){
        return suit;
    }
}

class Player{
    int cLength = 2;
    ArrayList<Card> c = new ArrayList<>();

    Player(){
        for (int k = 0; k<cLength; k++) {
            c.add(new Card());
        }
    }
    
    void hitMe(){
        c.add(new Card());
        c.get(cLength).setValue((int)((12 * Math.random())+1));
        c.get(cLength).setValue((int)((3 * Math.random())+1));
        cLength++;
        for (int k = 0; k < 40;k++){
            System.out.println("");
        }
    }

}