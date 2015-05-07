/**
 * @author Caspar Lant
 * @see github.com/caspar
 *      casparlant.com
 */
public class BSTNode<E extends Comparable<E>> implements Comparable< BSTNode<E> >{

    private E data = null;
    private int count = 1; //starts at one for obvious reasons

    private BSTNode<E> previous  = null;
    private BSTNode<E> next = null;

    public BSTNode(E data){
        this.data = data;
    }

    public BSTNode(E data, BSTNode<E> previous, BSTNode<E> next){
        this.data  = data;
        this.previous  = previous;
        this.next = next;
    }

    public int compareTo(BSTNode<E> other){
        // return this.data.compareTo(other.getData());
        if (this.count > other.getCount())
            return 1;
        if (this.count < other.getCount())
            return -1;
        else
            return 0;
    }

    public boolean hasPrevious(){
        return previous != null;
    }

    public boolean hasNext(){
        return next != null;
    }

    /**
     * Returns the previous child in the tree structure
     * @return The BSTNode<E> object referenced in this instance of BSTNode<E>
     */
    public BSTNode<E> getPrevious(){
        return previous;
    }

    /**
     * Returns the next child in the tree structure
     * @return The BSTNode<E> object referenced in this instance of BSTNode<E>
     */
    public BSTNode<E> getNext(){
        return next;
    }

    /**
     * Takes a BSTNode<E> Object for this instance of the node class to reference.
     * This referenced Object represents the previous child of the current BSTNode<E> instance.
     * @param previous BSTNode<E> Object to be referenced in this instance of BSTNode<E>
     */
    public void setPrevious(BSTNode<E> previous){
        this.previous = previous;
    }

    /**
     * Takes a BSTNode<E> Object for this instance of the node class to reference.
     * This referenced Object represents the next child of the current BSTNode<E> instance.
     * @param next BSTNode<E> Object to be referenced in this instance of BSTNode<E>
     */
    public void setNext(BSTNode<E> next){
        this.next = next;
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
