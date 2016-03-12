package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krisna on 3/11/2016.
 */
public class TestGame
{
    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }


    @Test
    public void testGameStart(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealInitial();
        assertEquals(2,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        System.out.print(g.getPlayerCount());
    }

    @Test
    public void testHitOne(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealInitial();
        System.out.print(g.getPlayerCount() + "\n");
        g.hitOne();
        assertEquals(1,g.cols.get(1).size());
        System.out.print(g.getPlayerCount());
    }

    @Test
    public void testDealerHit()
    {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealInitial();
        g.dealerHit();
        assertEquals(2,g.cols.get(0).size());
        assertEquals(2,g.cols.get(1).size());
    }

    @Test
    public void testDealer17(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealInitial();
        g.dealerHit();
        g.dealer17();
        System.out.print(g.getDealerCount());
    }
}

