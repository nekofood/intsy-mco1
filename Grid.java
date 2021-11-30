import java.lang.Math.*;

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
	private Miner miner;
	private int minerX;
	private int minerY;

	Grid(int length) {
		n = length;
		miner = new Miner(0, 0);
		minerX = 0;
		minerY = 0;

		grid = new char[n][n];

		grid[0][0] = 'M';
		generateThings ();
	}

	//push the miner inbounds if it's OOB
	private void bindMiner() {
		if (miner.getX() >= n)
			miner.updateX(n-1);
		else if (miner.getX() == -1)
			miner.updateX(0);

		if (miner.getY() >= n)
			miner.updateY(n-1);
		else if (miner.getY() == -1)
			miner.updateY(n-1);
	}

	//updates the miner's position on the char grid using the miner's x,y
	public void updateMinerPosition() {
		bindMiner(); //push the miner inbounds first
		int x = miner.getX();
		int y = miner.getY();

		//first, clear the position of the miner char
		grid[minerY][minerX] = '\0';
		//place the new miner char
		grid[y][x] = 'M';
		//update minerX and minerY
		minerX = x;
		minerY = y;
	}

	//Console printing of board (for testing)
	public void printGrid () {
        int i, j;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print("[ " + grid[i][j] + " ]  ");

            System.out.println("\n");
        }
    }

	//TODO: "distribute" method to place the things on the grid
	private void generateThings() {
		generatePit ();
		generateBeacon ();
		generateGold ();
	}

	//Generates pit/s into the board
	private void generatePit() {
		int x, y;
		int i, pitCount;

		pitCount = (int)(n * 0.25);	//number of pits

		x = y = 0;

		//Loops on how many pits are on the grid
		for (i = 0; i < pitCount; i++) {
			/* while position isnt the miner's or
					 position isnt empty */
			while (grid[x][y] == 'M' || grid[x][y] != '\0') {
				//generate random numbers from 0 to n
				x = (int)(Math.random() * n);
				y = (int)(Math.random() * n);
			}

			grid[x][y] = 'P';
		}
	}

	//Generates beacon/s into the board
	private void generateBeacon () {
		int x, y;
		int i, beaconCount;

		beaconCount = (int)(n * 0.1);	//number of beacon/s
		if (beaconCount < 1) beaconCount = 1; //Always at least one beacon

		x = y = 0;

		//Loops how many beacon/s are on the grid
		for (i = 0; i < beaconCount; i++) {
			while (grid[x][y] == 'M' || grid[x][y] != '\0') {
				x = (int)(Math.random() * n);
				y = (int)(Math.random() * n);
			}

			grid[x][y] = 'B';
		}
	}

	//Generates gold into the board
	private void generateGold () {
		int x, y;

		x = y = 0;

		while (grid[x][y] == 'M' || grid[x][y] != '\0') {
			x = (int)(Math.random() * n);
			y = (int)(Math.random() * n);
		}

		grid[x][y] = 'G';
	}


}
