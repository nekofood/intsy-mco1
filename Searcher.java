import java.util.*;

public class Searcher {
    private Grid grid;
    private Miner miner;
    private ArrayList<Integer> smartMoveSet; /*  where the moves will be stored
                                            direction of move will be stored*/
    private ArrayList<Integer> randomMoveSet;
    private int nSmartCount;
    private int nRandCount;

    Searcher (Grid g, Miner m) {
        grid = g;
        miner = m;
        smartMoveSet = new ArrayList<Integer> ();
        randomMoveSet = new ArrayList<Integer> ();
        nSmartCount = 0;
        nRandCount = 0;
    }

    //The main searching alg will be here
    public void Search () {
        int nDirection = miner.getRotation ();



        miner.forward ();
        addMove (smartMoveSet, nDirection);
        nSmartCount++;
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
        addMove (randomMoveSet, nDirection);
        nRandCount++;
	}

    //This adds the move done to the list
    private void addMove (ArrayList<Integer> moveSet, int nDirection) {
        moveSet.add (nDirection);
    }
}
