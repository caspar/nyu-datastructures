/**
 * Implementation of Queue ADT using references rather than an array.
 * @author Caspar Lant
 * @see github.com/caspar
 *
 */
public class Queue<E>{
    //creates Node objects, organizes them in a Queue.

    private Node<E> head;
    private Node<E> tail;

    public Queue(){
        //instantiate queue class. (I don't think this is necessary)
    }

    public boolean empty(){
        // Tests if this queue is empty.
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
        if (head.getNext() == null)
            head = null;
        else{
            E data = head.getData();
            head = head.getNext(); //does this work if head.next is null?
        }
        return data;
    }

    /**
     * Adds an item to the front of this queue. Returns the item itself.
     * @param  item Generic object to be added to the queue
     * @return      the same Generic object. I don't know why this is convention..
     */
    public E enqueue(E item){
        Node n = new Node(item);
        if(head == null){ //if head == tail, length == 1
            head = n;
            tail = n;
        }
        else
            tail.setNext(n);
        return item;
    }

}
