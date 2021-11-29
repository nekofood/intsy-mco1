import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class View extends JFrame {
	private JPanel panel;
	private JLabel[][] viewGrid;
	private ImageIcon minerIcon, pitIcon, goldIcon, beaconIcon;

	View(int dim) {
		System.out.println("Creating a " + dim + " by " + dim + " grid");
		panel = new JPanel();
		viewGrid = new JLabel[dim][dim];

		setTitle("Miner");
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
	}
	//TODO: i'm not sure where the control panel should go

	//TODO: draw() method that redraws the entire JLabel grid based on piece positions or something
	//can't do it until i finish Grid class
}
