package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by krisna on 3/11/2016.
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();
    public Player player;
    public Dealer dealer;

    public int playerCount;
    public int dealerCount;



    public Game()
    {
        this.player = new Player();
        this.dealer = new Dealer();
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
        Card card1 = player.deal(deck);
        cols.get(0).add(card1);
        playerCount = player.getCount();

        Card card2 = player.deal(deck);
        cols.get(0).add(card2);
        playerCount = player.getCount();

        Card card3 = dealer.deal(deck);
        cols.get(1).add(card3);
        dealerCount = dealer.getCount();
    }

    public void hitOne()
    {
        if (playerCount < 21)
        {
            Card card1 = player.deal(deck);
            cols.get(0).add(card1);
            playerCount = player.getCount();
        }
        else
        {
            //To do: Loose the Game
        }

    }

    public void dealerHit()
    {
        Card card3 = dealer.deal(deck);
        cols.get(1).add(card3);
        dealerCount = dealer.getCount();
    }

    public void dealer17()
    {
        while (dealerCount < 17)
        {
            Card card3 = dealer.deal(deck);
            cols.get(1).add(card3);
            dealerCount = dealer.getCount();
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
