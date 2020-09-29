import java.awt.Color;

class DynamicRectangleShape extends RectangleShape {
    private Color color;
    private Boolean bounced;
    private String side;
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super(x, y, deltaX, deltaY, width, height);
        this.color = Color.red; 
    }

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        super(x, y, deltaX, deltaY, width, height);
        this.color = color; // not sure if I'm assigning color correctly
    }
    @Override public void move(int width, int height){
        super.move(width, height);
        if (_x == 0){
            side = "horizontal";
        } 
        if (_y == 0){
            side = "vertical";
        } 
        // top left 
        if (_x == 0 && _y == 0){
            side = "vertical";
        } 
        // top right 
        if (_x == _width && _y == 0){
            side = "vertical";
        } 
        // bottom left 
        if (_x == 0 && _y == _height){
            side = "vertical";
        } 
        // bottom right 
        if (_x == _width && _y == _height){
            side = "vertical";
        } 
    }
    @Override 
    public void paint(Painter painter){
        if (this.side == "horizontal"){
            // paint itself as a solid shape
            painter.fillRect(_x, _y, _width, _height);
        } else {
            // dont paint, use superclass paint 
            super.paint(painter);
        }
    }
}
