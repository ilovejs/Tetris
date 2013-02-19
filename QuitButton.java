package Tetris;

public class QuitButton extends javax.swing.JButton{

    public QuitButton(){
	super("QUIT");
       
	this.addActionListener(new QuitListener());
    }

    private class QuitListener implements java.awt.event.ActionListener{
	public void actionPerformed(java.awt.event.ActionEvent e){
	    System.exit(0);
	}
    }
}
