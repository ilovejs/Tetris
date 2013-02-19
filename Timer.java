package Tetris;

public class Timer extends javax.swing.Timer{

    private Proxy _proxy;

    public Timer(Proxy proxy){
	super(500, null);
	_proxy = proxy;
	this.addActionListener(new MoveDownListener());
    }
    
    private class MoveDownListener implements java.awt.event.ActionListener{
	public void actionPerformed(java.awt.event.ActionEvent e){
	    _proxy.moveDown();
	}
    }
}
