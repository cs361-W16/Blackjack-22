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
        g.sec_hand=1;
        g.sec_hand_lose=1;
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
    @Test
    public void testSplit(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealInitial();
        g.cols.get(0).remove(1);
        Card card = g.cols.get(0).get(0);
        g.cols.get(0).add(card);
        g.split();
        System.out.print(g.cols.get(0).size());
        System.out.print(g.cols.get(2).size());
        System.out.print(g.getsecond_handCount());
        assertEquals(g.cols.get(0).get(0),g.cols.get(2).get(0));
    }

    @Test
    public void testWin() {
        Game g = new Game();
        g.playerCount = 21;
        g.winLose();
        assertEquals(1, g.winner);

        g.playerCount = 22;
        g.winLose();
        assertEquals(2, g.winner);
    }
    @Test
    public void testWin2(){
    Game g = new Game();
        g.stayed = 1;
        g.dealerCount = 22;
        g.winLose();
        assertEquals(1,g.winner);

        g.dealerCount = 20;
        g.playerCount = 20;
        System.out.println(g.dealerCount);
        System.out.println(g.playerCount);
        g.winLose();
        assertEquals(1,g.winner);

        g.playerCount = 19;
        g.winLose();
        assertEquals(2,g.winner);

        g.dealerCount = 18;
        g.winLose();
        assertEquals(2,g.winner);
        g.stayed = 0;

        g.playerCount = 22;
        g.winLose();
        assertEquals(2,g.winner);
        g.playerCount = 0;

        g.dealerCount = 22;
        g.winLose();
        assertEquals(1,g.winner);

        g.winLose();
        assertEquals(1,g.winner);

        g.playerCount = 20;
        g.dealerCount = 20;
        g.winLose();
        assertEquals(1,g.winner);

        g.playerCount = 19;
        g.winLose();
        assertEquals(2,g.winner);
    }
}

