import java.util.*;

public class Grid {
	private int n;
	/* The things on the grid, such as beacons, pits, and the pot of gold, will
	   be represented with a 2D array of chars, using chars to indicate the positions
	   of things.
	   M = miner
	   P = pit
	   B = beacon
	   G = gold
	   \0 = null/empty */
	private char[][] grid;

	private int goldX; //for generation purposes
	private int goldY;

	Grid(int length) {
		n = length;

		goldX = 0; //initialize them now for safety
		goldY = 0;

		grid = new char[n][n];

		grid[0][0] = 'M';
		generateThings ();
	}

	//updates the miner's position on the char grid using the miner's x,y
	public void updateMinerPosition(int x, int y) {
		//place the new miner char
		grid[y][x] = 'M';
	}

	//Console printing of board (for testing)
	public void printGrid () {
        int i, j;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
				if (grid[i][j] != '\0')
                	System.out.print(grid[i][j]);
				else
					System.out.print(".");
			}
            System.out.print("\n");
        }
    }

	public int getN () {
		return n;
	}
	public char[][] getGrid () {
		return grid;
	}

	//TODO: "distribute" method to place the things on the grid
	private void generateThings() {
		generateGold ();
		generateBeacon ();
		generatePit ();
	}

	//Generates pit/s into the board
	private void generatePit() {
		int x, y;
		int i, pitCount;

		pitCount = (int)(n * 0.25);	//number of pits

		x = 0;
		y = 0;

		//Loops on how many pits are on the grid
		for (i = 0; i < pitCount; i++) {
			/* while position isnt the miner's or
					 position isnt empty */
			while (grid[y][x] == 'M' || grid[y][x] != '\0') {
				//generate random numbers from 0 to n
				x = (int)(Math.random() * (n - 1));
				y = (int)(Math.random() * (n - 1));
			}

			grid[y][x] = 'P';
		}
	}

	//Generates beacon/s into the board
	private void generateBeacon () {
		int x, y;
		int i, beaconCount;

		beaconCount = (int)(n * 0.1);	//number of beacon/s
		if (beaconCount < 1) beaconCount = 1; //Always at least one beacon

		x = 0;
		y = 0;

		//Loops how many beacon/s are on the grid
		for (i = 0; i < beaconCount; i++) {
			//determine if we're gonna use gold x or gold Y for this one
			// n>0.5 = gold x
			if (Math.random() > 0.5) {
				while (grid[y][x] != '\0' || grid[y][x] == 'M') {
					x = goldX;
					y = (int)(Math.random() * (n - 1));
				}
			}
			else {
				while (grid[y][x] != '\0' || grid[y][x] == 'M') {
					x = (int)(Math.random() * (n - 1));
					y = goldY;
				}
			}

			grid[y][x] = 'B';
		}
	}

	//Generates gold into the board
	private void generateGold () {
		int x, y;

		x = 0;
		y = 0;

		while (grid[y][x] == 'M' || grid[y][x] != '\0') {
			x = (int)(Math.random() * (n - 1));
			y = (int)(Math.random() * (n - 1));
		}

		grid[y][x] = 'G';
		goldX = x;
		goldY = y;
	}


}
