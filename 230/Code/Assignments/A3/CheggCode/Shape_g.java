import java.awt.*;

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

    // Instance variables, accessible by subclasses.
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

    public Shape(String text) {
        this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR, text);
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

        if (nextY <= 0) {
            nextY = 0;
            _deltaY = -_deltaY;
            _bounceX = false;
        } else if (nextY + _height >= height) {
            nextY = height - _height;
            _deltaY = -_deltaY;
            _bounceX = false;
        }

        if (nextX <= 0) {
            nextX = 0;
            _deltaX = -_deltaX;
            _bounceX = true;
        } else if (nextX + _width >= width) {
            nextX = width - _width;
            _deltaX = -_deltaX;
            _bounceX = true;
        }

        _x = nextX;
        _y = nextY;
    }

    public final void paint(Painter painter) {
        doPaint(painter);
        if (_text != null) {
            painter.drawCentredText(_text, _x + _width / 2, _y + _height / 2);
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

    public NestingShape parent() {
        return _parent;
    }

    public String toString() {
        return getClass().getName();
    }

    public List <Shape> path() {
        boolean root = false;
        List <Shape> list;
        List <Shape> rootList = null;
        list = new ArrayList <Shape> ();
        list.add(this);

        if (this._parent != null) {
            rootList = this._parent.path();
            root = rootList.addAll(list);
        }

        if (root) {
            return rootList;
        }
        return list;
    }

    public Object text() {
        return _text;
    }
}