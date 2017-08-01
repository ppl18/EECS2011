/**
 * 
 */
package snake;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author pc4
 *
 */

public class Snake extends JFrame implements ActionListener {
	
	// a unique identifier to associate with the Open Command
	public static final String OPEN_COMMAND = "Open";

	// A label to show the image
	private JLabel img;
	
	public Snake() {
		// Create the frame
		super("Snake");
		
		// Choose what happens when the frame closes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create components and put in the frame
		this.makeMenu();
		this.makeLabel();
		this.setLayout(new FlowLayout());
		
		// Create components and put them in the frame
		this.setMinimumSize(new Dimension(600, 400));
		this.pack();
		
		// Show it
		this.setVisible(true);
	
	}
		
	private void makeLabel() {
		this.img = new JLabel("");
		this.getContentPane().add(this.img);
	}

	private void makeMenu() {
		JMenuBar menubar = new JMenuBar();
		this.add(menubar);
		
		JMenuItem openMenuItem = new JMenuItem("Open...");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Snake();
	}
}