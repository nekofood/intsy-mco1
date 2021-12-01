import java.util.*;

//the driver
public class Main {
	public static void main(String[] args) {
		Grid g;
		ControlView cv;
		View v;
		Controller c;
		Miner m;
		Searcher sc;

		Scanner kb = new Scanner(System.in);
		int dim = 0;

		while (dim < 8 || dim > 64) {
			System.out.print("Enter board dimensions (min 8, max 64): ");
			dim = kb.nextInt();
		}


		g = new Grid(dim); //temp value, TODO: input
		m = new Miner(0, 0);
		cv = new ControlView();
		v = new View(dim);
		sc = new Searcher(g, m);

		c = new Controller(g, v, cv, sc);

		c.gameLoop();
	}
}
