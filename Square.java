package Tetris;

public class Square extends gfx.Rectangle implements SquareConstants{
    
    private DrawingPanel _dp;

    public Square(DrawingPanel dp){
	super(dp);
	_dp = dp;
	this.setSize(DRAWSIZE, DRAWSIZE);
	this.setBorderColor(java.awt.Color.black);
	this.setVisible(true);
    }
    public boolean canMoveDown(){
	int x = (int)getX()/(int)BOXSIZE;
	int y = (int)getY()/(int)BOXSIZE;
	if(_dp.getSquareBoolArray(x,y+1) == true)
	    return false;
	else
	    return true;
    }
    public void moveDown(){
	setLocation(getX(), getY()+BOXSIZE);
    }
    public boolean canRotate(double centerX, double centerY){
	if(_dp.getSquareBoolArray((int)(centerX-centerY+getY())/(int)BOXSIZE
				  ,(int)( centerX+centerY-getX())/(int)BOXSIZE) == true)
	   return false;
	else
	    return true;
    }
    public void rotate(double centerX, double centerY){
	setLocation(centerX-centerY+getY(), centerX+centerY-getX()-BOXSIZE);
    }


    public boolean canMoveLeft(){
	int x = (int)getX()/(int)BOXSIZE;
	int y = (int)getY()/(int)BOXSIZE;
	if(_dp.getSquareBoolArray(x-1, y) == true)
	    return false;
	else
	    return true;
    }
    public void moveLeft(){
	setLocation(getX()-BOXSIZE, getY());
    }

    public boolean canMoveRight(){
	int x = (int)getX()/(int)BOXSIZE;
	int y = (int)getY()/(int)BOXSIZE;
	if(_dp.getSquareBoolArray(x+1, y) == true)
	    return false;
	else
	    return true;
    }
    public void moveRight(){
	setLocation(getX()+BOXSIZE, getY());
    }
}
