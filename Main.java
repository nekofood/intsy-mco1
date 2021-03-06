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
		int aiChoice = 0;

		while (dim < 8 || dim > 64) {
			System.out.print("Enter board dimensions (min 8, max 64): ");
			dim = kb.nextInt();
		}

		while (aiChoice != 1 && aiChoice != 2) {
			System.out.print("Choose agent type (1 - random, 2 - smart): ");
			aiChoice = kb.nextInt();
		}

		kb.close ();
		
		g = new Grid(dim); //temp value, TODO: input
		m = new Miner(0, 0);
		cv = new ControlView();
		v = new View(dim);
		sc = new Searcher(g, m);

		if (aiChoice == 2)
			sc.switchAgent();

		
		c = new Controller(g, v, cv, sc);

		c.gameLoop();
	}
}
