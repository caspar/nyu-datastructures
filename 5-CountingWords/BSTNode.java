/**
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class BSTNode<E extends Comparable<E>>{

    private E data = null;

    private BSTNode<E> left  = null;
    private BSTNode<E> right = null;

    public BSTNode(E data){
        this.data = data;
    }

    public BSTNode(){
    }

    public int compareTo(BSTNode<E> node){
        if (node.getData() > data)
            return -1;
        if (node.getData() < data)
            return 1;
        return 0;
    }

    public boolean hasLeft(){
        return left != null;
    }

    public boolean hasRight(){
        return right != null;
    }

    public boolean hasChild(){
        return hasLeft() || hasRight();
    }
    public BSTNode<E> getLeft(){
        return left;
    }

    public BSTNode<E> getRight(){
        return right;
    }

    public void setLeft(BSTNode<E> left){
        this.left = left;
    }

    public void setRight(BSTNode<E> right){
        this.right = right;
    }

    public E getData(){
        return data;
    }

    public void setData(E data){
        this.data = data;
    }

}
