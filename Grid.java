public class Grid {
	private int width, height;
	/* The things on the grid, such as beacons, pits, and the pot of gold, will
	   be represented with a 2D array of chars, using chars to indicate the positions
	   of things.
	   M = miner
	   P = pit
	   B = beacon
	   G = gold */
	private char[][] grid;

	Grid(int x, int y) {
		width = x;
		height = y;
	}
}
