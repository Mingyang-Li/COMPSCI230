class MyLine {
    private Point startPoint;
    private Point endPoint;
    //default init
    MyLine(){
        this.startPoint = new Point(0, 0);
        this.endPoint = new Point(0, 0);
    }

    //overloaded init 1
    MyLine(int a, int b, int c, int d){
        this.startPoint = new Point(a, b);
        this.endPoint = new Point(c, d);
    }
    //overloaded init 2
    MyLine(Point a, Point b){
        this.startPoint = a;
        this.endPoint = b;
    }
    public String toString(){
        int a = (int) this.startPoint.getX();
        int b = (int) this.startPoint.getY();
        int c = (int) this.endPoint.getX();
        int d = (int) this.endPoint.getY();
        return String.format("java.awt.Point[x=%d,y=%d] to java.awt.Point[x=%d,y=%d]", a, b, c, d);
    }
    //accessor for starting point
    public int getX(){
        int num = (int) Math.round(this.startPoint.getX());
        return num;
    }
    public int getY(){
        int num =(int) Math.round(this.startPoint.getY());
        return num;
    }
    //mutators for starting point 
    public void setX(int x){
        this.startPoint.move(x, (int) Math.round(this.startPoint.getY()));
    }
    public void setY(int y){
        this.startPoint.move((int) Math.round(this.startPoint.getX()), y);
    }

    //accessor for ending points
    public int getEndX(){
        int num = (int) Math.round(this.endPoint.getX());
        return num;
    }
    public int getEndY(){
        int num = (int) Math.round(this.endPoint.getY());
        return num;
    }
    //mutators for ending point 
    public void setEndX(int x){
        this.endPoint.move(x, (int) Math.round(this.endPoint.getY()));
    }
    public void setEndY(int y){
        this.endPoint.move((int) Math.round(this.endPoint.getX()), y);
    }

    //get length of a line 
    public double getLength(){
        return this.startPoint.distance(this.endPoint);
    }
}

import java.awt.Point;
import java.util.*;

class PolyLine {
    private Point endPoint;
    private ArrayList<Point> points = new ArrayList<Point>();
    //default init
    PolyLine(){  
    }
    //overloaded 1
    PolyLine(Point pt){
        this.points.add(pt);
    }
    //overloaded 2 - taking in arraylist
    PolyLine(ArrayList<Point> newPoints){
        for (Point n: newPoints){
            this.points.add(n);
        }
    }
    //overloaded 3 - taking in normal list
    PolyLine(List<Point> newPoints){ 
        for (Point n: newPoints){
            this.points.add(n);
        }
    }
    PolyLine(Point[] newPoints){
        for (Point n: newPoints){
            this.points.add(n);
        }
    }
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < this.points.size(); i++){
            int a = (int) this.points.get(i).getX();
            int b = (int) this.points.get(i).getY();
            toReturn += String.format("java.awt.Point[x=%d,y=%d]", a, b) + "\n";
        }
        return toReturn;
    }
    //Q4 
    public void appendPoint(Point p){
        this.points.add(p);
    }
    public void  appendPoint(int x, int y){
        Point newPoint = new Point(x, y);
        this.points.add(newPoint);
    }
    public void removeLastPoint(){
        this.points.remove(this.points.size()-1);
    }
    public Point getPoint(int index){
        return this.points.get(index);
    };
    // Q5
    public int getSize(){
        return this.points.size();
    }
    public double getLength(){
        double dis = 0;
        for (int i=0; i<this.points.size()-1; i++){
            dis += this.points.get(i).distance(this.points.get(i+1));
        }
        return dis;
    }
    public void join(PolyLine anotherLine){
        for (int i=0; i<anotherLine.getSize(); i++){
            this.points.add(anotherLine.getPoint(i));
        }
    }
}

// Q6 - Q7 
class MySubLine extends Point {
    private Point endPoint;
    //default init
    MySubLine(){
    	super();
    	this.endPoint = new Point(0, 0);
    }
    //overloaded - takes 4 int
    MySubLine(int a, int b, int c, int d){
        super(a, b);
        this.endPoint = new Point(c, d);
    }
    //overloaded - takes 2 point obj
    MySubLine(Point a, Point b){
        super(a);
        this.endPoint = b;
    }
    public String toString(){
        return String.format("%s to %s", super.toString(), endPoint);
    }
    int getEndX() {
    	int n = (int) Math.round(this.endPoint.getX());
    	return n;
    }
    int getEndY() {
    	int n = (int) Math.round(this.endPoint.getY());
    	return n;
    }
    void setEndLocation(int x, int y) {
    	this.endPoint = new Point(x, y);
    }
    double getLength() {
    	return super.distance(endPoint);
    }
}

// Q9 - Q10
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
        this.base = newBase;
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
    
}
    

// Q13 - Q14
class MyCubeSub extends MySquare2D {
	//default 
	MyCubeSub(){
		super();
	}
	//overloaded 1
	MyCubeSub(Point point){
		super(point);
	}
//	/overloaded 2
	MyCubeSub(int sideLength){
        super(sideLength);
    }
    //overloaded 3
	MyCubeSub(Point point, int sideLength){
        super(point, sideLength);
    }
    //overloaded 4
	MyCubeSub(int x, int y, int sideLength){
        super(x, y, sideLength);
    }
	//overloaded 4
	MyCubeSub(MySquare2D mySquare){
        super(mySquare.getTopLeft(), mySquare.getSideLength());
    }	
	public String toString(){
        return "MyCube: " + super.toString();
    }
    public int getVolume(){
        int res = (int) Math.round(Math.pow(super.getSideLength(), 3));
        return res;
    }
    public int getSurfaceArea(){
        return super.getSideLength() * super.getSideLength() * 6;
    }
}
    

