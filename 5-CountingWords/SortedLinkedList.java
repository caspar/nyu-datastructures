/**
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class SortedLinkedList<E extends Comparable<E> >{

    private Node<E> head;

    public SortedLinkedList(){

    }

    public SortedLinkedList(Node<E> head){
        this.head = head;
    }

    public void add(E data){
        Node<E> newNode = new Node<E>(data);
        if (head == null)
            head = newNode;
        else
        add(null, newNode, head);
    }

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

    public void prune(int min){
        Node<E> current = head;
        while (current != null){
            if (current.getCount() < min){
                remove(current.getData());
            }
            current = current.getNext();
        }
    }

    public void traverse(){
        Node<E> node = head;
        while (node != null){
            //System.out.println(node.getCount() + "   " + node.getData());
            System.out.printf("%-5d %s%n", node.getCount(), node.getData());
            node = node.getNext();
        }
        System.out.println();
    }

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
