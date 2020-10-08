/**
 * Creates a NestingShape object with default values.
 */

public class NestingShape extends Shape{
    public ArrayList<Shape> innerShapes;

    public NestingShape(){
        super(Shape.DEFAULT_X_POS, Shape.DEFAULT_Y_POS, Shape.DEFAULT_DELTA_X, Shape.DEFAULT_DELTA_Y, Shape.DEFAULT_WIDTH, Shape.DEFAULT_HEIGHT);
        innerShapes = new ArrayList<Shape>();
    }
    
    public NestingShape (int x, int y){
        super(x, y, Shape.DEFAULT_X_POS, Shape.DEFAULT_Y_POS, Shape.DEFAULT_WIDTH, Shape.DEFAULT_HEIGHT);
        innerShapes = new ArrayList<Shape>();
    }
    
    public NestingShape (int x, int y, int deltaX, int deltaY){
        super(x, y, deltaX, deltaY, Shape.DEFAULT_WIDTH, Shape.DEFAULT_HEIGHT);
        innerShapes = new ArrayList<Shape>();
    }
    
    public void move (int width, int height){
        for(Shape s : innerShapes){	
			s.move(_width, _height);
		}
		super.move(width, height);
    }
    
    @Override
    public void paint (Painter painter){
        painter.drawRect(_x, _y, _width, _height);
		painter.translate(_x, _y);
		for(Shape s : innerShapes){
			s.paint(painter);
		}
		painter.translate(-_x, -_y);
    }
    
    void add (Shape shape){
        int innerShapeWidth = shape._width + shape._x;
		int innerShapeWidthXPosition = shape._width;
		int innerShapeWidthYPosition = shape._height;
		int innerShapeHeight = shape._height + shape._y;
		try {	
			this.innerShapes.add(shape);
			shape.fParent = this;
			if(
                (innerShapeHeight > this._height && innerShapeWidth > this._width) || 
                (innerShapeWidthXPosition >this._width && innerShapeWidthYPosition > this._height)
            ){	
                throw new IllegalArgumentException();			
			}
		} catch (IllegalArgumentException e){
			this.innerShapes.contains(shape);
		}
    }
    
    void remove (Shape shape){
        try {
			this.innerShapes.remove(shape);
			shape.fParent = null;
		
		} catch (IllegalArgumentException e){
			this.innerShapes.contains(shape);
		}
    }
    
    Shape shapeAt (int index){
        return innerShapes.get(index);
    }
    
    int shapeCount (){
        return innerShapes.size();
    }
    
    int indexOf (Shape shape){
        return innerShapes.indexOf(shape);
    }
    
    boolean contains (Shape shape){
        for(Shape s : innerShapes){
			if(s.equals(shape)){
				return true;
			}
		}
		return false;
    }
}

