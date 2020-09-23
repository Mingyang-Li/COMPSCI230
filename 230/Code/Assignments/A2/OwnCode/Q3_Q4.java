class DynamicRectangleShape extends RectangleShape {
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super(x, y, deltaX, deltaY, width, height);
    }

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        super(x, y, deltaX, deltaY, width, height);
    }
    @Override public void paint(Painter painter){
        super.paint(painter);
    }

    @Override public void move(int width, int height){
        super.move(super.width(), super.height());
    }
}

