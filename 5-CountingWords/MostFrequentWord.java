/**
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class MostFrequentWord {

    public BinarySearchTree<String> tree = new BinarySearchTree<String>();
    public SortedLinkedList<String> list = new SortedLinkedList();

    public static void main(String[] args) {
        try{
            final String IN_NAME = args[0];
            final int CUTOFF = args[1];
            final String OUT_NAME = args[2];
        }catch(Exception oops){
            System.out.println(oops);
        }
    }
}
