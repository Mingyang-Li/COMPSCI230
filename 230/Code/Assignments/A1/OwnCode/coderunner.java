class MovingRectangle extends MovingShape{
    //dafault
    MovingRectangle(){
        super.width = 100;
        super.height = 50;
        super.fillColor = Color.green;
        super.borderColor = Color.yellow;
        //
    }
    //overloaded 1
    MovingRectangle(int m){
        super(m);
        //
    }
    //overloaded 2
    MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType){
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }
    @Override
    public void draw(Graphics g){
        //placeholder
    }
    @Override
    public double getArea(){
        return super.width * super.height;
    }
    @Override 
    public boolean contains(Point mousePt){
        if (mousePt.getX() == mousePt.getY()){
            return false;
        }
        return true;
    }

}

class MovingSquare extends MovingRectangle{
    //dafault
    MovingSquare(){
        super.x = 0;
        super.y =0;
        super.width = 50;
        super.height = 50;
        super.fillColor = Color.green;
        super.borderColor = Color.yellow;
        //
    }
    //overloaded 1
    MovingSquare(int m){
        super(m);
    }
    //overloaded 2        
    MovingSquare(int x, int y, int wh, int mw, int mh, Color bc, Color fc, int pathType){
        super.x = x;
        super.y = y;    
        super.width = wh;
        super.height = wh;
        super.fillColor = Color.green;
        super.borderColor = Color.yellow;
        super.marginWidth = mw;
        super.marginHeight = mh;
    }
    @Override
    public void setWidth(int w){
        super.setWidth(w); 
        super.setHeight(w);
    }
    @Override
    public void setHeight(int h){
        super.setHeight(h); 
        super.setWidth(h); 
    }
}

class MovingEllipse extends MovingShape{
    //dafault
    MovingEllipse(){
        super.x = 0;
        super.y =0;
        super.width = 100;
        super.height = 50;
        super.fillColor = Color.green;
        super.borderColor = Color.yellow;
        //
    }
    //overloaded 1
    MovingEllipse(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType){
        super.x = x;
        super.y = y;    
        super.width = w;
        super.height = h;
        super.marginWidth = mw;
        super.marginHeight = mh;
        super.fillColor = fc;
        super.borderColor = bc;
    }
    //overloaded 2    
    MovingEllipse(int m){
        super();
        super.width = m;
        super.height = m;
    }    
    
    public double getArea(){
        return Math.PI * (this.width / 2) * (this.height / 2);
    }
    
    public boolean contains(Point mousePt){
        double dx, dy;
        Point EndPt = new Point(x + width, y + height);
        dx = (2 * mousePt.x - x - EndPt.x) / (double) width;
        dy = (2 * mousePt.y - y - EndPt.y) / (double) height;
        return dx * dx + dy * dy < 1.0;
    }
    public void draw(Graphics g){
        //placeholder;
    }
}

class MovingPyramid extends MovingRectangle{
    private int xSize;
    private int ySize;
    public static int NUMBER_OF_ROWS = 5;
    //dafault
    MovingPyramid(){
        super.x = 0;
        super.y =0;
        super.width = 100;
        super.height = 50;
        super.fillColor = Color.green;
        super.borderColor = Color.yellow;
    }
    //overloaded 1
    MovingPyramid(int n){
        super.x = 0;
        super.y =0;
        super.height = n;
        super.width = n;
        super.fillColor = Color.green;
        super.borderColor = Color.yellow;
    }
    //overloaded 2
    MovingPyramid(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType){
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }
     
    public void draw(){
        //placeholder
    }
    public int getXSize(){
        return super.width / 9;
    }
    public int getYSize(){
        return super.height / 5;
    }
    public void setUp() {

    }
    @Override
    public void setWidth(int w) {
        if (w > 0){
            super.width = w;
        }
    }
    @Override
    public void setHeight(int h) {
        if (h > 0){
            super.height = h;
        }
    }
}

class MovingOverlappedSquare extends MovingRectangle{
    private boolean isOverlapped;
    private Random rand;
    private Rectangle square1;
    private Rectangle square2;
    public static int SIZE = 30;
    //default 
    MovingOverlappedSquare(Random obj){
        super.x = 0;
        super.y =0;
        super.width = 100;
        super.height = 50;
        super.fillColor = Color.green;
        super.borderColor = Color.yellow;
        this.rand = obj;
    }
    //overloaded 1
    MovingOverlappedSquare(int n, Random obj){
        super.x = 0;
        super.y =0;
        super.height = n;
        super.width = n;
        super.fillColor = Color.green;
        super.borderColor = Color.yellow;
        this.rand = obj;
    }
    //overloaded 2
    MovingOverlappedSquare(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType, Random obj){
        super.x = x;
        super.y = y;    
        super.width = w;
        super.height = h;
        super.marginWidth = mw;
        super.marginHeight = mh;
        super.fillColor = fc;
        super.borderColor = bc;
        this.rand = obj;
    }
    public boolean isRandomReady(){
        if (this.rand != null){
            return true;
        }
        return false;
    }
    public void draw(Graphics g){
        //placeholder;
    }
}