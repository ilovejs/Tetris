package Tetris;

/**
 * This is the  main class to get things started.  
 * Note that this is an application, whose main method calls 
 * the App constructor.  You will need to fill in the constructor
 * to instantiate your Tetris game.
 *
 * Class comments here...
 *
 * @author <your name here>
 */

public class App extends javax.swing.JFrame{

    public App() {
	super();
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	MainPanel panel = new MainPanel();
	this.add(panel);
	this.pack();
	this.setVisible(true);

    }

    public static void main(String[] argv) {
	new App();
    }

}
