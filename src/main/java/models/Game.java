package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by krisna on 3/11/2016.
 */
public abstract class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> hands = new ArrayList<>();
    public int cn;

    public boolean checker;
    public int win;
    public int handValue;
    public int turn;

    public Game()
    {
        cn=0;
        hands.add(new ArrayList<Card>());
        hands.add(new ArrayList<Card>());
        checker=false;
    }

    public void buildDeck()
    {
        for(int i = 2; i < 15; i++)
        {
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));

        }
    }


    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public abstract void deal(int index);
//    public abstract void split();
//    public abstract void acesValue();
//    public abstract void stay();
//    public abstract void handValue();

    public void customDeal(int c1, int c2) {
        hands.get(0).add(deck.get(c1));
        deck.remove(c1);
        hands.get(1).add(deck.get(c2));
        deck.remove(c2);
    }

    private boolean colHasCards(int colNumber) {
        if(this.hands.get(colNumber).size()>0){
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.hands.get(columnNumber).get(this.hands.get(columnNumber).size()-1);
    }


    public void move(int colFrom, int colTo) {
        Card cardToMove = getTopCard(colFrom);
        this.removeCardFromCol(colFrom);
        this.addCardToCol(colTo, cardToMove);
    }

    private void addCardToCol(int colTo, Card cardToMove) {
        hands.get(colTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.hands.get(colFrom).remove(this.hands.get(colFrom).size()-1);


    }

    public abstract void winLose();
    public abstract void stay();

    }



