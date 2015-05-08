/**
 * Node object for use in a binary search tree.
 * Keeps references to two other BSTNode<E>'s, left and right children;
 * as well as a reference to some data.
 * @author Caspar Lant
 * @see github.com/caspar
 *      casparlant.com
 */
public class BSTNode<E extends Comparable<E>> implements Comparable< BSTNode<E> >{

    private E data = null;
    private int count = 1; //starts at one for obvious reasons

    private BSTNode<E> left  = null; //null for explicitness
    private BSTNode<E> right = null; //null for explicitness

    public BSTNode(E data){
        this.data = data;
    }

    /**
     * Constuctor which sets all the node's data fields.
     * Never used.
     * @param   data
     * @param   left
     * @param   right
     */
    public BSTNode(E data, BSTNode<E> left, BSTNode<E> right){
        this.data  = data;
        this.left  = left;
        this.right = right;
    }

    /**
     * Generic compareTo() method, based on count.
     * Never used.
     * @param  other Reference to another BSTNode<E> object.
     * @return       int representitve of the relation between the counts of nodes.
     */
    public int compareTo(BSTNode<E> other){
        // return this.data.compareTo(other.getData());
        if (this.count > other.getCount())
            return 1;
        if (this.count < other.getCount())
            return -1;
        else
            return 0;
    }

    /**
     * Returns true if this instance of BSTNode<E> has a left child.
     * Returns false otherwise.
     * @return Boolean
     */
    public boolean hasLeft(){
        return left != null;
    }

    /**
     * Returns true if this instance of BSTNode<E> has a right child.
     * Returns false otherwise.
     * @return Boolean
     */
    public boolean hasRight(){
        return right != null;
    }

    /**
     * Returns true if this instance of BSTNode<E> has a child.
     * Returns false otherwise.
     * Equivalent to calling `hasLeft() || hasRight()`.
     * @return A boolean to represent the validity of the above statement.
     */
    public boolean hasChild(){
        return hasLeft() || hasRight();
    }

    /**
     * Returns the left child in the tree structure
     * @return The BSTNode<E> object referenced in this instance of BSTNode<E>
     */
    public BSTNode<E> getLeft(){
        return left;
    }

    /**
     * Returns the right child in the tree structure
     * @return The BSTNode<E> object referenced in this instance of BSTNode<E>
     */
    public BSTNode<E> getRight(){
        return right;
    }

    /**
     * Takes a BSTNode<E> Object for this instance of the node class to reference.
     * This referenced Object represents the left child of the current BSTNode<E> instance.
     * @param left BSTNode<E> Object to be referenced in this instance of BSTNode<E>
     */
    public void setLeft(BSTNode<E> left){
        this.left = left;
    }

    /**
     * Takes a BSTNode<E> Object for this instance of the node class to reference.
     * This referenced Object represents the right child of the current BSTNode<E> instance.
     * @param right BSTNode<E> Object to be referenced in this instance of BSTNode<E>
     */
    public void setRight(BSTNode<E> right){
        this.right = right;
    }

    /**
     * Method implemented to return the Object that the `data` variable references in this instance of Node
     * @return The referenced Object
     */
    public E getData(){
        return data;
    }

    /**
     * Sets the data contained in this instance of BSTNode<E>
     * @param data The data Object detailed above.
     */
    public void setData(E data){
        this.data = data;
    }

    /**
     * Returns the value of the `count` field in this instance of BSTNode<E> without changing its value (see below)
     * @return The value of `count`
     */
    public int getCount(){
        return count;
    }

    /**
     * Sets the `count` field of this instance of BSTNode<E>.
     * @param count Count
     */
    public void setCount(int count){
        this.count = count;
    }

    /**
     * This method is less useful than a setCount(int) method,
     * but because I will only need to increment the Node's count as a iterate through a given word file, this is fine.
     * It's probably quicker than setCount(getCount() + 1);
     * @return the updated count
     */
    public int incrementCount(){
        return ++count;
    }

}
