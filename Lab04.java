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