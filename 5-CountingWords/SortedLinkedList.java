/**
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class SortedLinkedList<E>{

    private Node<E> head = null;

    public SortedLinkedList(){

    }

    public SortedLinkedList(Node<E> head){
        this.head = head;
    }

    public void sort(){

    }

    public void add(Node<E> newNode){
        if (head == null)
            head = newNode;
        else
            add(null, newNode, head);
    }

    public void add(Node<E> previous, Node<E> newNode, Node<E> next){ //largest --> smallest
        if (newNode.compareTo(next) >= 0){
            newNode.setNext(next);
            if (previous == null){
                head = newNode;
            }
            else{
                previous.setNext(newNode);
            }
        }
        if (next != null){
            add(previous.getNext(), newNode, next.getNext());
        }
    }
}
