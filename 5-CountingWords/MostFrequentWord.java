/**
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class MostFrequentWord {

    private BinarySearchTree<String> tree = new BinarySearchTree<String>();
    private SortedLinkedList<String> list = new SortedLinkedList();

    public  ArrayList<String> words = new ArrayList<String>(); //check this syntax; justify its publicity

    private final String FILENAME; //final?
    public  final String OUT_NAME; //final?
    public  final int    CUTOFF;   //final?

    public static void main(String[] args) {
        try{
            FILENAME = args[0];
            CUTOFF = args[1];
            OUT_NAME = args[2];
        }catch(Exception oops){
            System.out.println("Please provide three parameters\n" + oops);
        }

        words = parse();

        System.gc(); //garbage collector
        runBinarySearchTree(CUTOFF);

        System.gc(); //garbage collector
        runLinkedList(CUTOFF);

    }

    private ArrayList<String> parse(String filename){
        try{
            FileParser parser = new FileParser(filename);
        }catch(IOException message){
            System.out.println(message);
            System.exit(0);
        }
        return parser.getAllWords();
    }

    public ArrayList<String> runBinarySearchTree(int cutoff){
        for (String word : words){
            tree.add(word);
        }
        tree.prune(cutoff);
    }

    public ArrayList<String> runLinkedList(int cutoff){
        for (String word : words){
            list.add(word);
        }
    }

}
