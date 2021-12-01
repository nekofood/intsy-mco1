public class Miner {
	private int rotation; //0deg = right, 90deg = down, and so on
	private int x,y;

	Miner(int sx, int sy) {
		rotation = 0;
		x = sx;
		y = sy;
	}

	//Rotate counter-clockwise
	public void rotate() {
		System.out.println (rotation);
		rotation = (rotation + 90) % 360;
	}

	//Move forward
	public void forward() {
		switch (rotation) {
			case 0:
				++x; break;
			case 90:
				++y; break;
			case 180:
				--x; break;
			case 270:
				--y; break;
			default:
				System.out.println("Miner is facing invalid direction");
				rotation = 0;
				break;
		}
	}

	//Checks the current block
	public char scanCurrent (char[][] grid) {
		return grid[this.y][this.x];
	}

    // allows the miner to scan mining area on his current front, returns the nearest object in his vicinity
    public char scan (char[][] grid) {
		int n = grid.length;
		int x, y;

        switch(rotation) {
			case 90:	//Downward
				for(x = this.getX(), y = this.getY() + 1; y < n; y++) {
					if(grid[y][x] == 'P') {
						System.out.print("A pit is nearby");
						return 'P';	//Once it detects return it insta so it don gotta go through the whole thing
					}
					else if(grid[y][x] == 'B') {
						System.out.print("A beacon is nearby");
						return 'B';
					}
					else if(grid[y][x] == 'G') {
						System.out.print("A pot of gold is nearby");
						return 'G';
					}
				}
				System.out.print("Nothing is nearby");
				return '\0';

			case 180:	//Leftward
				for(x = this.getX() - 1, y = this.getY();  x >= 0; x--){
					if(grid[y][x] == 'P') {
						System.out.print("A pit is nearby");
						return 'P';
					}
					else if(grid[y][x] == 'B') {
						System.out.print("A beacon is nearby");
						return 'B';
					}
					else if(grid[y][x] == 'G') {
						System.out.print("A pot of gold is nearby");
						return 'G';
					}
				}
				System.out.print("Nothing is nearby");
				return '\0';

			case 270:	//Upward
			for(x = this.getX(), y = this.getY() - 1;  y >= 0; y--){
				if(grid[y][x] == 'P') {
					System.out.print("A pit is nearby");
					return 'P';
				}
				else if(grid[y][x] == 'B') {
					System.out.print("A beacon is nearby");
					return 'B';
				}
				else if(grid[y][x] == 'G') {
					System.out.print("A pot of gold is nearby");
					return 'G';
				}
			}
			System.out.print("Nothing is nearby");
			return '\0';

			case 0:	//Rightward
				for(x = this.getX() + 1, y = this.getY();  x < n; x++){
					if(grid[y][x] == 'P') {
						System.out.print("A pit is nearby");
						return 'P';
					}
					else if(grid[y][x] == 'B') {
						System.out.print("A beacon is nearby");
						return 'B';
					}
					else if(grid[y][x] == 'G') {
						System.out.print("A pot of gold is nearby");
						return 'G';
					}
				}
				System.out.print("Nothing is nearby");
				return '\0';

			default:
				System.out.println("Invalid direction!");
				rotation = 0;
				break;
		}

		return 'A';	//This just to avoid the error of "waahh its not returning anything" || it should theoretically not reach this
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void updateX (int newX) {
		x = newX;
	}

	public void updateY (int newY) {
		y = newY;
	}

	public int getRotation() {
		return rotation;
	}
}
