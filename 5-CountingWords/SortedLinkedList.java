/**
 * My very own implementation of a the referenced-based sorted linked list data stucture.
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class SortedLinkedList<E extends Comparable<E> >{

    private Node<E> head;

    private int size;

    /**
     * Default constructor. Does nothing
     */
    public SortedLinkedList(){
    }

    /**
     * Constructor method. Gets the list ahead.
     */
    public SortedLinkedList(Node<E> head){
        this.head = head;
    }

    /**
     * Returns the value of the class variable "size"
     * @return The size of the linked list structure.
     */
    public int getSize(){
        return size;
    }

    /**
     * Checks if head is null,
     * passes the burden of adding a node on to the following method otherwise.
     * @param data Data to be added.
     */
    public void add(E data){
        Node<E> newNode = new Node<E>(data);
        if (head == null){
            size = 1;
            head = newNode;
        }
        else
        add(null, newNode, head);
    }

    /**
     * Iteratively adds a node to the list structure.
     * If a node with identical data exists, the `count` of the existing node is incremented.
     * Keeps track of potential preceeding and suceeding nodes.
     * @param  Potential previous nodes. Eliminates problems dereferencing.
     * @param  Node to be added to the structure.
     * @param  Node under scrutiny.
     */
    public void add(Node<E> previous, Node<E> newNode, Node<E> current){
        while (current != null){
            if (newNode.compareTo(current) > 0){ //newNode < current
                previous = current;
                current = current.getNext();
            }
            else
                break;
        }

        if (newNode.compareTo(current) == 0){
            current.incrementCount(); //no change to the order of nodes
            return;
        }
        if (previous == null){
            size++;
            newNode.setNext(head);
            head = newNode;
        }
        else{
            size++;
            newNode.setNext(current); //current may be null
            previous.setNext(newNode);
        }
    }

    /**
     * Removes the first instance of a node with `data` data, if said node exists.
     * @param data Data to be removed from the structure.
     */
    public void remove(E data){ //removes first instance only
        if (head == null){
            return;
        }
        if (head.getData().compareTo(data) == 0){
            size--;
            head = head.getNext();
            return;
        }
        Node<E> previous = head; //previous.getNext() == current
        while (previous.getNext() != null){
            if (previous.getNext().getData().compareTo(data) == 0){
                size--;
                previous.setNext(previous.getNext().getNext());
                return;
            }
            previous = previous.getNext();
        }
    }

    /**
     * Iteratively removes all nodes from the list whos count is less than `min`.
     * Initially handled node removal locally, but after reasing the guidlines it
     * seemed better to make a call to remove(), inefficient as it is.
     * @param min Minimum threshold of count for node's immunity.
     */
    public void prune(int min){
        Node<E> current = head;
        while (current != null){
            if (current.getCount() < min){
                remove(current.getData());
            }
            current = current.getNext();
        }
    }

    /**
     * Iteratively traverses through the list, producing a formatted string along the way.
     */
    public void traverse(){
        Node<E> node = head;
        while (node != null){
            System.out.printf("%-5d %s%n", node.getCount(), node.getData());
            node = node.getNext();
        }
        System.out.println();
    }

    /**
     * Iteratively computes the number of nodes in the structure.
     * @return Number of nodes in the linked list, formatted as an `int`.
     */
    public int size(){
        int size = 0;
        Node<E> node = head;
        while (node != null){
            size++;
            node = node.getNext();
        }
        return size;
    }


}
