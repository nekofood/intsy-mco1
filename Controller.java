import java.awt.event.*;
import javax.swing.*;

//the C in MVC
//this class will be responsible for running the simulation/the agent
public class Controller {
	private Grid grid;
	private View view;
	private ControlView cv;
	private boolean isPlaying, //is the simulation in "play" mode?
					gameOver;
	private int spacesTraversed;
	private int step; //worst idea ever
	private Searcher s;

	Controller(Grid g, View v, ControlView c, Searcher sc) {
		grid = g;
		view = v;
		cv = c;
		s = sc;
		isPlaying = false;
		gameOver = false;
		spacesTraversed = 0;

		step = 0;
		/*
			Okay so it goes like this: when you press the step button the "step"
			variable increments and that's how the main loop knows when to advance
			the simulation one step. Hopefully we can come up with a better
			solution in time.
		*/

		cv.addListener(cview.getPlayButton(), new ControlListener);
		cv.addListener(cview.getPauseButton(), new ControlListener);
		cv.addListener(cview.getStepButton(), new ControlListener);
	}

	public void incrementSpacesTraversed() {
		++spacesTraversed;
		cv.updateSpacesTraversed(spacesTraversed);
	}

	public void endGame() {
		cv.getPlayButton().setEnabled(false);
		cv.getPauseButton().setEnabled(false);
		cv.getStepButton().setEnabled(false);
	}

	public void gameLoop() {
		while (!gameOver) {
			while (isPlaying) {
					s.Search();
					incrementSpacesTraversed();
					Thread.sleep(700);
			}
			//code for pause behavior goes here
			if (step >= 1) {
				/* advance the agent one step */
				s.Search();
				incrementSpacesTraversed();
				step = 0;
			}
		}

	}

	public void advanceStep() {
		s.Search();
	}

	//IDEA: while-true loop to run the simulation in fast mode?

	//listener for the control window
	class ControlListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton srcButton = (JButton) e.getSource();
			switch (srcButton.getText()) {
				case "Pause":
					isPlaying = false;
					cv.getPlayButton().setEnabled(true);
					cv.getPauseButton().setEnabled(false);
					cv.getStepButton().setEnabled(true); //enable step button while in Pause mode
					break;
				case "Play":
					isPlaying = true;
					cv.getPlayButton().setEnabled(false);
					cv.getPauseButton().setEnabled(true);
					cv.getStepButton().setEnabled(false); //disable step button while in Play mode
					break;
				case "Step":
					/* code to advance the agent one step goes here... */
					++step;
					break;
			}
		}
	}
}
