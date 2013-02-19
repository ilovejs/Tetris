package Tetris;

import javax.swing.*;

public class MainPanel extends JPanel{
    private DrawingPanel _dp;
    private QuitButton _quitButton;
    private JLabel _label;

    public MainPanel(){
	super();
	this.setLayout(new java.awt.BorderLayout());

	_label = new JLabel("  ");

	//create a new DrawingPanel and set its dimension/color
	_dp = new DrawingPanel(this);
	//	_dp.setPreferredSize(new java.awt.Dimension(200, 520));
	_dp.setBackground(java.awt.Color.black);
	
	_quitButton = new QuitButton();

	_quitButton.setFocusable(false);
	_dp.setFocusable(true);
	_dp.grabFocus();

	//Add DrawingPanel, and EastPanel to MainPanel
	this.add(_dp, java.awt.BorderLayout.NORTH);
	this.add(_label, java.awt.BorderLayout.CENTER);
	this.add(_quitButton, java.awt.BorderLayout.SOUTH);

    }
    public void addPauseLabel(){
	_label.setVisible(true);
	_label.setText("<html><font color=red>PAUSE</font></html>");
    }
    public void removeLabel(){
	_label.setVisible(false);
    }
    public void addEndLabel(){
	_label.setVisible(true);
	_label.setText("<html><font color=blue>GAME OVER!!!</font></html>");
    }

}
