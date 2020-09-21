class OvalShape extends Shape {
    	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public OvalShape() {
		super(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public OvalShape(int x, int y) {
		super(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super( x, y, deltaX, deltaY, width, height);
	}
    @Override
    public void paint(Painter painter){
		painter.drawOval(super.x(), super.y(), super.width(), super.height());
    }
}