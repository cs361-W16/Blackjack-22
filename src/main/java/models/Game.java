package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by krisna on 3/11/2016.
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public java.util.List<java.util.List<Card>> second_hand = new ArrayList<>();

    public int playerCount;
    public int dealerCount;
    public int second_handCount;
    public int sec_hand;
    public int sec_hand_lose;


    public Game()
    {
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        second_hand.add(new ArrayList<Card>());
        second_handCount = 0;
        sec_hand = 0;
    }

    public void buildDeck()
    {
        for(int i = 1; i < 14; i++)
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

    public void dealInitial()
    {
        Card card1 = deck.get(deck.size()-1);
        cols.get(0).add(card1);
        deck.remove(deck.size()-1);
        playerCount = playerCount + trueValue(card1.getValue());

        Card card2 = deck.get(deck.size()-1);
        cols.get(0).add(card2);
        deck.remove(deck.size()-1);
        playerCount = playerCount + trueValue(card2.getValue());

        Card card3 = deck.get(deck.size()-1);
        cols.get(1).add(card3);
        deck.remove(deck.size()-1);
        dealerCount = dealerCount + trueValue(card3.getValue());
    }

    public void hitOne()
    {
        if (second_handCount < 21 && sec_hand == 1  && sec_hand_lose == 1){                   // if second hand is using
            Card card1 = deck.get(deck.size() - 1);
            cols.get(0).add(card1);
            deck.remove(deck.size() - 1);
            second_handCount = second_handCount + trueValue(card1.getValue());
        }
        else{
            sec_hand_lose = 0;                                    // loose this hand
        }
        if (playerCount < 21)
        {
            Card card1 = deck.get(deck.size() - 1);
            cols.get(0).add(card1);
            deck.remove(deck.size() - 1);
            playerCount = playerCount + trueValue(card1.getValue());
        }
        else
        {
            //To do: Loose the Game
        }

    }

    public void dealerHit()
    {
        Card card3 = deck.get(deck.size()-1);
        cols.get(1).add(card3);
        deck.remove(deck.size()-1);
        dealerCount = dealerCount + trueValue(card3.getValue());
    }

    public void dealer17()
    {
        while (dealerCount < 17)
        {
            Card card3 = deck.get(deck.size()-1);
            cols.get(1).add(card3);
            deck.remove(deck.size()-1);
            dealerCount = dealerCount + trueValue(card3.getValue());
        }
    }
    public int trueValue(int value)
    {
        if (value >= 2 && value <= 10)
        {
            return value;
        }
        else if (value >= 11 && value <= 13)
        {
            return 10;
        }
        else
        {
            return 11;
            //To do: Enable Aces Value Button, change the value of the Aces
        }
    }

    public void split(){
        if (second_hand.get(0).size() == 0) {                                                    // if second hand is empty
            if (this.cols.get(0).size() == 2) {                                 // if the first hand has and only has 2 cards
                if (this.cols.get(0).get(0) == this.cols.get(0).get(1)){   // if the 2 cards in the first card have same value
                    Card card = cols.get(0).get(1);                         //move 1 of them to second hand
                    second_hand.get(0).add(card);
                    second_handCount = second_handCount + trueValue(card.getValue());
                    cols.get(0).remove(1);
                    sec_hand = 1;                                             // second hand starts to play
                    sec_hand_lose = 1;                   // not lose yet
                }
            }
        }
    }

    public int getDealerCount()
    {
        return dealerCount;
    }


    public int getPlayerCount()
    {
        return playerCount;
    }

    public int getsecond_handCount()
    {
        return second_handCount;
    }
}
