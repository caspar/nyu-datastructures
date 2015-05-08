/**
 * My very own implementation of a the referenced-based sorted linked list data stucture.
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class SortedLinkedList<E extends Comparable<E> >{

    private Node<E> head;

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
     * Checks if head is null,
     * passes the burden of adding a node on to the following method otherwise.
     * @param data Data to be added.
     */
    public void add(E data){
        Node<E> newNode = new Node<E>(data);
        if (head == null)
            head = newNode;
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
            newNode.setNext(head);
            head = newNode;
        }
        else{
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
            head = head.getNext();
            return;
        }
        Node<E> previous = head; //previous.getNext() == current
        while (previous.getNext() != null){
            if (previous.getNext().getData().compareTo(data) == 0){
                previous.setNext(previous.getNext().getNext());
                return;
            }
            previous = previous.getNext();
        }
    }

    /**
     * Iteratively removes all nodes from the list whos count is less than `min`.
     * Calls remove. Not very good, I know.
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
            //System.out.println(node.getCount() + "   " + node.getData());
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
