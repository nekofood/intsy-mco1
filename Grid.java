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

	public int getN () {
		return n;
	}
	public char[][] getGrid () {
		return grid;
	}

	//"distribute" method to place the things on the grid
	private void generateThings() {
		generateGold ();
		generateBeacon ();
		generatePit ();
	}

	//Generates pit/s into the board
	private void generatePit() {
		int x, y,b;
		int i, pitCount;

		pitCount = (int)(n * 0.25);	//number of pits

		x = 0;
		y = 0;
		b = -1;

		//Loops on how many pits are on the grid
		for (i = 0; i < pitCount; i++) {
			/* while position isnt the miner's or
					 position isnt empty */
			while (grid[y][x] == 'M' || grid[y][x] != '\0') {
				//generate random numbers from 0 to n
				x = (int)(Math.random() * n);
				y = (int)(Math.random() * n);

				//beacon check per axis
				if (x == goldX) { //y-axis check
					for (int j=0;j<n;j++) {
						//go through the column looking for a beacon
						if (grid[j][x] == 'B') {
							b = j;
							break;
						}
					}
					//check if the pit is between gold and beacon
					if (getDistance(b,y) + getDistance(y,goldY) == getDistance(b,goldY)) {
						x = y = 0;
						continue;	//conflict detected, continue the loop!
					}
				}

				if (y == goldY) { //x-axis check
					for (int j=0;j<n;j++) {
						//go through the row looking for a beacon
						if (grid[y][j] == 'B') {
							b = j;
							break;
						}
					}
					//check if the pit is between gold and beacon
					if (getDistance(b,x) + getDistance(x,goldX) == getDistance(b,goldX)) {
						x = y = 0;
						continue;	 //conflict detected, continue the loop!
					}
				}
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
					y = (int)(Math.random() * n);
				}
			}
			else {
				while (grid[y][x] != '\0' || grid[y][x] == 'M') {
					x = (int)(Math.random() * n);
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
			x = (int)(Math.random() * n);
			y = (int)(Math.random() * n);
		}

		grid[y][x] = 'G';
		goldX = x;
		goldY = y;
	}

	//used for pit generation
	private int getDistance(int a, int b) {
		if (a > b)
			return a - b;
		if (b > a)
			return b - a;
		return 0;
	}

}
