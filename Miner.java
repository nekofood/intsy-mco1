public class Miner {
	private int rotation; //0deg = right, 90deg = up, and so on
	private int x,y;

	Miner(int sx, int sy) {
		rotation = 0;
		x = sx;
		y = sy;
	}

	//Rotate counter-clockwise
	public void rotate() {
		rotation = (rotation+90)%360;
	}

	//Move forward
	public void forward(int n) {
		switch (rotation) {
			case 0:
				++x; break;
			case 90:
				--y; break;
			case 180:
				--x; break;
			case 270:
				++y; break;
			default:
				System.out.println("Miner is facing invalid direction");
				rotation = 0;
				break;
		}
	}


    // allows the miner to scan mining area on his current front, returns the nearest object in his vicinity
    public char scan (char[][] grid) {
		int n = grid.length;

        switch(rotation) {
			case 270:
				for(int i = this.getX(), j = this.getY(); j <= 0; j--) {
					if(grid[i][j] == 'P') {
						System.out.print("A pit is nearby");
						return 'P';	//Once it detects return it insta so it don gotta go through the whole thing
					}
					else if(grid[i][j] == 'B') {
						System.out.print("A beacon is nearby");
						return 'B';
					}
					else if(grid[i][j] == 'G') {
						System.out.print("A pot of is nearby");
						return 'G';
					}
					else {
						System.out.print("Nothing is nearby");
						return '\0';
					}
				}
				break;

			case 90:
				for(int i = this.getX(), j = this.getY(); j <= n; j++){
					if(grid[i][j] == 'P') {
						System.out.print("A pit is nearby");
						return 'P';
					}
					else if(grid[i][j] == 'B') {
						System.out.print("A beacon is nearby");
						return 'B';
					}
					else if(grid[i][j] == 'G') {
						System.out.print("A pot of is nearby");
						return 'G';
					}
					else {
						System.out.print("Nothing is nearby");
						return '\0';
					}
				}
				break;

			case 180:
				for(int i = this.getX(), j = this.getY(); i >= 0; i--){
					if(grid[i][j] == 'P') {
						System.out.print("A pit is nearby");
						return 'P';
					}
					else if(grid[i][j] == 'B') {
						System.out.print("A beacon is nearby");
						return 'B';
					}
					else if(grid[i][j] == 'G') {
						System.out.print("A pot of is nearby");
						return 'G';
					}
					else {
						System.out.print("Nothing is nearby");
						return '\0';
					}
				}
				break;

			case 0:
				for(int i = this.getX(), j = this.getY(); i <= n; i++){
					if(grid[i][j] == 'P') {
						System.out.print("A pit is nearby");
						return 'P';
					}
					else if(grid[i][j] == 'B') {
						System.out.print("A beacon is nearby");
						return 'B';
					}
					else if(grid[i][j] == 'G') {
						System.out.print("A pot of is nearby");
						return 'G';
					}
					else {
						System.out.print("Nothing is nearby");
						return '\0';
					}
				}
				break;

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
