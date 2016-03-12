package models;

import java.util.ArrayList;

/**
 * Created by krisna on 3/12/2016.
 */
public abstract class Hands
{
    public int count;
    private java.util.List<Card> Hand;

    public Hands()
    {
        this.Hand = new ArrayList<>();
        this.count = 0;
    }

    public abstract int trueValue(int value);

    public abstract int getCount();

    public abstract Card deal(java.util.List<Card> deck);

}
