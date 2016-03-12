package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by krisna on 3/11/2016.
 */
public abstract class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();
    public int cn;

    public boolean checker;

    public Game()
    {
        cn=0;
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        checker=false;
    }

    public abstract void buildDeck();

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public abstract void deal();
    public abstract void split();
    public abstract void acesValue();
    public abstract void stay();
    public abstract void handValue();

    private boolean colHasCards(int colNumber) {
        if(this.cols.get(colNumber).size()>0){
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int colFrom, int colTo) {
        Card cardToMove = getTopCard(colFrom);
        this.removeCardFromCol(colFrom);
        this.addCardToCol(colTo, cardToMove);
    }

    private void addCardToCol(int colTo, Card cardToMove) {
        cols.get(colTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);


    }


}
