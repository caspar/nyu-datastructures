class BinarySearchTree extends BinaryTree{

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

    public void add(E data){
        ///////// //////// //////// //////// //////// ////////
        ///       //    // //       //    // //    // //    //
        ///       //////// //////// //////// //////// ////////
        ///       //    //       // //       //    // //  //
        ///////// //    // //////// //       //    // //   //
    }
}
