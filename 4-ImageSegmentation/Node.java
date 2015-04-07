/**
 * @author Caspar Lant<E>
 *
 */
public class Node<E>{

    private E data = null; //why are these Objects????
    private Node<E> next = null;

    public Node(E data){ //I shouldn't need <E>... WHY DOES THIS RETURN AN OBJECT?!@?!?!?
        this.data = data;
    }

    /**
     * Default Constructor. Doesn't do anything.
     * @return N/A
     */
    public Node(){
        this.data = null; //not quite necessary...
    }

    /**
     * Returns the next Node in the sequence
     * @return The Node object referenced in this instance of the Node class
     */
    public Node<E> getNext(){
        return next;
    }

    /**
     * Takes a node Object for this instance of the node class to reference
     * @param next Node Object to be referenced in this instance of Node
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

    public void setData(E data){
        this.data = data;
    }

}
