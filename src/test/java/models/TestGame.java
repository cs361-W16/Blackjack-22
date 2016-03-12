package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by krisna on 3/11/2016.
 */
public class TestGame
{
    @Test
    public void testGameCreation(){
        Game g = new Player();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Player();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }

    @Test
    public void testCustomDeal(){
        Game g = new Player();
        g.buildDeck();
        g.customDeal(0,3);
        assertEquals("2Clubs",g.hands.get(0).get(0).toString());
        assertEquals("3Clubs",g.hands.get(1).get(0).toString());
    }
    @Test
    //winLose() and stay() tests
    public void testWin(){
        Game g = new Player();
        g.buildDeck();
        g.handValue = 21;
        g.winLose();
        assertEquals(1,g.win);
        g.stay();
        assertEquals(2,g.turn);
    }
    @Test
    //winLose() and stay() tests
    public void testDealerWin(){
        Game g = new Dealer();
        g.buildDeck();
        g.handValue = 21;
        g.winLose();
        g.stay();
        assertEquals(1,g.turn);
    }




}
