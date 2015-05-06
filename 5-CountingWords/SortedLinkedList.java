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

    // public void add(E data){
    //     if (head == null){
    //         head = new Node<E>(data);
    //         System.out.println("hrrm");
    //         return;
    //     }
    //
    //     Node<E> node = new Node<E>(data);
    //     Node<E> previous = null;
    //     Node<E> next = head;
    //
    //     while(next != null){
    //         if (node.compareTo(next) == 0){
    //             next.incrementCount();
    //             System.out.println(next.getCount());
    //             break;
    //         }
    //         else if (node.compareTo(next) > 0){
    //             node.setNext(next);
    //             previous.setNext(node);
    //             //System.out.println(data);
    //             break;
    //         }
    //         else{
    //             previous = next;
    //             next = next.getNext();
    //             System.out.println("hmm");
    //         }
    //     }
    // }

    public void add(E data){
        Node<E> previous;
        Node<E> location;
        E locData;

        location = head;
        previous = null;
        while (location != null){
            locData = location.getData();
            if (locData.compareTo(data) == 0)
                location.incrementCount();
            if (data.compareTo(data) < 0){
                previous = location;
                location = location.getNext();
            }
            else
                break;
        }
        Node<E> newNode = new Node<E>(data);

        if (previous == null){
            newNode.setNext(head);
            head = newNode;
        }
        else{
            newNode.setNext(location);
            previous.setNext(newNode);
        }
    }

    public void prune(int min){
        if (head == null)
            return;
        prune(head, min);
    }

    public void prune(Node<E> node, int min){ //not really the right verb
        while (node.getNext() != null){
            if (node.getNext().getCount() < min){
                node.setNext(node.getNext().getNext());
                break;
            }
            node = node.getNext();
        }
    }

    public void traverse(){
        Node<E> node = head;
        if (head == null)
            return;
        while (node.getNext() != null){
            System.out.println(node.getCount() + "   " + node.getData());
            //System.out.printf("%-5 d %s%n", node.getCount(), node.getData());
            node = node.getNext();
        }
    }
}
