import java.util.*;

public class NestingShape extends Shape{
    private ArrayList <Shape> innerShapes;
    public NestingShape(){
        super(Shape.DEFAULT_X_POS, Shape.DEFAULT_Y_POS);
    }
    
    public NestingShape (int x, int y){
        super(x, y, Shape.DEFAULT_X_POS, Shape.DEFAULT_Y_POS);
    }
    
    public NestingShape (int x, int y, int deltaX, int deltaY){
        super(x, y, deltaX, deltaY, Shape.DEFAULT_WIDTH, Shape.DEFAULT_HEIGHT);
    }
    
    public void move (int width, int height){
        for(Shape s : innerShapes){	
			s.move(fWidth, fHeight);
		}
		super.move(width, height);
    }
    
    @Override
    public void paint (Painter painter){
        painter.drawRect(fX, fY, fWidth, fHeight);
		painter.translate(fX,fY);
		for(Shape s : innerShapes){
			s.paint(painter);
		}
		painter.translate(-fX,-fY);
    }
    
    void add (Shape shape){
        int innerShapeWidth = shape.fWidth + shape.fX;
		int innerShapeWidthXPosition = shape.fWidth;
		int innerShapeWidthYPosition = shape.fHeight;
		int innerShapeHeight = shape.fHeight + shape.fY;
		try {	
			this.innerShapes.add(shape);
			shape.fParent = this;
            if(innerShapeWidthXPosition > this.fWidth && innerShapeWidthYPosition > this.fHeight){	
				throw new IllegalArgumentException();
			}
			if(innerShapeHeight > this.fHeight && innerShapeWidth > this.fWidth){	
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
    
    public Shape shapeAt (int index){
        return innerShapes.get(index);
    }
    
    public int shapeCount (){
        return innerShapes.size();
    }
    
    public int indexOf (Shape shape){
        return innerShapes.indexOf(shape);
    }
    
    public boolean contains (Shape shape){
        for(Shape s : innerShapes){
			if(s.equals(shape)){
				return true;
			}
		}
		return false;
    }
}

