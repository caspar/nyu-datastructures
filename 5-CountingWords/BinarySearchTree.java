/**
 * @author Caspar Lant
 * @see github.com/caspar
 */
class BinarySearchTree{

    private BSTNode<E> root;

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

    public int search(array, key, min, max){
        if (max < min)
            return -1;
        int mid = (max + min) / 2;
        if (array[mid] == key)
            return mid;
        if (array[mid] < key)
            return search(array, key, min-1, max);i

    }
    public void add(E data){
        ///////// //////// //////// //////// //////// ////////
        ///       //    // //       //    // //    // //    //
        ///       //////// //////// //////// //////// ////////
        ///       //    //       // //       //    // //  //
        ///////// //    // //////// //       //    // //   //
    }
}
