package models;

/**
 * Created by krisna on 3/11/2016.
 */
public class Player extends Game {
    @Override
    public void deal(int index) {
        hands.get(index).add(deck.get(deck.size() - 1));
        deck.remove(deck.size() - 1);
    }

    @Override
    public void winLose() {
        if (this.handValue == 21) {
            win = 1;
        }
    }

    @Override
    public void stay(){
        turn = 2;
    }
}