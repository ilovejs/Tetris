package Tetris;

public class ShapeFactory{
    
    private DrawingPanel _dp;
    private Moveable square;

    public ShapeFactory(DrawingPanel dp){
	_dp = dp;
    }

    public Moveable getShape(){
	//int rand = (int) (Math.random()*7);
	//int rand = 1;
	int rand = (int)(Math.random()*7);
	//Moveable square = null;

	switch(rand){
	case 0:
	    square = new OPiece(_dp);
	    //square.setLocation(100, 0);
	    square.setVisible(true);
	    square.setColor(java.awt.Color.blue);
	    break;
	case 1:
	    square = new IPiece(_dp);
	    square.setVisible(true);
	    square.setColor(java.awt.Color.red);
	    break;
	case 2:
	    square = new LPiece(_dp);
	    square.setVisible(true);
	    square.setColor(java.awt.Color.green);
	    break;
	case 3:
	    square = new DPiece(_dp);
	    square.setVisible(true);
	    square.setColor(java.awt.Color.orange);
	    break;
	case 4:
	    square = new TPiece(_dp);
	    square.setVisible(true);
	    square.setColor(java.awt.Color.magenta);
	    break;
	case 5:
	    square = new SPiece(_dp);
	    square.setVisible(true);
	    square.setColor(java.awt.Color.cyan);
	    break;
	case 6:
	    square = new ZPiece(_dp);
	    square.setVisible(true);
	    square.setColor(java.awt.Color.pink);
	    break;
	default:
	    System.out.println("ERROR ShapeFactory switch statement");
	    break;
	}
	return square;
    }
}
