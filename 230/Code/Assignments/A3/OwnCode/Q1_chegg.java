// https://www.chegg.com/homework-help/questions-and-answers/shapejava-abstract-superclass-represent-general-concept-shape-class-defines-state-common-s-q51248582

import java.util.ArrayList;
import java.util.List;

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
    
    public NestingShape( int x , int y , int deltaX , int deltaY ,int width , int height) {
        super(x, y, deltaX, deltaY, width, height);
        innerShapes = new ArrayList<Shape>();
    }
    
    public NestingShape( int x , int y , int deltaX , int deltaY ,int width , int height, String text ) {
        super(x, y, deltaX, deltaY, width, height, text);
        innerShapes = new ArrayList<Shape>();
    }

    public void move( int width , int height ) {
        super.move(width, height);
        for (Shape nS : innerShapes ) {
            nS.move(_width, _height);
        }
    }

    public void doPaint(Painter painter) {
        painter.drawRect(_x, _y, _width, _height);
        painter.translate(_x, _y);
        for (Shape nS : innerShapes) {
            nS.paint(painter);
        }
        painter.translate(-_x, -_y);
    }

    void add(Shape shape) throws IllegalArgumentException {
        if (shape._parent != null) {
            throw new IllegalArgumentException();
        }

        if ((shape._width + shape._x > this._width + this._x) || (shape._height + shape._x > this._height + this._y)){ // logic might need more
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