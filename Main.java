//the driver
public class Main {
	public static void main(String[] args) {
		Grid g;
		ControlView cv;
		View v;
		Controller c;
		Miner m;
		Searcher sc;

		g = new Grid(8); //temp value, TODO: input
		m = new Miner(0, 0);
		cv = new ControlView();
		v = new View();
		sc = new Searcher(g, m);

		c = new Controller(g, v, cv, sc);
	}
}
