package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by krisna on 3/11/2016.
 */
public class TestCard {
    public class testCard {
        @Test
        public void testGetSuit() {
            Card c = new Card(5, Suit.Clubs);
            assertEquals(Suit.Clubs, c.getSuit());
        }

        @Test
        public void testToString() {
            Card c = new Card(5, Suit.Clubs);
            assertEquals("5Clubs", c.toString());
        }
    }
}
