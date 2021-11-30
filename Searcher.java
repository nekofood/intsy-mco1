import java.util.*;

public class Searcher {
    private Grid grid;
    private Miner miner;
    private ArrayList<Integer> moveSet; /*  where the moves will be stored
                                            direction of move will be stored*/
    private int nMoveCount;

    Searcher (Grid g, Miner m) {
        grid = g;
        miner = m;
        moveSet = new ArrayList<Integer> ();
        nMoveCount = 0;
    }

    //The main searching alg will be here
    public void Search () {

    }

    //This adds the move done to the list
    private void addMove (int nDirection) {
        moveSet.add (nDirection);
    }
}
