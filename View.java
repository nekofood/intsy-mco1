import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

class View extends JFrame {
	private JPanel panel;
	private JLabel[][] viewGrid;
	private ImageIcon pitIcon, goldIcon, beaconIcon;
	private ImageIcon[] minerIcon;
	private int n;

	//TODO: Borders, rotation

	View(int dim) {
		n = dim;
		System.out.println("Creating a " + dim + " by " + dim + " grid (" + n*16 + "x)");
		panel = new JPanel();
		viewGrid = new JLabel[n][n];

		setTitle("Miner");
		setLayout(new BorderLayout());
		setSize(n*24,n*24);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//initialize icons
		minerIcon[4] = {new ImageIcon("img/miner_R.png"), new ImageIcon("img/miner_D.png"),
					 new ImageIcon("img/Miner_L.png"), new ImageIcon("img/miner_U.png")};

		pitIcon = new ImageIcon("img/pit.png");
		beaconIcon = new ImageIcon("img/beacon.png");
		goldIcon = new ImageIcon("img/gold.png");

		panel.setLayout(new GridLayout(n, n));

		Border blackline = BorderFactory.createLineBorder(Color.black);
		for (int i = 0; i < dim; i++) { //create labels
			for (int j = 0; j < dim; j++) {
				viewGrid[i][j] = new JLabel();
				viewGrid[i][j].setBorder(blackline);
				panel.add(viewGrid[i][j]);
			}
		}

		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}
	//TODO: i'm not sure where the control panel should go

	//Updates the view grid based on the char grid
	//This is achieved by wiping the grafix, and then redrawing them
	public void updateView(char[][] grid, int rotation) {
		//wipe the grid
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				viewGrid[i][j].setIcon(null);
			}
		}

		int minerX, minerY;

		//place the icons on the grid
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				switch (grid[i][j]) {
					case 'M':
						minerX = j; minerY = i; break;
					case 'P':
						viewGrid[i][j].setIcon(pitIcon); break;
					case 'G':
						viewGrid[i][j].setIcon(goldIcon); break;
					case 'B':
						viewGrid[i][j].setIcon(beaconIcon); break;
					default:
						break;
				}
			}
		}

		//place miner graphics
		switch (rotation) {
			case '0':
				viewGrid[minerY][minerX].setIcon(minerIcon[0]); break;
			case '90':
				viewGrid[minerY][minerX].setIcon(minerIcon[1]); break;
			case '180':
				viewGrid[minerY][minerX].setIcon(minerIcon[2]); break;
			case '360':
				viewGrid[minerY][minerX].setIcon(minerIcon[3]); break;
		}
	}
}
