import java.awt.Color;
import java.util.*;

abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	
	protected static final int DEFAULT_Y_POS = 0;
	
	protected static final int DEFAULT_DELTA_X = 5;
	
	protected static final int DEFAULT_DELTA_Y = 5;
	
	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;
	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;

	protected Color _color;
  
	protected boolean _bounceX;
	
	protected NestingShape _parent = null;
	
	protected String _text = null;


	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
	}
	
	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width width of two-dimensional world.
	 * @param height height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
		}

		_x = nextX;
		_y = nextY;
	}

	public abstract void paint(Painter painter);

	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return _x;
	}
	
	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return _y;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}
	
	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return _width;
	}
	
	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return _height;
	}
	
	public NestingShape parent() {
        return _parent;
    }

	protected void setParent(NestingShape parent);
	
	@Override
	public String toString() {
		return getClass().getName();
	}

    public List<Shape> path() {
		boolean root = false;
		List<Shape> list, rootList = null;
		list = new ArrayList<Shape>();
		list.add(this);
	
		if (this._parent != null){
			rootList = this._parent.path();
			root = rootList.addAll(list);
		}
	
		if (root){
			return rootList;
		}
		return list;
	}

	public Object text() {
		return _text;
	}
}

public class NestingShape extends Shape{
    
    private ArrayList<Shape> innerShapes;

    public NestingShape() {
        super();
        innerShapes = new ArrayList<Shape>();
    }

    public NestingShape( int x , int y){
        super(x, y);
        innerShapes = new ArrayList<Shape>();
    }
    
    public NestingShape( int x , int y , int deltaX , int deltaY ) {
        super(x, y, deltaX, deltaY);
        innerShapes = new ArrayList<Shape>();
    }

    public void move( int width , int height ) {
        super.move(width, height);
        for (Shape myShape : innerShapes ) {
            myShape.move(_width, _height);
        }
    }

    public void doPaint(Painter painter) {
        painter.drawRect(_x, _y, _width, _height);
        painter.translate(_x, _y);
        for (Shape myShape : innerShapes) {
            myShape.paint(painter);
        }
        painter.translate(-_x, -_y);
    }

    void add(Shape shape) throws IllegalArgumentException {
        if (shape._parent != null) {
            throw new IllegalArgumentException();
        }

        if (
            (shape._width + shape._x > this._width + this._x) || 
            (shape._height + shape._x > this._height + this._y)
            ) { 
            throw new IllegalArgumentException();
        }
        shape._parent = this;
        innerShapes.add(shape);
    }

    void remove(Shape shape){
        for(Shape s : innerShapes){
            if (s == shape){
                innerShapes.remove(shape);
                shape._parent = null;
                return;
            }
        }
        return;
    }

    public Shape shapeAt( int index) throws IndexOutOfBoundsException {
        return innerShapes.get(index);
    }

    public int shapeCount() {
        return innerShapes.size();
    }

    public int indexOf(Shape shape){
        return innerShapes.indexOf(shape);
    }
    
    public boolean contains(Shape shape) {
        for(Shape s : innerShapes) {
            if (s == shape) {
                return true;
            }
        }
        return false;
    }

    public NestingShape parent (){
        if (this._parent == null) {
            return null;
        }
        return this._parent;
    }

    public List <Shape> path (){
        return super.path();
    }
}
