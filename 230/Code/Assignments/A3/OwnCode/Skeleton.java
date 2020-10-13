public NestingShape();

public NestingShape (int x, int y);

public NestingShape (int x, int y, int deltaX, int deltaY);

public NestingShape (int x, int y, int deltaX, int deltaY, int width, int height);

public void move (int width, int height);

public void paint (Painter painter);

void add (Shape shape) throws IllegalArgumentException;

void remove (Shape shape);

public Shape shapeAt (int index) throws IndexOutOfBoundsException;

public int shapeCount ();

public int indexOf (Shape shape);

public boolean contains (Shape shape);