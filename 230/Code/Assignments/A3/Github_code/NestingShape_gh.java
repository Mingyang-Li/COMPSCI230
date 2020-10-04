// https://github.com/arch2603/Bounce/blob/5260f5c20b8301b5042eb94c33f508686bbbb943/src/NestingShape.java


import java.util.ArrayList;

public class NestingShape extends Shape{
	
	public ArrayList<Shape> innerShapes;
	
	public NestingShape(){
		this(Shape.DEFAULT_X_POS,Shape.DEFAULT_Y_POS);
	}
	
	public NestingShape(int x, int y){

		this(x, y, Shape.DEFAULT_DELTA_X,Shape.DEFAULT_DELTA_Y);
	}
	

	public NestingShape(int x, int y, int deltaX, int deltaY){

		this(x, y, deltaX, deltaY, Shape.DEFAULT_WIDTH, Shape.DEFAULT_HEIGHT);
	}	
	
	public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height){
		
		//Initiliase innershapes
		super(x,y,deltaX,deltaY,width, height);
		
		innerShapes = new ArrayList<Shape>();
		
	}
	public void move (int width, int height){
		
		for(Shape s : innerShapes){
			
			s.move(fWidth, fHeight);
		}
		
		super.move(width, height);
		
		// tell innerShape to move within this NestingShape's boundaries
	}
	
	
	public void add(Shape shape){
		
		int innerShapeWidth = shape.fWidth + shape.fX;
		int innerShapeWidthXPosition = shape.fWidth;
		int innerShapeWidthYPosition = shape.fHeight;
		int innerShapeHeight = shape.fHeight + shape.fY;
		
		try{
			
			this.innerShapes.add(shape);
			shape.fParent = this;
			
			if( innerShapeWidth > this.fWidth && innerShapeHeight > this.fHeight){
				
				throw new IllegalArgumentException();
				
			}
			
			if(innerShapeWidthXPosition >this.fWidth && innerShapeWidthYPosition > this.fHeight){
				
				throw new IllegalArgumentException();
			}
			
			
		
		}catch(IllegalArgumentException e){
			
			this.innerShapes.contains(shape);
		}
	}
	
	void remove(Shape shape){
		try{
			
			this.innerShapes.remove(shape);
			shape.fParent = null;
		
		}catch(IllegalArgumentException e){
			
			this.innerShapes.contains(shape);
		}
	}
	
	public Shape shapeAt(int index){
		
		return innerShapes.get(index);
				
	}
	
	public int Count(){
		return innerShapes.size();
		
	}
	
	public int indexOfShape(Shape shape){
		return innerShapes.indexOf(shape);
		
	}
	
	public boolean contains(Shape shape){
		
		for(Shape s : innerShapes){
			
			if(s.equals(shape)){
				
				return true;
			}
		}
		
		return false;
		
	}
	
	@Override
	protected void doPaint(Painter painter) {
		// Draw out the out Nesting Shape
		
		painter.drawRect(fX, fY, fWidth, fHeight);
		
		//Start translation from drawRect topleft position
		
		painter.translate(fX,fY);

		// Draw children-the inner shapes
		for(Shape s : innerShapes){
			
			s.paint(painter);
		}
		
		// Translate back
		
		painter.translate(-fX,-fY);
		
	}
}