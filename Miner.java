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
    public void scan (char[][] grid) {
		int n = grid.length;

        switch(rotation) {
			case 270:
				int bClosest = 0;
				for(int i = this.getX(), j = this.getY(); j <= 0; j--){
					if(grid[i][j] == 'P' && bClosest == 0){
						System.out.print("A pit is nearby");
						bClosest = 1;
					}
					else if(grid[i][j] == 'B' && bClosest == 0){
							System.out.print("A beacon is nearby");
							bClosest = 1;
					}
					else if(grid[i][j] == 'G' && bClosest == 0) {
							System.out.print("A pot of is nearby");
								bClosest = 1;
					}
				}
				break;

			case 90:
				bClosest = 0;
				for(int i = this.getX(), j = this.getY(); j <= n; j++){
					if(grid[i][j] == 'P' && bClosest == 0){
						System.out.print("A pit is nearby");
						bClosest = 1;
					}
					else if(grid[i][j] == 'B' && bClosest == 0){
							System.out.print("A beacon is nearby");
							bClosest = 1;
					}
					else if(grid[i][j] == 'G' && bClosest == 0) {
							System.out.print("A pot of is nearby");
								bClosest = 1;
					}
				}
				break;

			case 180:
				bClosest = 0;
				for(int i = this.getX(), j = this.getY(); i >= 0; i--){
					if(grid[i][j] == 'P' && bClosest == 0){
						System.out.print("A pit is nearby");
						bClosest = 1;
					}
					else if(grid[i][j] == 'B' && bClosest == 0){
							System.out.print("A beacon is nearby");
							bClosest = 1;
					}
					else if(grid[i][j] == 'G' && bClosest == 0) {
							System.out.print("A pot of is nearby");
								bClosest = 1;
					}
				}
				break;

			case 0:
				bClosest = 0;
				for(int i = this.getX(), j = this.getY(); i <= n; i++){
					if(grid[i][j] == 'P' && bClosest == 0){
						System.out.print("A pit is nearby");
						bClosest = 1;
					}
					else if(grid[i][j] == 'B' && bClosest == 0){
							System.out.print("A beacon is nearby");
							bClosest = 1;
					}
					else if(grid[i][j] == 'G' && bClosest == 0) {
							System.out.print("A pot of is nearby");
								bClosest = 1;
					}
				}
				break;

			default:
				System.out.println("Invalid direction!");
				rotation = 0;
				break;
		}
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
