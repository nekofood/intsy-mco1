import java.util.*;

public class Searcher {
    private Grid grid;
    private Miner miner;
    private ArrayList<Integer> moves; // where the direction of moves will be store
    private int nMoveCount;
    private int nBackMoveInd;
    private int n;
    private char cCurBlock;     //Current block Miner is on
    private boolean bSmart;      //Current agent. || T = Smart, F = Mentally inferior
    private boolean bFoundGoldDir;
    private boolean bIsBacktracking;

    Searcher (Grid g, Miner m) {
        grid = g;
        miner = m;
        n = grid.getN ();
        moves = new ArrayList<Integer> ();
        nMoveCount = 0;
        nBackMoveInd = -1;
        cCurBlock = '\0';
        bSmart = false;
        bFoundGoldDir = false;
        bIsBacktracking = false;
    }

    //A func to check if it won or lost alrdy
    public int checkWinCon () {
        if (cCurBlock == 'G') return 1;         //Gold - Win 
        else if (cCurBlock == 'P') return -1;   //Pit  - Lose
        else return 0;      //Nothing
    }

    //Func to switch agents. its now an on and off switch (alternating)
    public void switchAgent () {
        bSmart = !bSmart;
    }

    //Picks which search depending on current brain level
    public void Search () {
        if (bSmart) smartSearch ();
        else randomSearch ();
    }

    public int getMoveCount () {
        return nMoveCount;
    }

    public Grid getGrid () {
        return grid;
    }

    public Miner getMiner () {
        return miner;
    }

    public char getCurrentBlock () {
        return cCurBlock;
    }

    //The main searching alg will be here
    private void smartSearch () {
        int i;  //just for any loop used here
        int nNewDirection;
        /*  This where it keeps tabs on scan result in what direction. [0] right, [1] top ...
            'L' just means Miner is on the edge of that direction already, otherwise it puts the letter */
        char[] scannedDirection = new char[4];

        //if it found gold, it would stop scanning and just go on straight line
        if (!bFoundGoldDir) {
            scanAllDirection (scannedDirection);
            nNewDirection = pickDirection (scannedDirection);
            nNewDirection *= 90;

            while (miner.getRotation() != nNewDirection)
                miner.rotate ();
        }

        moveMiner ();
    }

    //The "random action" alg goes here
	private void randomSearch () {
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
        
        moveMiner ();
	}

    //Code for moving the miner
    private void moveMiner () {
        vacateCurrentBlock ();  //Return block's original value before moving
        miner.forward ();
        cCurBlock = miner.scanCurrent(grid.getGrid ()); //Gets value of current block || to be used in vacateCurrentBlock ()

        grid.updateMinerPosition (miner.getX (), miner.getY ());

        moves.add (miner.getRotation ());
        
        nMoveCount++;
    }

    //Evaluates which direction would be dopest
    private int pickDirection (char[] scanned) {
        int i;
        int[] wantValues = new int[4];
        int nCurDirInd = miner.getRotation () / 90;
        int nNewDir;

        //It assigns a value to scan result in each direction || [0] Right, [1] Down, ...
        //Value scales with block favorability
        for (i = 0; i < scanned.length; i++) {
            if (scanned[i] == 'P')
                wantValues[i] = -1;
            else if (scanned[i] == 'B')
                wantValues[i] = 1;
            else if (scanned[i] == 'G') {
                wantValues[i] = 2;
                bFoundGoldDir = true;
                return i;      //RETURN INSTA WHEN FOUND GOLD LETS GOOOOOOOOOOO
            }
            else if (scanned[i] == '\0')
                wantValues[i] = 0;
            else    //Edge of grid
                wantValues[i] = -2;
        }
        if (bIsBacktracking) {
            if (wantValues[(nCurDirInd + 1) % 4] >= 0)
                wantValues[(nCurDirInd + 1) % 4] = 10;
            
            if (wantValues[(nCurDirInd + 3) % 4] >= 0)
                wantValues[(nCurDirInd + 3) % 4] = 10;
        }

        nNewDir = getMaxValIndex (wantValues);

        if (wantValues[nNewDir] == 0)   //If nothing dope is near
            if (wantValues[nCurDirInd] == 0)    //And current direction has nothing bad
                nNewDir = nCurDirInd;           //Keep going same direction, else it returns the new direction
        else if (wantValues[nNewDir] == -1)     //If pit on every direction, we let rng do the work
            do
                nNewDir = (int)(Math.random () * 4);    //Pick a random direction
            while (!(isValidDir (nNewDir * 90)));   //Makes sure random direction is valid

        if (nMoveCount > 0)
            bIsBacktracking = checkIfBacking (nNewDir * 90);
        
        return nNewDir;
    }

    //Gets the index of the max value in an integer array
    private int getMaxValIndex (int[] vals) {
        int i;
        int nCurInd = 1;
        int nCurMaxInd = 0;
        for (i = 1; i <= vals.length; i++, nCurInd++) {
            nCurInd %= 4;
            if (vals[nCurInd] >= vals[nCurMaxInd])
                nCurMaxInd = nCurInd;
        }

        return nCurMaxInd;
    }

    private boolean checkIfBacking (int dir) {
        if (bIsBacktracking) {
            if (dir == (moves.get (nBackMoveInd) + 180) % 360) {
                return true;
            }
            else return false;
        }
        else {
            if (dir == (moves.get (nMoveCount - 1) + 180) % 360) {
                nBackMoveInd = nMoveCount - 1;
                return true;
            }
            else return false;
        }
    }

    //Insted of the binding thingy, checks if direction to move at is valid
    private boolean isValidDir (int dir) {
        if (dir == 0)           //Right
            if (miner.getX () == n - 1) return false;
            else return true;
        else if (dir == 90)    //Down
        if (miner.getY () == n - 1) return false;
        else return true;
        else if (dir == 180)    //Left
            if (miner.getX () == 0) return false;
            else return true;
        else if (dir == 270)     //Up
        if (miner.getY () == 0) return false;
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


    //TESTING FUNCS HERE ========================================
    public void printDirections () {
        char[] directions = {'R', 'D', 'L', 'U'};
        for (int i : moves) System.out.print (directions[i / 90] + ",  ");
    }


}