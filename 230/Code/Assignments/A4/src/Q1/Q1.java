import javax.swing.event.TreeModelListener;
import javax.swing.tree.*;

public class TreeModelAdapter implements TreeModel{
    public ShapeModel _adaptee;
    public TreeModelAdapter(ShapeModel shape) {
        _adaptee = shape;
    }

    @Override
    public Object getRoot() {
        return _adaptee.root();
    }

    @Override
    public Object getChild(Object parent, int index) {
        Object r = null;
        if (parent instanceof NestingShape) {
            NestingShape res = (NestingShape) parent;
            if(index >= 0 && index < this.getChildCount(res)){
                r = res.shapeAt(index);
            }
        }
        return r;
    }

    @Override
    public int getChildCount(Object parent) {
        int r = 0;
        if(parent instanceof NestingShape){
            NestingShape res = (NestingShape) parent;
            r = res.shapeCount();
        }
        return r;
    }


    @Override
    public boolean isLeaf(Object node) {
        return !(node instanceof NestingShape);
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {}

    @Override
    public int getIndexOfChild(Object parentClass, Object subClass) {
        int indexOfChild = -1;
        if (parentClass instanceof NestingShape && subClass instanceof Shape) {
            NestingShape res = (NestingShape) parentClass;
            indexOfChild = res.indexOf( (Shape) subClass );
        }
        return indexOfChild;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l){}

    @Override
    public void removeTreeModelListener(TreeModelListener l){}
}
