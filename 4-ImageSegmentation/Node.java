public class Node<E extends Comparable<E>>{

    private E data;
    private Node next;

    Node(E data){
        this.data = data;
    }

    Node(){
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
