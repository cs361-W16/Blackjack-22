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
    public secHand secHand;
    public int winner;
    public int stayed;


    public int playerCount;
    public int dealerCount;
    public int second_handCount;
    public int sec_hand;
    public int sec_hand_lose;


    public Game() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.secHand = new secHand();
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        second_handCount = 0;
        sec_hand = 0;
    }

    public void buildDeck() {
        for (int i = 1; i < 14; i++) {
            deck.add(new Card(i, Suit.Clubs));
            deck.add(new Card(i, Suit.Hearts));
            deck.add(new Card(i, Suit.Diamonds));
            deck.add(new Card(i, Suit.Spades));

        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealInitial() {
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

    public void hitOne() {
        if (second_handCount < 21 && sec_hand == 1 && sec_hand_lose == 1) {                   // if second hand is using
            Card card1 = secHand.deal(deck);
            cols.get(2).add(card1);
            second_handCount = secHand.getCount();
        } else {
            sec_hand_lose = 0;                                    // loose this hand
        }
        if (playerCount < 21) {
            Card card1 = player.deal(deck);
            cols.get(0).add(card1);
            playerCount = player.getCount();
        } else {
            //To do: Loose the Game
        }

    }

    public void split() {
        if (cols.get(2).size() == 0) {                                                    // if second hand is empty
            if (this.cols.get(0).size() == 2) {                                 // if the first hand has and only has 2 cards
                if (this.cols.get(0).get(0).getValue() == this.cols.get(0).get(1).getValue()) {   // if the 2 cards in the first card have same value
                    Card card = cols.get(0).get(1);                         //move 1 of them to second hand
                    cols.get(2).add(card);
                    secHand.count = secHand.count + secHand.trueValue(card.getValue());
                    second_handCount = secHand.getCount();
                    cols.get(0).remove(1);
                    sec_hand = 1;                                             // second hand starts to play
                    sec_hand_lose = 1;                   // not lose yet
                }
            }
        }
    }

    public void dealerHit() {
        Card card3 = dealer.deal(deck);
        cols.get(1).add(card3);
        dealerCount = dealer.getCount();
    }

    public void dealer17() {
        while (dealerCount < 17) {
            Card card3 = dealer.deal(deck);
            cols.get(1).add(card3);
            dealerCount = dealer.getCount();
        }
    }

    public int getDealerCount() {
        return dealerCount;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getsecond_handCount() {
        return second_handCount;
    }

    public void winLose() {

        if (stayed == 1) {
            if ((dealerCount > 21)) {
                winner = 1;
                return;
            }
            if (playerCount == dealerCount) {
                winner = 1;
                return;
            }
            if ((playerCount < dealerCount)) {
                winner = 2;
                return;
            } else {
                winner = 2;
                return;
            }
        } else {
            if ((playerCount > 21)) {
                winner = 2;
                return;
            }
            if ((dealerCount > 21)) {
                winner = 1;
                return;
            }
            if (playerCount == dealerCount) {
                winner = 1;
                return;
            } else if (playerCount < dealerCount) {
                winner = 2;
                return;
            }


        }

    }
}




