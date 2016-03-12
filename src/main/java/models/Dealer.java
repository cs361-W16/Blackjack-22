package models;

/**
 * Created by krisna on 3/12/2016.
 */
public class Dealer extends Hands
{

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
            return 11;
        }
    }

    @Override
    public  int getCount()
    {
        return count;
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

