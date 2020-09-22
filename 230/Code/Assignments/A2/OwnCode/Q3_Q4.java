class DynamicRectangleShape extends RectangleShape{
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super( x, y, deltaX, deltaY, width, height);
        @Override void paint(Painter painter){
            super.setColor(Color Color.red);
        }
    }

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        super( x, y, deltaX, deltaY, width, height);
        @Override void paint(Painter painter){
            super.setColor(Color color);
        }
    }

    @Override move(int width, int height){
        super.move(width, height);
    }

}