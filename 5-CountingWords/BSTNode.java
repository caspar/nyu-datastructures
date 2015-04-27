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

    public BSTNode(E data, BSTNode<E> left, BSTNode<E> right){
        this.data  = data;
        this.left  = left;
        this.right = right;
    }

    public int compareTo(BSTNode<E> node){
        return this.data.compareTo(node.getData());
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
