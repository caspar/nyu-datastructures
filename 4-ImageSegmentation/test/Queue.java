/**
 * Implementation of Queue ADT using references rather than an array.
 * Creates Node objects, organizes them in a queue.
 * @author Caspar Lant
 * @see http://github.com/caspar/
 *      http://casparlant.com/
 */
public class Queue<E>{

    private Node<E> head = null;
    private Node<E> tail = null; //Queue implementation with a tail reference is quicker that the more iterative approach

    public Queue(){
        //instantiate queue class. (I don't think this is necessary but it was detailed in the assignment description)
    }

    /**
     * Tests if this queue is empty.
     * @return A boolean that represents whether the abstract Queue object is devoid of Node references
     */
    public boolean empty(){
        return (head == null);
    }

    /**
     * Returns the element at the front of this queue without removing it from the queue.
     * @return The firts element in the queue; found easily using the head reference.
     */
    public E peek(){
        if (head == null)
            return null;
        return head.getData();
    }

    /**
     * Removes the element at the top of this queue and returns that element as the value of this function.
     * @return The first element in the queue, found easily using the `head` reference.
     */
    public E dequeue(){
        if (head == null)
            return null;
        E data = head.getData();
        if (head.getNext() == null)
            head = null;
        else{
            head = head.getNext();
        }
        return data;
    }

    /**
     * Adds an item to the front of this queue. Returns the item itself.
     * @param  item Generic object to be added to the queue
     * @return      This is the same Generic object. I don't know why this is convention; it doesn't seem to be of much use.
     *              (I guess it ocassionally eliminates need for the creation of a reference...)
     */
    public E enqueue(E item){
        Node<E> n = new Node<E>(item);
        Node<E> current = head;
        if (head == null){
            head = tail = n; //teehee (this is terrible) (actually, this may help out the compiler...) (probably not though)
        }
        // //Tail-less solution:
        // while(current.getNext() != null){
        //     current = current.getNext();
        // }
        else{
            tail.setNext(n);
            tail = n;
        }
        return item;
    }
}
