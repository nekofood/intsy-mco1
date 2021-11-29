import java.awt.event.*;
import javax.swing.*;

//the C in MVC
//this class will be responsible for running the simulation/the agent
public class Controller {
	private Grid grid;
	private View view;
	private ControlView cv;
	private boolean isPlaying; //is the simulation in "play" mode?
	private int actionCount, spacesTraversed;

	Controller(Grid g, View v, ControlView c) {
		grid = g;
		view = v;
		cv = c;
		isPlaying = false;
		actionCount = 0;
		spacesTraversed = 0;

		cv.addListener(cv.getPlayButton(), new ControlListener);
		cv.addListener(cv.getPauseButton(), new ControlListener);
		cv.addListener(cv.getStepButton(), new ControlListener);
	}

	public void incrementSpacesTraversed() {
		++spacesTraversed;
		v.updateSpacesTraversed(spacesTraversed);
	}

	public void incrementActionCount() {
		++actionCount;
		v.updateActionCount(actionCount);
	}

	//IDEA: while-true loop to run the simulation in fast mode?

	//listener for the control window
	class ControlListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton srcButton = (JButton) e.getSource();
			switch (srcButton.getText()) {
				case "Pause":
					isPlaying = false;
					v.getStepButton().setEnabled(true); //enable step button while in Pause mode
					break;
				case "Play":
					isPlaying = true;
					v.getStepButton().setEnabled(false); //disable step button while in Play mode
					break;
				case "Step":
					/* code to advance the agent one step goes here... */
					break;
			}
		}
	}
}
