class BSTTester {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        populate();

    }

    public void populate(int numNodes){
        for (int i = 1; i < numNodes; i = i++){
            tree.add(i);
        }
    }
}
