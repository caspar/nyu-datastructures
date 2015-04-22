/**
* @author Caspar Lant
*
* @see github.com/caspar
*/

class BinarySearchTree<E>{

    private BSTNode<E> root;
    private E data = root.data(); //may delete

    public BinarySearchTree(){

    }

    public void sort(){

    }

    public int size(){
        return size(root);
    }

    public int size(BSTNode<E> node){
        if (node = null)
        return 0;
        return 1 + size(node.getRight()) + size(node.getLeft());
    }

    public int search(int[] array, int key, int min, int max){
        if (max < min)
        return -1;
        int mid = (max + min) / 2;
        if (array[mid] == key)
        return mid;
        if (array[mid] < key)
        return search(array, key, min-1, max);i

    }

    // public void insert(BSTNode<E> n, E data){
    //     if (n == null)
    //         return new BSTNode<E>(data);
    //     if (data < n.
    //
    //
    // }

    /**
    * Only remove leaf node
    * @param   node
    * @param   data
    * @return  node
    */
    public BSTNode<E> remove(BSTNode<E> node, E data){//data is ____ ?
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft( remove(node.getLeft(), data) );
        }
        else if (data.compareTo(node.getData()) > 0) { //I don't need `else`
        node.setRight( remove(node.getRight(), data) );
    }
    else { //data.CompareTo(node.getData) == 0;
        return null;
    }
    return node;
}

public BSTNode<E> traverse(BSTNode<E> node){ //difference vs. previous traversals is that this has a base case
    if (node == null){
        return null;
    }
    node.setLeft( traverse(node.getLeft()) );
    node.setRight( traverse(node.getRight()) );
    return node;
}
}
