import java.awt.Color;

class DynamicRectangleShape extends RectangleShape {
    private Color color;
    private Boolean filled = true;
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super(x, y, deltaX, deltaY, width, height);
        this.color = Color.RED; 
    }

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        super(x, y, deltaX, deltaY, width, height);
        this.color = color; 
    }

    @Override
    public void move(int width, int height) {
        super.move(width, height);
        if (_y + this.height() == height || _y <= 0) {
            filled = false;
        }
        if (_x <= 0 || _x + this.width() >= width) {
            filled = true;
        }
    }

    @Override 
    public void paint(Painter painter){
        if (filled) {
            painter.setColor(this.color);
            painter.fillRect(_x, _y, _width, _height);
            painter.setColor(Color.BLACK);
        } else {
            // paint the shape anyway regardless color
            painter.drawRect(_x, _y, _width, _height);
        }   
    }
}import java.awt.Color;

class DynamicRectangleShape extends RectangleShape {
    private Color color;
    private Boolean filled = true;
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super(x, y, deltaX, deltaY, width, height);
        this.color = Color.RED; 
    }

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        super(x, y, deltaX, deltaY, width, height);
        this.color = color; 
    }

    @Override
    public void move(int width, int height) {
        super.move(width, height);
        if (_y + this.height() == height || _y <= 0) {
            filled = false;
        }
        if (_x <= 0 || _x + this.width() >= width) {
            filled = true;
        }
    }

    @Override 
    public void paint(Painter painter){
        if (filled) {
            painter.setColor(this.color);
            painter.fillRect(_x, _y, _width, _height);
            painter.setColor(Color.BLACK);
        } else {
            // paint the shape anyway regardless color
            painter.drawRect(_x, _y, _width, _height);
        }   
    }
}
