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
    private char cCurBlock;     //Current block Miner is on

    Searcher (Grid g, Miner m) {
        grid = g;
        miner = m;
        n = grid.getN ();
        smartMoveSet = new ArrayList<Integer> ();
        randomMoveSet = new ArrayList<Integer> ();
        nSmartCount = 0;
        nRandCount = 0;
        cCurBlock = '\0';
    }

    //The main searching alg will be here
    public void Search () {
        int i;  //just for any loop used here
        int nDirection = miner.getRotation ();
        /*  This where it keeps tabs on scan result in what direction. [0] right, [1] top ...
            'L' just means Miner is on the edge of that direction already, otherwise it puts the letter */
        char[] scannedDirection = new char[4];

        scanAllDirection (scannedDirection);



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
            nPick = (int)(Math.random () * 4);
            bValidMove = isValidDir (directions[nPick]);    //Checks if chosen direction is valid before proceeding
        } while (!bValidMove);

        nDirection = directions[nPick];

        while (nDirection != miner.getRotation())   //While miner isnt facing the direction
            miner.rotate ();
        
        vacateCurrentBlock ();  //Return block's original value before moving

        miner.forward ();
        cCurBlock = miner.scanCurrent(grid.getGrid ()); //Gets value of current block to be used in vacateCurrentBlock ()

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

    public Grid getGrid () {
        return grid;
    }

    public Miner getMiner () {
        return miner;
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
            if (miner.getY () == 0) return false;
            else return true;
        else if (dir == 180)    //Left
            if (miner.getX () == 0) return false;
            else return true;
        else if (dir == 270)    //Down
            if (miner.getY () == n - 1) return false;
            else return true;
        
        return false;   //return false if for sum reason direction is invalid
    }

    //Scans in all directions and keeps what was scanned, per direction, in an array
    private void scanAllDirection (char[] scanned) {
        int i, nCurDir;

        for (i = 0; i < 4; i++) {
            nCurDir = miner.getRotation ();
            if (isValidDir (nCurDir))   //If miner isnt on the edge of direction to be scanned
                scanned[nCurDir / 90] = miner.scan (grid.getGrid ());
            else
                scanned[nCurDir / 90] = 'L';
            
            miner.rotate ();
        }
    }

    //Return block to its original state
    private void vacateCurrentBlock () {
        grid.getGrid () [miner.getY()][miner.getX()] = cCurBlock;
    }



}
