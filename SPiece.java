package Tetris;

public class SPiece implements SquareConstants, Moveable{

    private Square _one, _two, _three, _four;
    private DrawingPanel _dp;

    public SPiece(DrawingPanel dp){
	_one = new Square(dp);
	_two = new Square(dp);
	_three = new Square(dp);
	_four = new Square(dp);
	
	_one.setLocation(100.0, 0.0);
	_two.setLocation(_one.getX(), _one.getY()+BOXSIZE);
	_three.setLocation(_one.getX()+BOXSIZE, _one.getY()+BOXSIZE);
	_four.setLocation(_one.getX()+BOXSIZE, _one.getY()+2*BOXSIZE);

	_dp = dp;

	paint();

    }

    public void moveDown(){
	if(_one.canMoveDown() == true && 
	   _two.canMoveDown() == true && 
	   _three.canMoveDown() == true && 
	   _four.canMoveDown() == true){

	    _one.moveDown();
	    _two.moveDown();
	    _three.moveDown();
	    _four.moveDown();
	    paint();
	}
	else{
	    _dp.setSquareBoolArray(_one.getX(), _one.getY());
	    _dp.setSquareBoolArray(_two.getX(), _two.getY());
	    _dp.setSquareBoolArray(_three.getX(), _three.getY());
	    _dp.setSquareBoolArray(_four.getX(), _four.getY());
	    _dp.stop();
	    paint();
	    _dp.checkCompleteRow();
	}

    }
    public void moveLeft(){
	if(_one.canMoveLeft() == true &&
	   _two.canMoveLeft() == true &&
	   _three.canMoveLeft() == true &&
	   _four.canMoveLeft() == true){
	    
	    _one.moveLeft();
	    _two.moveLeft();
	    _three.moveLeft();
	    _four.moveLeft();

	    paint();
	}
    }

    public void moveRight(){
	if(_one.canMoveRight() == true &&
	   _two.canMoveRight() == true &&
	   _three.canMoveRight() == true &&
	   _four.canMoveRight() == true){
	    
	    _one.moveRight();
	    _two.moveRight();
	    _three.moveRight();
	    _four.moveRight();
	    
	    paint();
	}
    }
    
    public void rotate(){
	double centerX = _two.getX()+(BOXSIZE/2);
	double centerY = _two.getY()+(BOXSIZE/2);

	if(_one.canRotate(centerX, centerY) == true &&
	   _two.canRotate(centerX, centerY) == true &&
	   _three.canRotate(centerX, centerY) == true &&
	   _four.canRotate(centerX, centerY) == true){

	    _one.rotate(centerX, centerY);
	    _two.rotate(centerX, centerY);
	    _three.rotate(centerX, centerY);
	    _four.rotate(centerX, centerY);
	}

    }	


    public void paint(){
	_dp.setPaintArray(_one.getX(), _one.getY(), _one);
	_dp.setPaintArray(_two.getX(), _two.getY(), _two);
	_dp.setPaintArray(_three.getX(), _three.getY(), _three);
	_dp.setPaintArray(_four.getX(), _four.getY(), _four);
    }

    public void setVisible(boolean bool){
	_one.setVisible(bool);
	_two.setVisible(bool);
	_three.setVisible(bool);
	_four.setVisible(bool);
    }
    public void setColor(java.awt.Color color){
	_one.setFillColor(color);
	_two.setFillColor(color);
	_three.setFillColor(color);
	_four.setFillColor(color);
    }

    public double getXLocation(){
	return _one.getX();
    }
    public double getYLocation(){
	return _one.getY();
    }
}
