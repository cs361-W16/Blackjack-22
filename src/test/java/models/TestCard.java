package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by krisna on 3/11/2016.
 */
public class TestCard {
        @Test
        public void testGetSuit() {
            Card c = new Card(7, Suit.Clubs);
            assertEquals(Suit.Clubs, c.getSuit());
        }

        @Test
        public void testGetValue(){
            Card c = new Card(7,Suit.Clubs);
            assertEquals(7,c.getValue());
        }
        @Test
        public void testToString() {
            Card c = new Card(8, Suit.Clubs);
            assertEquals("8Clubs", c.toString());
        }
}
