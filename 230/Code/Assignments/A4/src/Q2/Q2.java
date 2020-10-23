import javax.swing.*;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import java.util.ArrayList;
import java.util.List;

class TreeModelAdapterWithShapeModelListener extends TreeModelAdapter implements ShapeModelListener, TreeModelListener{
    JTree _jtree;
    public List<TreeModelListener> _treeModelListeners = new ArrayList<TreeModelListener>();

    public TreeModelAdapterWithShapeModelListener(ShapeModel model) {
        super(model);
        _jtree = new JTree(this);
    }

    @Override
    public void addTreeModelListener(TreeModelListener listener) {
        _treeModelListeners.add(listener);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener listener) {
        _treeModelListeners.remove(listener);
    }

    @Override
    public void update(ShapeModelEvent event) {
        ShapeModelEvent.EventType eventType = event.eventType();
        int[] childIndices =  { event.index() };
        Shape[] children =  { event.operand() };
        if (eventType.equals(ShapeModelEvent.EventType.ShapeRemoved)) {
            Object[] path = event.parent().path().toArray();
            TreeModelEvent remove = new TreeModelEvent(_adaptee, path, childIndices, children);
            for(TreeModelListener listener : _treeModelListeners) {
                listener.treeNodesRemoved(remove);
            } 
        } else if (eventType.equals(ShapeModelEvent.EventType.ShapeAdded)) {
            Object[] path = event.parent().path().toArray();
            TreeModelEvent add = new TreeModelEvent(_adaptee, path, childIndices, children);
            for(TreeModelListener l : _treeModelListeners) {
                l.treeNodesInserted(add);
            }
        } 
    }

    @Override
    public void treeNodesChanged(TreeModelEvent event) {}

    @Override
    public void treeNodesInserted(TreeModelEvent event) {
        for(TreeModelListener listener: _treeModelListeners) {
            listener.treeNodesInserted(event);
        }
    }

    @Override
    public void treeNodesRemoved(TreeModelEvent event) {
        for(TreeModelListener listener: _treeModelListeners) {
            listener.treeNodesRemoved(event);
        }
    }

    @Override
    public void treeStructureChanged(TreeModelEvent event) {}
}

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
