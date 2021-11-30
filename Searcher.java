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

	//The "random action" alg goes here
	public void randomSearch() {
        int[] directions = {0, 90, 180, 270};
        int nPick, nDirection;

        nPick = (int)(Math.random () * 4) - 1;
        nDirection = directions[nPick];

        while (nDirection != miner.getRotation())
            miner.rotate ();
        
        miner.forward ();
	}

    //This adds the move done to the list
    private void addMove (int nDirection) {
        moveSet.add (nDirection);
    }
}
