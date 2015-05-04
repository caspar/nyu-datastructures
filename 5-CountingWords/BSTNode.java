/**
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class BSTNode<E extends Comparable<E>>{

    private E data = null;
    private int count = 1;

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

    public int compareTo(BSTNode<E> other){
        if (this.getCount() > other.getCount())
            return 1;
        if (this.getCount() < other.getCount())
            return -1;
        else
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

    public int getCount(){
        return count;
    }

    public int increment(){
        return count++;
    }

}
