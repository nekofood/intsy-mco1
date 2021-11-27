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
}
