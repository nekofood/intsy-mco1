import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class View extends JFrame {
	JPanel panel;
	JLabel[][] viewGrid;

	View(int dim) {
		panel = new JPanel();
		viewGrid = new JLabel[dim][dim];
	}
	//TODO: i'm not sure where the control panel should go

	//TODO: draw() method that redraws the entire JLabel grid based on piece positions or something
	//can't do it until i finish Grid class
}
