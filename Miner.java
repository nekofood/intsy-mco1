public class Miner {
	private int rotation; //0deg = right, 90deg = up, and so on

	Miner() {
		rotation = 0;
	}

	//Rotate counter-clockwise
	public void rotate() {
		rotation = (rotation+90)%360;
	}
}
