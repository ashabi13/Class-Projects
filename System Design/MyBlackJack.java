import java.lang.*;
import java.io.*;
//We need fifty-two cards
//Random "card" genorator
//Dealer (house)
//player (you)
//win/loose
//printer

public class MyBlackJack{
    public static void main(String[] args){
        theHouse dealer = new theHouse();
        Player aPlayer = new Player();
        dealer.startGame(aPlayer);
        aPlayer.printMyCards();
        //dealer.printCard();


    }
}

class theHouse{
    Card card = new Card();
    theHouse(){
        card.value = (int)(12*Math.random()+1);
        card.suit = (int)(3*Math.random()+1);
    }
    void startGame(Player p){
        for(int i = 0; i<p.cLength; i++){
            p.hand[i].value = (int)(12*Math.random()+1);
            p.hand[i].suit = (int)(3*Math.random()+1);
        }
    }
    /*void printCard(){
        switch (card.value){
            case 1: System.out.printf("A"); break;
            case 11: System.out.printf("J"); break;
            case 12: System.out.printf("Q"); break;
            case 13: System.out.printf("K"); break;
            default: System.out.printf("%d", card.value); break;
        }
        switch (card.suit){
            case 1: System.out.printf("C \n"); break;
            case 2: System.out.printf("D \n"); break;
            case 3: System.out.printf("S \n"); break;
            case 4: System.out.printf("H \n"); break;
        }
    }*/

}

class Player{
    int cLength = 2;
    Card[] hand = new Card[cLength];

    void hit(Card newCard){
        Card[] temp = new Card[cLength+1];
        for(int i=0; i<cLength; i++)
            temp[i]=hand[i];
        temp[cLength] = newCard;
        cLength++;
        hand = temp;
        for (int k = 0; k < cLength;k++){
            System.out.println(hand[k].value + " ");
        }
    }
    Card[] stay(){
        return hand;
    }
    void printMyCards(){
        for(int i = 0; i< cLength; i++)
            hand[i].printCard();
    }

}

class Card{
    int value = 0;//1=A or and 2-10 are themselves, 11-13 are face cards
    int suit = 0;//1=Clubs, 2=Diamonds, 3=Spades, 4=Hearts

    Card(){

    }

    void printCard(){
        switch (this.value){
            case 1: System.out.printf("A"); break;
            case 11: System.out.printf("J"); break;
            case 12: System.out.printf("Q"); break;
            case 13: System.out.printf("K"); break;
            default: System.out.printf("%d", this.value); break;
        }
        switch (this.suit){
            case 1: System.out.printf("C \n"); break;
            case 2: System.out.printf("D \n"); break;
            case 3: System.out.printf("S \n"); break;
            case 4: System.out.printf("H \n"); break;
        }
    }
}