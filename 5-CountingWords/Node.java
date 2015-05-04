/**
 * Generic node object for use in Singly-Linked Lists, Stacks, Queues, and other abstract data types.
 * Stores an object (`data`), as well as a reference to another Node object
 * @author Caspar Lant
 * @see http://github.com/caspar/
 *      http://casparlant.com/
 */
public class Node<E extends Comparable<E> >{

    private E data = null;
    private int count = 1;

    private Node<E> next = null;

    public Node(E data){
        this.data = data;
    }

    /**
     * Default Constructor. Doesn't do anything.
     * @return Not applicable.
     */
    public Node(){
    }

    /**
     * Returns the next Node<E> in the sequence
     * @return The Node<E> object referenced in this instance of the Node<E> class
     */
    public Node<E> getNext(){
        return next;
    }

    /**
     * Takes a node Object for this instance of the node class to reference
     * @param next Node<E> Object to be referenced in this instance of Node
     */
    public void setNext(Node<E> next){
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
     * Sets the data contained in this instance of Node<E>
     * @param data The data Object detailed above.
     */
    public void setData(E data){
        this.data = data;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public int compareTo(Node<E> other){
        if (other != null)
            return 1;
        if (this.getCount() > other.getCount())
            return 1;
        if (this.getCount() < other.getCount())
            return -1;
        else
            return 0;
    }

}
