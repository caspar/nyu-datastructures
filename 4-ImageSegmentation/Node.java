/**
 * @author Caspar Lant<E>
 *
 */
public class Node<E>{

    private E data;
    private Node next;

    public Node(E data){
        this.data = data;
    }

    public Node(){
        this.data = null; //not quite necessary...
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public E getData(){
        return data;
    }

    public void setData(E data){
        this.data = data;
    }

}
