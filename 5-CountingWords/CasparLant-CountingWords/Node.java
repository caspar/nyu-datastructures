/**
 * Generic node object for use in Singly-Linked Lists, Stacks, Queues, and other abstract data types.
 * Stores an object (`data`), as well as a reference to another Node object
 * @author Caspar Lant
 * @see     github.com/caspar
 *          casparlant.com
 */
public class Node<E extends Comparable<E> > implements Comparable< Node<E> >{

    private E data = null;
    private int count = 1; //starts at one for obvious reasons

    private Node<E> next;  //refernce to sucessor node. 

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
     * Returns true if this instance of Node<E> has a reference to another node.
     * Equivalent to the expression (node.getNext() != null).
     * @return A boolean to represent the validity of the above statement
     */
    public boolean hasNext(){
        return next != null;
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

    /**
     * Returns the value of the `count` field in this instance of Node<E> without changing its value (see below)
     * @return The value of `count`.
     */
    public int getCount(){
        return count;
    }

    /**
     * This method is less useful than a setCount(int) method,
     * but because I will only need to increment the Node's count as a iterate through a given word file, this is fine.
     * It's probably quicker than setCount(getCount() + 1);
     * @return the updated count.
     */
    public int incrementCount(){
        return ++count;
    }

    /**
     * Compares this instance of Node<E> to another Node<E> object based on count
     * @param  other Another Node<E>
     * @return       An int representative of the relationship between the two node's `count` fields.
     */
    public int compareTo(Node<E> other){
        if (other == null)
            return -1;
        return data.compareTo(other.getData());
    }

}
