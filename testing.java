import java.awt.Point;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		MySquare2D b1 = new MySquare2D(10,15, 25);
		MyCube c1 = new MyCube(b1);
		b1.setSideLength(5);
		System.out.println(c1);
		System.out.printf("volume=%d\n", c1.getVolume());
		System.out.printf("surface area=%d\n", c1.getSurfaceArea());

	}
}

class MySquare2D {
    protected Point topLeft;
    protected int sideLength;
    //default init
    MySquare2D(){
        this.topLeft = new Point(0, 0);
        this.sideLength = 10;
    }
    //overloaded 1
    MySquare2D(Point point){
        this.topLeft = point;
        this.sideLength = 10;
    }
    //overloaded 2
    MySquare2D(int sideLength){
        this.topLeft = new Point(0, 0);
        this.sideLength = sideLength;
    }
    //overloaded 3
    MySquare2D(Point point, int sideLength){
        this.topLeft = point;
        this.sideLength = sideLength;
    }
    //overloaded 4
    MySquare2D(int x, int y, int sideLength){
        this.topLeft = new Point(x, y);
        this.sideLength = sideLength;
    }
    public String toString(){
        int x = (int) Math.round(this.topLeft.getX());
        int y = (int) Math.round(this.topLeft.getY());
        return String.format("MySquare2D:(%d, %d), side=%d", x, y, this.sideLength);
    }
    //accessors
    public String getTopLeft(){
        int x = (int) Math.round(this.topLeft.getX());
        int y = (int) Math.round(this.topLeft.getY());
        return String.format("java.awt.Point[x=%d,y=%d]", x, y); 
    }
    public int getSideLength(){
        return this.sideLength;
    }
    //mutators
    public void setTopLeft(Point p){
        if (p.getX() >= 0){
            this.topLeft.setLocation(p.getX(), this.topLeft.getY());
        } 
        if (p.getY() >= 0){
            this.topLeft.setLocation(this.topLeft.getX(), p.getY());
        }
    }
    public void setTopLeft(int x, int y) {
        if (x >= 0 && y >= 0){
            this.topLeft = new Point(x, y);
        } 
        else if (x >= 0 && y <0){
            int original = (int) Math.round(this.topLeft.getY());
            this.topLeft = new Point(x, original);
        }
        else if (x < 0 && y >= 0){
            int original = (int) Math.round(this.topLeft.getX());
            this.topLeft = new Point(original, y);
        }
    }
    public void setSideLength(int s){
        if (s > 0){
            this.sideLength = s;
        }
    }
    //area
    public int getArea(){
        return this.sideLength * this.sideLength;
    }
    public int getPerimeter(){
        return this.sideLength * 4;
    }
    public boolean equals(MySquare2D another){
    if ((another instanceof MySquare2D) == false ){
        return false;
    }
    if (this.topLeft.equals(another)){
        return true;
    } else if (this.sideLength == another.getSideLength()){
        return true;
    }
    return false;
    }
}

//Q11-12
class MyCube{
    private MySquare2D base;
    //default init 
    MyCube(){
        this.base = new MySquare2D(new Point(0, 0), 10);
    }
    //overloaded 1
    MyCube(int sideLength){
        this.base = new MySquare2D(new Point(0, 0), sideLength);
    }
    //overloaded 2
    MyCube(Point point){
        this.base = new MySquare2D(point, 10);
    }
    //overloaded 3
    MyCube(Point point, int sideLength){
        this.base = new MySquare2D(point, sideLength);
    }
    //overloaded 4
    MyCube(int x, int y, int sideLength){
        this.base = new MySquare2D(x, y, sideLength);
    }
    //overloaded 5
    MyCube(MySquare2D newBase){
        this.base = new MySquare2D(new Point(0, 0), newBase.getSideLength());
    }
    public String toString(){
        return "MyCube: " + this.base.toString();
    }
    public int getVolume(){
        int res = (int) Math.round(Math.pow(this.base.getSideLength(), 3));
        return res;
    }
    public int getSurfaceArea(){
        return this.base.getSideLength() * this.base.getSideLength() * 6;
    }
    public MySquare2D getBase(){
        return this.base;
    }
    public void setSideLength(int sideLength){
    	this.base = new MySquare2D(this.base.topLeft, sideLength);
    	/*  i also tried this but still, no idea why this.base is not connecting to the MySquare2D which has already been initialised
    	Point currPoint = this.base.topLeft;
    	this.base = new MySquare2D(currPoint, sideLength);
    	*/
        
    }
}
    

    


