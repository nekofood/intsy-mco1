import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this class contains the window with the step, pause, speed controls, etc
public class ControlView extends JFrame {
	private JPanel panel;
	private JButton stepButton; /* step 1 move
								   it's either this button is disabled during play, or
								   we make it so that pressing it will pause the action*/
	private JButton playButton; //play the miner (TODO: how often should the simulation progress?)
	private JButton pauseButton;
	private JLabel actionCount, spacesTraversed;

	ControlView() {
		setTitle("Controls");
		setSize(400,200);

		panel = new JPanel(); //TODO: layout
		stepButton = new JButton("Step");
		playButton = new JButton("Play");
		pauseButton = new JButton("Pause");

		actionCount = new JLabel("Actions taken: ");
		spacesTraversed = new JLabel("Spaces traversed: ");

		panel.add(pauseButton);
		panel.add(playButton);
		panel.add(stepButton);
		panel.add(actionCount);
		panel.add(spacesTraversed);

		add(panel);
		setVisible(true);
	}
}
