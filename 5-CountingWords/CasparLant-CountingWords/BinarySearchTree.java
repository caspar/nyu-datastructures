/**
* My very own implementation of the hallow'd binary search tree data type.
* @author Caspar Lant
* @see    github.com/caspar
*         casparlant.com
*/
class BinarySearchTree<E extends Comparable<E> >{

    private BSTNode<E> root; //Top of the tree
    private E data;

    private int count; //solved a problem I encountered with node removal:
                       //The node would be deleted, but its count was passed on the its successor-predecessor. Regal.
                       //Took me FOREVER to figure out.

    /**
     * Default constuctor; does nothing.
     */
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

    /**
     * Recursive contains() method included for completeness-- not invoked in this implementation.
     * @param   data of the queried node.
     * @param   operative node.
     * @return  boolean representing the above statement
     */
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

    /**
     * Returns a reference to the heighest BSTNode<E> in the tree
     * whose `data` field is equal to the data provided by the user.
     * @param   user-provided data (in most cases)
     * @param   current node (this method implements recursion)
     * @return  A reference to the node which statisfies the above statement.
     */
    public BSTNode<E> get(E data, BSTNode<E> current){
        if (current == null){
            return null; //some error case
        }
        if (data.compareTo(current.getData()) < 0){
            return get(data, current.getLeft());
        }
        if (data.compareTo(current.getData()) > 0){
            return get(data, current.getRight());
        }
        return current; //data == current.getData();
    }

    /**
     * creates and adds a Node with specified data to the Binary Search Tree.
     * Returns a reference to the node (so the user can hang on to it if she chooses).
     * @param   Data to be added to the sorted tree.
     * @return  Reference to the node once it is added
     *          (its children/parent are resolved)
     */
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

    /**
     * Adds a Node with specified data to the Binary Search Tree
     * @param   BSTNode<E> object
     * @param   Data to be added to the sorted tree.
     * @return  Reference to the node once it is added
     *          (its children/parent are resolved)
     */
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

    /**
     * Calls the recursive remove() method, and updates the root reference if necessary.
     * Returns nothing. (Some implementations return a boolean to denote a sucessful removal)
     * This does not.
     * @param data Data to be removed.
     */
    public void remove(E data){
        root = remove(root, data);
    }

    /**
     * Removes a node with data equal to second parameter from the tree structure,
     * if such a node exists.
     * Does nothing otherwise
     * @param   BSTNode<E> object. Current node.
     * @param   Data to be removed from tree.
     * @return  Reference to the node.
     */
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

    /**
     * Helps out the recursive remove() method.
     * Deals with the physical dereferencing of the removed node.
     * @param  node BSTNode<E> object to be removed from tree stucture.
     * @return      A reference to the new node at that location.
     */
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
    public StringBuffer traverse(){
        return traverse(root);
    }

    /**
     * Traverses through this instance of the binary search tree.
     * @param node The top node in an unspecified subtree.
     */
    private StringBuffer traverse(BSTNode<E> node){ //my first time using StringBuffer!
        StringBuffer buffer = new StringBuffer();

        if (node == null){
            return buffer;
        }
        buffer.append(traverse(node.getLeft()));
        buffer.append(String.format("%-5d %s%n", node.getCount(), node.getData()));
        buffer.append(traverse(node.getRight()));
        return buffer;
    }

    public void prune(int min){
        prune(root, min);
    }

    /**
     * Removes all nodes with count below a specified threshold, min
     * @param  node under scrutiny
     * @param  dictates the minimum count that will spare a node from pruning.
     */
     private void prune(BSTNode<E> node, int min){
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
