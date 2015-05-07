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

    // public void add(E data){
    //     if (head == null){ //first time
    //         head = new Node<E>(data);
    //         System.out.println("head was null");
    //     }
    //     else{
    //         System.out.println("adding new node");
    //         add(null, new Node<E>(data), head);
    //     }
    // }
    //
    // public void add(Node<E> previous, Node<E> newNode, Node<E> current){
    //     System.out.println(newNode.getData());
    //     while (current != null){
    //         if (newNode.compareTo(current) == 0){
    //             System.out.println("equal");
    //             current.incrementCount();
    //             break;
    //         }
    //         else if (newNode.compareTo(current) > 0){ // a > b
    //             System.out.println(">");
    //             //insert the node between previous and current;
    //             if (previous != null){ //current == head
    //                 System.out.println("current == head");
    //                 previous.setNext(newNode);
    //             }
    //             newNode.setNext(current);
    //             break;
    //         }
    //         else{ //newNode's data < current's
    //             System.out.println("newNode's data < current's");
    //             previous = current;
    //             current = current.getNext();
    //         }
    //     }
    //     System.out.println("sucessfully added node");
    //
    // }

    // public void add(E data){
    //     Node<E> previous;
    //     Node<E> location;
    //     E locData;
    //
    //     location = head;
    //     previous = null;
    //     while (location != null){
    //         locData = location.getData();
    //         if (locData.compareTo(data) == 0){
    //             location.incrementCount();
    //             break;
    //         }
    //         else if (data.compareTo(data) < 0){
    //             previous = location;
    //             location = location.getNext();
    //         }
    //         else
    //             break;
    //     }
    //     Node<E> newNode = new Node<E>(data);
    //
    //     if (previous == null){
    //         newNode.setNext(head);
    //         head = newNode; //this may be the problem!
    //     }
    //     else{
    //         newNode.setNext(location);
    //         previous.setNext(newNode);
    //     }
    // }

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
        while (node != null){
            System.out.println(node.getCount() + "   " + node.getData());
            //System.out.printf("%-5 d %s%n", node.getCount(), node.getData());
            node = node.getNext();
        }
    }
}
