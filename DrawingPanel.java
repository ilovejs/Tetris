package Tetris;

import javax.swing.*;

public class DrawingPanel extends JPanel implements SquareConstants{
    
    private Proxy _proxy;
    private Timer _timer;
    private ShapeFactory _shapeFactory;
    private Moveable _shape;
    private Square[][] _paintArray;
    private Boolean[][] _squareBoolArray;
    private InputMap _inputMap;
    private ActionMap _actionMap;
    private Square _square;
    private boolean _isPaused;
    private MainPanel _panel;

    public DrawingPanel(MainPanel panel){
	super();
	setPreferredSize(new java.awt.Dimension(240, 520));
	setSize(240, 520);
	_isPaused = false;
	_panel = panel;

	_proxy = new Proxy(this);
	_timer = new Timer(_proxy);	

	_paintArray = new Square[getWidth()/(int)(BOXSIZE)][getHeight()/(int)(BOXSIZE)];
	_squareBoolArray = new Boolean[getWidth()/(int)BOXSIZE][getHeight()/((int)BOXSIZE)+1];

	for(int i = 0; i < _paintArray.length; i++){
	    for(int j = 0; j < _paintArray[0].length; j++){
		_paintArray[i][j] = new Square(this);
		_paintArray[i][j].setVisible(false);
	    }
	}
	for(int p = 0; p < _paintArray[0].length; p++){
	    _paintArray[0][p].setColor(java.awt.Color.WHITE);
	    _paintArray[0][p].setLocation(0, (double)p*BOXSIZE);
	    _paintArray[0][p].setVisible(true);
	    _paintArray[_paintArray.length-1][p].setColor(java.awt.Color.WHITE);
	    _paintArray[_paintArray.length-1][p].setLocation((double)(_paintArray.length-1)*BOXSIZE, (double)p*BOXSIZE);
	    _paintArray[_paintArray.length-1][p].setVisible(true);
	}
	for(int k = 0; k < _squareBoolArray.length; k++){
	    for(int l = 0; l < _squareBoolArray[0].length; l++)
		_squareBoolArray[k][l] = false;
	}

	for(int m = 0; m < _squareBoolArray.length; m++)
	    _squareBoolArray[m][_squareBoolArray[0].length-1] = true; //length-1?
	for(int n = 0; n < _squareBoolArray[0].length; n++){
	    _squareBoolArray[0][n] = true;
	    _squareBoolArray[_squareBoolArray.length-1][n] = true;
	}

	_shapeFactory = new ShapeFactory(this);
	_shape = _shapeFactory.getShape(); 	
	_proxy.setShape(_shape);
	

	_inputMap = this.getInputMap(WHEN_IN_FOCUSED_WINDOW);
	_actionMap = this.getActionMap();


	_inputMap.put(KeyStroke.getKeyStroke('j'), "move_left");
	_actionMap.put("move_left", new MoveLeftListener());


	_inputMap.put(KeyStroke.getKeyStroke('l'), "move_right");
	_actionMap.put("move_right", new MoveRightListener());

	_inputMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, 0), "drop");
	_actionMap.put("drop", new DropListener());
	
	_inputMap.put(KeyStroke.getKeyStroke('k'), "rotate");
	_actionMap.put("rotate", new RotateListener());
	
	_inputMap.put(KeyStroke.getKeyStroke('p'), "pause");
	_actionMap.put("pause", new PauseListener());

 	_timer.start();

    }

    public void paintComponent(java.awt.Graphics g){
	super.paintComponent(g);
	java.awt.Graphics2D brush = (java.awt.Graphics2D) g;
	//loop through array and paint all of its elements
	for(int i = 0; i < _paintArray.length; i++){
	    for(int j = 0; j < _paintArray[0].length; j++){
		if(_paintArray[i][j] != null)
		    _paintArray[i][j].paint(brush);
	    }
	}
    }

    public void setPaintArray(double x, double y, Square square){
	_paintArray[(int)x/(int)BOXSIZE][(int)y/(int)BOXSIZE] = square;
    }

    public void stop(){
	_proxy.setVisible(true);
	_timer.stop();
	_timer.setDelay(500);
	_shape = _shapeFactory.getShape();
	_proxy.setShape(_shape);
	_timer.start();
    }
    public void checkCompleteRow(){
	boolean toRemove = false;
	int numToRemove = 0;
	for(int a = _squareBoolArray[0].length-2; a > 0; a--){
	    toRemove = true;
	    for(int b = 1; b < (_squareBoolArray.length-1); b++){
		if(_squareBoolArray[b][a] == false){
		    toRemove = false;
		    break;
		}
	    }
	    if(toRemove == true){
		++numToRemove;
		for(int c = 1; c < (_squareBoolArray.length-1); c++){
		    _paintArray[c][a].setVisible(false);
		    _squareBoolArray[c][a] = false;
		}
	    }else{
		for(int d = 1; d <= numToRemove; d++){
		    for(int e = 1; e < (_squareBoolArray.length-1); e++){
			_paintArray[e][a+d] = _paintArray[e][a+d-1];
			if( _squareBoolArray[e][a+d-1] == true ){
			    _paintArray[e][a+d].moveDown();
			}
			_squareBoolArray[e][a+d] = _squareBoolArray[e][a+d-1];
			_squareBoolArray[e][a+d-1] = false;
		    }
		}
	    }
	}
	checkEndGame();
    }
    public void checkEndGame(){
	for(int i = 1; i < _squareBoolArray.length-1; i++){
	    //System.out.println(_squareBoolArray[i][0]);
	    if(_squareBoolArray[i][0] == true){
		_timer.stop();
		_panel.addEndLabel();
	    }
	}
    }
    public void setSquareBoolArray(double x, double y){
	int _x = (int)x/(int)BOXSIZE;
	int _y = (int)y/(int)BOXSIZE;
	_squareBoolArray[_x][_y] = true;
    }
    public boolean getSquareBoolArray(int x, int y){
	return _squareBoolArray[x][y];
    }


    private class MoveLeftListener extends AbstractAction{
	public void actionPerformed(java.awt.event.ActionEvent e){
	    _proxy.moveLeft();
	}
    }
    private class MoveRightListener extends AbstractAction{
	public void actionPerformed(java.awt.event.ActionEvent e){
	    _proxy.moveRight();
	}
    }

    private class DropListener extends AbstractAction{
	public void actionPerformed(java.awt.event.ActionEvent e){
	    _proxy.setVisible(false);
	    _timer.setDelay(0);
	}
    }
    private class RotateListener extends AbstractAction{
	public void actionPerformed(java.awt.event.ActionEvent e){
	    _proxy.rotate();
	}
    }
    private class PauseListener extends AbstractAction{
	public void actionPerformed(java.awt.event.ActionEvent e){

	    if(_isPaused == false){
		_timer.stop();
		_isPaused = true;
		_panel.addPauseLabel();
	    }
	    else{
		_timer.start();
		_isPaused = false;
		_panel.removeLabel();
	    }
	}
    }
        
}
