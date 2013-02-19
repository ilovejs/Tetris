package Tetris;

public class Proxy implements SquareConstants{
    private Moveable _shape;
    private DrawingPanel _dp;
    private String _str;
    
    public Proxy(DrawingPanel dp){
	_dp = dp;
    }

    public void setShape(Moveable shape){
	_shape = shape;
    }


    public void moveDown(){
	// System.out.println(_shape.getXLocation() + " " + _shape.getYLocation());
// 	_shape.setLocation(_shape.getXLocation(), _shape.getYLocation() + BOXSIZE); //+1?
// 	System.out.println("hi "+ _shape.getXLocation() + " " + _shape.getYLocation());
	_shape.moveDown();
	_dp.repaint();
    }
    public void moveLeft(){
	_shape.moveLeft();
	_dp.repaint();
	// if(_shape.getXLocation() > 0)
// 	    _shape.setLocation(_shape.getXLocation()-BOXSIZE, _shape.getYLocation());
// 	_dp.repaint();
    }
    public void moveRight(){
	_shape.moveRight();
	_dp.repaint();
	// setMotion("right");
// 	if(_shape.getXLocation() + 2*BOXSIZE  < _dp.getWidth())
// 	    _shape.setLocation(_shape.getXLocation()+BOXSIZE, _shape.getYLocation());
// 	_dp.repaint();
    }
    public void rotate(){
	_shape.rotate();
	_dp.repaint();
    }
    public void setVisible(boolean isVisible){
	_shape.setVisible(isVisible);
    }
    public String getMotion(){
	return _str;
    }
    public void setMotion(String str){
	_str = str;
    }
}
