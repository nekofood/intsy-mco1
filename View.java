import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class View extends JFrame {
	private JPanel panel;
	private JLabel[][] viewGrid;
	private ImageIcon minerIcon, pitIcon, goldIcon, beaconIcon;

	View(int dim) {
		System.out.println("Creating a " + dim + " by " + dim + " grid");
		panel = new JPanel(new Grid); //TODO: I forgot to add a layout
		viewGrid = new JLabel[dim][dim];

		setTitle("Miner");
		panel.setLayout(new GridLayout(dim, dim));
		setSize(dim*16,dim*16);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//initialize icons
		minerIcon = new ImageIcon("img/miner.png");
		pitIcon = new ImageIcon("img/pit.png");
		beaconIcon = new ImageIcon("img/beacon.png");
		goldIcon = new ImageIcon("img/gold.png");

		for (int i = 0; i < dim; i++) { //create labels
			for (int j = 0; j < dim; j++) {
				viewGrid[i][j] = new JLabel();
				panel.add(viewGrid[i][j]);
			}
		}

		add(panel);
		setVisible(true);
	}
	//TODO: i'm not sure where the control panel should go

	//Updates the view grid based on the char grid
	//This is achieved by wiping the grafix, and then redrawing them
	public void updateView(char[][] grid) {
		//wipe the grid
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				viewGrid[i][j].setIcon(null);
			}
		}

		//place the icons on the grid
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				switch (grid[i][j]) {
					case 'M':
						viewGrid[i][j].setIcon(minerIcon); break;
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
	}
}
