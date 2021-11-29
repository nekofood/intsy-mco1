import java.awt.event.*;
import javax.swing.*;

//the C in MVC
//this class will be responsible for running the simulation/the agent
class Controller {
	private Grid grid;
	private View view;
	private boolean fastPlay; //is the simulation in "fast play" mode?
	private int actionCount, spacesTraversed;

	Controller(Grid g, View v) {
		grid = g;
		view = v;
		fastPlay = false;
		actionCount = 0;
		spacesTraversed = 0;
	}

	//IDEA: while-true loop to run the simulation in fast mode?

	//listener for the control window
	class ControlListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//blah blah blah
		}
	}
}
