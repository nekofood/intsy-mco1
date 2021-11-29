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
	//Note: does not handle collision yet
	public void forward() {
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
