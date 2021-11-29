import java.lang.Math.*;

public class Grid {
	private int n;
	/* The things on the grid, such as beacons, pits, and the pot of gold, will
	   be represented with a 2D array of chars, using chars to indicate the positions
	   of things.
	   M = miner
	   P = pit
	   B = beacon
	   G = gold */
	private char[][] grid;
	private Miner miner;
	private int minerX;
	private int minerY;

	Grid(int length, Miner m) {
		n = length;
		miner = m;
		minerX = 0;
		minerY = 0;

		grid = new char[n][n];
		grid[0][0] = 'M';
	}

	//TODO: "distribute" method to place the things on the grid
	public void generateThings() {
		//generate random numbers from 1 to n to place pot
		int range = (n - 1) + 1;
		int x = (int)(Math.random() * range) + 1;
		int y = (int)(Math.random() * range) + 1;
		grid[y][x] = 'G';
	}

	//updates the miner's position on the char grid using the miner's x,y
	public void updateMinerPosition() {
		int x = miner.getX()
		int y = miner.getY()

		//first, clear the position of the miner char
		grid[minerY][minerX] = null;
		//place the new miner char
		grid[y][x] = 'M';
		//update minerX and minerY
		minerX = x;
		minerY = y;
	}
}
