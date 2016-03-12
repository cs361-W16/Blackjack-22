package models;

/**
 * Created by krisna on 3/12/2016.
 */
public class Player extends Hands
{
    public int numAces;

    @Override
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
            numAces = numAces + 1;
            return 11;
        }
    }

    @Override
    public  int getCount()
    {
        if (count > 21 && numAces > 0)
        {
            count = count - 10;
            numAces = numAces - 1;
            return count;
        }
        else
        {
            return count;
        }
    }

    @Override
    public Card deal(java.util.List<Card> deck)
    {
        Card card1 = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        count = count + trueValue(card1.getValue());
        return card1;
    }
}
