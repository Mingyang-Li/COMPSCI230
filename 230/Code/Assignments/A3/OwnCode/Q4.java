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

    // default init 
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

    // init with 2 params
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

    // init with 4 params 
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

    // init with 4 params plus text 
    public Shape(int x, int y, int deltaX, int deltaY, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
        _text = text;
	}

    // init with 6 params 
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
	}

    // init with 6 params plus text 
    public Shape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
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

	public void paint(Painter painter) {
        doPaint(painter);
        if (_text != null) {
            painter.drawCenteredText(_text, _x + _width / 2, _y + _height / 2);
        }
    }

    protected abstract void doPaint(Painter painter);

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

public class RectangleShape extends Shape {
	public RectangleShape() {
		super();
	}

	public RectangleShape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public RectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	public RectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

    // new init: 6 params + text and color 
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color color) {
        super(x, y, deltaX, deltaY, width, height);
        _color = color; 
        _text = text;
    }

	protected void doPaint(Painter painter){
		painter.drawCenteredText(_x, _y, _width, _height);
	}
}


