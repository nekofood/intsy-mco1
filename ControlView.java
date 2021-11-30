import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this class contains the window with the step, pause, speed controls, etc
public class ControlView extends JFrame {
	private JPanel buttonPanel, statsPanel; //buttons L2R, stats T2B
	private JButton stepButton; /* step 1 move
								   this button is disabled during play*/
	private JButton playButton; //play the miner (TODO: how often should the simulation progress?)
	private JButton pauseButton;
	private JLabel spacesTraversed;

	ControlView() {
		setTitle("Controls");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		this.setLayout(new BorderLayout());

		buttonPanel = new JPanel(); //TODO: layout
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		statsPanel = new JPanel();
		statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));

		stepButton = new JButton("Step");
		playButton = new JButton("Play");
		pauseButton = new JButton("Pause");
		pauseButton.setEnabled(false); //the simulation starts in "pause" mode, so we will disable this

		spacesTraversed = new JLabel("Spaces traversed: 0");

		buttonPanel.add(pauseButton);
		buttonPanel.add(playButton);
		buttonPanel.add(stepButton);
		statsPanel.add(spacesTraversed);

		add(statsPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void updateSpacesTraversed(int stat) {
		spacesTraversed.setText("Spaces traversed: " + stat);
	}

	public void addListener(JButton jb, ActionListener al) {
		jb.addActionListener(al);
	}

	public JButton getStepButton() {
		return stepButton;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}

	public JButton getPlayButton() {
		return playButton;
	}
}
