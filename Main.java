//the driver
public class Main() {
	public static void main(String[] args) {
		Grid g;
		ControlView cv;
		View v;
		Controller c;

		g = new Grid(8); //temp value
		cv = new ControlView();
		v = new View();

		c = new Controller(g, v, cv);
	}
}
