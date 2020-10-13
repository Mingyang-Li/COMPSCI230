import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    // === Constants for default values. ===
    protected static final int DEFAULT_X_POS = 0;

    protected static final int DEFAULT_Y_POS = 0;

    protected static final int DEFAULT_DELTA_X = 5;

    protected static final int DEFAULT_DELTA_Y = 5;

    protected static final int DEFAULT_HEIGHT = 35;

    protected static final int DEFAULT_WIDTH = 25;

    protected static final Color DEFAULT_COLOR = Color.BLACK;

    protected static final String DEFAULT_TEXT = null;


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

	public Shape() {
        this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR, DEFAULT_TEXT);
    }

    public Shape(int x, int y) {
        this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR, DEFAULT_TEXT);
    }

    public Shape(int x, int y, int deltaX, int deltaY) {
        this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR, DEFAULT_TEXT);
    }

    public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
        this(x, y, deltaX, deltaY, width, height, DEFAULT_COLOR, DEFAULT_TEXT);
    }

    public Shape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        this(x, y, deltaX, deltaY, width, height, color, DEFAULT_TEXT);
    }

    public Shape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
        this(x, y, deltaX, deltaY, width, height, DEFAULT_COLOR, text);
    }

    public Shape(String text) {
        this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR, text);
    }

    public Shape(Color color) {
        this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, color, DEFAULT_TEXT);
    }

    public Shape(int x, int y, Color color) {
        this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, color, DEFAULT_TEXT);
    }

    public Shape(int x, int y, int deltaX, int deltaY, Color color) {
        this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, color, DEFAULT_TEXT);
    }

    public Shape(int x, int y, int deltaX, int deltaY, int width, int height, Color color, String text) {
        _x = x;
        _y = y;
        _deltaX = deltaX;
        _deltaY = deltaY;
        _width = width;
        _height = height;
        _color = color;
        _text = text;
    }
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

    public int x() {
        return _x;
    }

	public int y() {
		return _y;
	}

	public int deltaX() {
		return _deltaX;
	}
	
	public int deltaY() {
		return _deltaY;
	}

	public int width() {
		return _width;
	}

	public int height() {
		return _height;
	}

    public NestingShape parent() {
        return _parent;
    }

	@Override
	public String toString() {
		return getClass().getName();
	}

    public List <Shape> path() {
        boolean start = false;
        List <Shape> startList = null;
        List <Shape> list;
        list = new ArrayList <Shape> ();
        list.add(this);

        if (this._parent != null) {
            startList = this._parent.path();
            start = startList.addAll(list);
        }

        if (start) {
            return startList;
        }
        return list;
    }

    public Object text() {
        return _text;
    }
}
class NestingShape extends Shape {
    private ArrayList <Shape> innerShapes;
    
    public NestingShape() {
        super();
        innerShapes = new ArrayList <Shape> ();
    }

    public NestingShape(int x, int y) {
        super(x, y);
        innerShapes = new ArrayList <Shape> ();
    }

    public NestingShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
        innerShapes = new ArrayList <Shape> ();
    }

    public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
        innerShapes = new ArrayList <Shape> ();
    }

    public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
        super(x, y, deltaX, deltaY, width, height, text);
        innerShapes = new ArrayList <Shape> ();
    }

    @Override
    public void move(int width, int height) {
        super.move(width, height);
        for (Shape nS: innerShapes) {
            nS.move(_width, _height);
        }
    }

    @Override
    public void paint(Painter painter) {
        painter.drawRect(_x, _y, _width, _height);
        painter.translate(_x, _y);
        for (Shape nS: innerShapes) {
            nS.paint(painter);
        }
        painter.translate(-_x, -_y);
    }

    void add(Shape shape) throws IllegalArgumentException {
        if (shape._parent != null) {
            throw new IllegalArgumentException();
        }
        if (
            (shape._height + shape._x > this._height + this._y)
                || 
            (shape._width + shape._x > this._width + this._x) 
            ) { 
            throw new IllegalArgumentException();
        }
        shape._parent = this;
        innerShapes.add(shape);
    }

    void remove(Shape shape) {
        for (Shape s: innerShapes) {
            if (s == shape) {
                innerShapes.remove(shape);
                shape._parent = null;
                return;
            }
        }
        return;
    }

    public Shape shapeAt(int index) throws IndexOutOfBoundsException {
        return innerShapes.get(index);
    }

    public int shapeCount() {
        return innerShapes.size();
    }

    public int indexOf(Shape shape) {
        return innerShapes.indexOf(shape);
    }

    public boolean contains(Shape shape) {
        for (Shape s: innerShapes) {
            if (s == shape) {
                return true;
            }
        }
        return false;
    }
}