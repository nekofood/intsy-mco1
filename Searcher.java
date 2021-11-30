import java.util.*;

public class Searcher {
    private Grid grid;
    private Miner miner;
    private ArrayList<Integer> smartMoveSet; /* where the smart moves will be stored
                                                direction of move will be stored*/
    private ArrayList<Integer> randomMoveSet;   //this one for the randies
    private int nSmartCount;    //Move counter for smart search
    private int nRandCount;     //Move counter for rand search   ||   idk y i separated them tbh
    private int n;

    Searcher (Grid g, Miner m) {
        grid = g;
        miner = m;
        n = grid.getN ();
        smartMoveSet = new ArrayList<Integer> ();
        randomMoveSet = new ArrayList<Integer> ();
        nSmartCount = 0;
        nRandCount = 0;
    }

    //The main searching alg will be here
    public void Search () {
        int nDirection = miner.getRotation ();



        miner.forward ();
        grid.updateMinerPosition (miner.getX (), miner.getY ());
        addMove (smartMoveSet, nDirection);
        nSmartCount++;
    }

	//The "random action" alg goes here
	public void randomSearch() {
        int[] directions = {0, 90, 180, 270};
        int nPick, nDirection;
        boolean bValidMove = false;     

        do {
            nPick = (int)(Math.random () * 4) - 1;
            bValidMove = isValidDir (directions[nPick]);    //Checks if chosen direction is valid before proceeding
        } while (!bValidMove);

        nDirection = directions[nPick];

        while (nDirection != miner.getRotation())   //While miner isnt facing the direction
            miner.rotate ();
        
        miner.forward ();
        grid.updateMinerPosition (miner.getX (), miner.getY ());
        addMove (randomMoveSet, nDirection);
        nRandCount++;
	}

    public int getSmartCount () {
        return nSmartCount;
    }

    public int getRandCount () {
        return nRandCount;
    }

    //This adds the move done to the list
    private void addMove (ArrayList<Integer> moveSet, int nDirection) {
        moveSet.add (nDirection);
    }

    //Insted of the binding thingy, checks if direction to move at is valid
    private boolean isValidDir (int dir) {
        if (dir == 0)           //Right
            if (miner.getX () == n - 1) return false;
            else return true;
        else if (dir == 90)     //Up
            if (miner.getY () == n - 1) return false;
            else return true;
        else if (dir == 180)    //Left
            if (miner.getX () == 0) return false;
            else return true;
        else if (dir == 270)    //Down
            if (miner.getY () == 0) return false;
            else return true;
        
        return false;   //return false if for sum reason direction is invalid
    }
}
