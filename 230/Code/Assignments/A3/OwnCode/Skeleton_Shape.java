/**
 * Returns the NestingShape that contains the Shape that method parent is called on. If the callee
 * object is not a child within a NestingShape instance this method returns null.
 */
public NestingShape parent();
/**
* Sets the parent NestingShape of the shape object that this method is called on.
*/
protected void setParent(NestingShape parent);
/**
 * Returns an ordered list of Shape objects. The first item within the list is the root NestingShape
 * of the containment hierarchy. The last item within the list is the callee object (hence this method
 * always returns a list with at least one item). Any intermediate items are NestingShapes that
 * connect the root NestingShape to the callee Shape. E.g. given:
* NestingShape root = new NestingShape ();
* NestingShape intermediate = new NestingShape ();
* Shape oval = new OvalShape ();
 * root.add(intermediate);
 * intermediate.add(oval);
 * a call to oval.path() yields: [root , intermediate , oval]
 */
public java.util.List <Shape> path();