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
}
