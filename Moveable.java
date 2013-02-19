package Tetris;

public interface Moveable{
    public double getYLocation();
    public double getXLocation();
    //public void setLocation(double x, double y);
    public void moveDown();
    public void moveRight();
    public void moveLeft();
    public void setColor(java.awt.Color color);
    public void setVisible(boolean bool);
    public void paint();
    public void rotate();
}
