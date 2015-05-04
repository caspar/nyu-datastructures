/**
* @author Caspar Lant
* @see    github.com/caspar
*         casparlant.com
*/
class BinarySearchTree<E extends Comparable<E> >{

    private BSTNode<E> root; //Top of the tree
    private E data;

    public BinarySearchTree(){

    }

    public int size(){
        return size(root);
    }

    public int size(BSTNode<E> node){
        if (node == null)
            return 0;
        return 1 + size(node.getRight()) + size(node.getLeft());
    }

    public int search(int[] array, int key, int min, int max){ //returns index of the BSTNode object whos data field is equal to `key`
        if (max < min){
            return -1;
        }

        int mid = (max + min) / 2;

        if (array[mid] == key){
            return mid;
        }
        if (array[mid] < key){
            return search(array, key, min-1, max);
        }
        else{
            return search(array, key, min, max+1); //Not sure about this; assuming symmetry
        }
    }

    public boolean contains(E data, BSTNode<E> current){
        if (current == null){
            return false;
        }
        if (data.compareTo(current.getData()) < 0){
            return contains(data, current.getLeft());
        }
        if (data.compareTo(current.getData()) > 0){
            return contains(data, current.getRight());
        }
        return true; //data == current.getData();
    }

    public E get(E data, BSTNode<E> current){
        if (current == null){
            return null; //some error case
        }
        if (data.compareTo(current.getData()) < 0){
            return get(data, current.getLeft());
        }
        if (data.compareTo(current.getData()) > 0){
            return get(data, current.getRight());
        }
        return current.getData(); //data == current.getData();
    }
    // public void insert(BSTNode<E> n, E data){
    //     if (n == null)
    //         return new BSTNode<E>(data);
    //     if (data < n.
    //
    //
    // }

    //creates a node, adds it to the BST, returns a reference to it (so the user can hang on to it if she chooses)
    public BSTNode<E> add(E data){
        //return add(new BSTNode<E>(data) );
        if (root == null){
            root = new BSTNode<E>(data);
            return root;
        }
        else
            return add(root, data);
    }

    private BSTNode<E> add(BSTNode<E> node, E data){
        if (node == null){
            node = new BSTNode<E>(data);
            return node;
        }
        if (data.compareTo(node.getData()) < 0){
            node.setLeft( add(node.getLeft(), data) );
        }
        else{
            node.setRight( add(node.getRight(), data) );
        }
        //TODO
        return node;
    }

    /**    /**
    * Only remove leaf node
    * @param   node
    * @param   data
    * @return  node
    */
    public BSTNode<E> remove(E data){
        return remove(root, data);
    }

    public BSTNode<E> remove(BSTNode<E> node, E data){//data is ____ ?
        if (node == null){
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft( remove(node.getLeft(), data) );
        }
        else if (data.compareTo(node.getData()) > 0){ //I don't need `else`
            node.setRight( remove(node.getRight(), data) );
        }
        else { //data.CompareTo(node.getData) == 0;
            delete(node);
        }
        return node;
    }

    private BSTNode<E> delete(BSTNode<E> node){
        if (node.getLeft() == null){
            return node.getRight();
        }
        if (node.getRight() == null){
            return node.getLeft();
        }

        E data = getPredecessor(node);
        node.setData(data);
        node.setLeft( remove(node.getLeft(), data) );
        return node;
    }

    /**
     * Returns the the returns the value of `data` of the node object that preceeds the specified node.
     * This value is computed by recursively finding the rightmost node in the specified node's left subtree.
     * @param  node Specified BSTNode object. Will get deleted in most use-cases
     * @return      The node's value
     */
    private E getPredecessor(BSTNode<E> node){
        if (node.getLeft() == null){
            return null;
        }

        BSTNode<E> current = node.getLeft();
        return getPredecessorRec(current);
    }

    /**
     * Continuation of the getPredecessor method specified above. Recursive implementation.
     * @param  node Specified BSTNode object. Will get deleted in most use-cases
     * @return      The node's value
     */
    private E getPredecessorRec(BSTNode<E> node){
        if (node.getRight() == null)
            return node.getData();
        else
            return getPredecessorRec(node.getRight());
    }

    public void traverse(){
        traverse(root);
    }

    public void traverse(BSTNode<E> node){ //difference vs. previous traversals is that this has a base case
        if (node == null){
            return;
        }
        traverse(node.getLeft());
        System.out.println(node.getData());
        traverse(node.getRight());
    }
}
