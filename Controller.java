import java.awt.event.*;
import javax.swing.*;

//the C in MVC
//this class will be responsible for running the simulation and maybe running the agent
class Controller {
	private Grid grid;
	private View view;

	Controller(Grid g, View v) {
		grid = g;
		view = v;
	}
}
