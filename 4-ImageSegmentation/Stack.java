public class Stack <E extends <Comparable E>> {

    private Node head;

    public Stack(){
        Stack stack = new Stack(); //does this work?
    }

    public boolean empty(){
        // Tests if this stack is empty
        return head = null;
    }

    public E peek(){
        // Returns the element at the top of this stack without removing it from the stack.
        return head.getData();
    }

    public E pop(){
        // Removes the element at the top of this stack and returns that element as the value of this function.
        E data = head.getData();
        head = head.getNext();
        return data;
    }

    public E push(E item){
        // Pushes an item onto the top of this stack. Returns the item itself
        Node n = new Node(item);
        n.setNext(head);
        head = n;
        return item;
    }
}
