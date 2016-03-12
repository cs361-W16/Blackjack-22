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

    public int playerCount;
    public int dealerCount;


    public Game()
    {
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
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

    public int getDealerCount()
    {
        return dealerCount;
    }


    public int getPlayerCount()
    {
        return playerCount;
    }
}
