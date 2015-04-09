/**
 * @author Caspar Lant
 *
 */
public class Node<E>{

    private E data = null;
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

}
