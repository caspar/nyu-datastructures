/**
* @author Caspar Lant
* @see    github.com/caspar
*         casparlant.com
*/
class BinarySearchTree<E extends Comparable<E> >{

    private BSTNode<E> root; //Top of the tree
    private E data;

    private int count;

    public BinarySearchTree(){

    }

    /**
     * Calls the recursive `size()` method.
     * @return The size of the tree (number of nodes)
     */
    public int size(){
        return size(root);
    }

    /**
     * Computes the size of this instance of BinarySearchTree recursively.
     * @param  node Top of current subtree
     * @return      The number of nodes in this tree, formatted as an int.
     */
    public int size(BSTNode<E> node){
        if (node == null)
            return 0;
        return 1 + size(node.getRight()) + size(node.getLeft());
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

    //creates a node, adds it to the BST, returns a reference to it (so the user can hang on to it if she chooses)
    public BSTNode<E> add(E data){
        //System.out.println("Added: " + data);
        //return add(new BSTNode<E>(data) );
        if (root == null){
            root = new BSTNode<E>(data);
            //traverse();
            return root;
        }
        else{
            //traverse();
            return add(root, data);
        }
    }

    private BSTNode<E> add(BSTNode<E> node, E data){
        if (node == null){
            node = new BSTNode<E>(data);
            return node;
        }
        else if (data.compareTo(node.getData()) == 0){
            node.incrementCount();
        }
        else if (data.compareTo(node.getData()) < 0){
            node.setLeft( add(node.getLeft(), data) );
        }
        else if (data.compareTo(node.getData()) > 0){
            node.setRight( add(node.getRight(), data) );
        }

        return node;
    }

    /**    /**
    * Only remove leaf node
    * @param   node
    * @param   data
    * @return  node
    */
    public void remove(E data){
        root = remove(root, data);
    }

    private BSTNode<E> remove(BSTNode<E> node, E data){//data is ____ ?
        //traverse();
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
            return delete(node);
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
        node.setCount(count);
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
            return null; //no predecessor
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
        if (node.getRight() == null){
            count = node.getCount();
            return node.getData();
        }
        else
            return getPredecessorRec(node.getRight());
    }

    /**
     * Calls the recursive traverse(BSTNode<E>) method.
     */
    public void traverse(){
        traverse(root);
        System.out.println();
    }

    /**
     * Traverses through this instance of the binary search tree.
     * @param node The top node in an unspecified subtree.
     */
    public void traverse(BSTNode<E> node){ //difference vs. previous traversals is that this has a base case
        if (node == null){
            return;
        }
        traverse(node.getLeft());
        System.out.printf("%-5 d %s%n", node.getCount(), node.getData());
        //System.out.println(node.getData() + " : " + node.getCount());
        traverse(node.getRight());
    }

    public void prune(int min){
        prune(root, min);
    }

    /**
     * Removes all nodes with count below a specified threshold, min
     * @param  node under scrutiny
     * @param  dictates the minimum count that will spare a node from pruning.
     */
     public void prune(BSTNode<E> node, int min){
         if (node == null) //has no children, either
            return;
         prune(node.getLeft(),  min);
         if (node.getCount() < min){
             remove(node.getData());
         }
        //  if (node.getCount() == 1) //words that appear only once. Kind of interesting.
        //     System.out.println(node.getData());
         prune(node.getRight(), min);
     }
 }
