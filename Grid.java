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

	Grid(int length) {
		n = length;
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
}
