public class Queue{
    //creates Node objects, organizes them in a Queue.

    private Node head;
    private Node tail;

    public Queue(){

    }

    public boolean empty(){
        // Tests if this queue is empty.
        return head = null;
    }

    public E peek(){
        // Returns the element at the front of this queue without removing it from the queue.
        return head.getData();
    }

    public E dequeue(){
        // Removes the element at the top of this queue and returns that element as the value of this function.
        if (head == null)
            return null;
        if (head.getNext() == null)
            head = null;
        else
            E data = head.getData();
            head = head.getNext() //does this work if head.next is null?
        return data;
    }

    public E enqueue(E item){
        // Adds an item to the front of this queue. Returns the item itself. //why is this convention?
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
