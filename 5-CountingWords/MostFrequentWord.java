import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

/**
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class MostFrequentWord {

    //instaniate ADTs at class instantiation; not a factor in speed tests
    private static BinarySearchTree<String> tree = new BinarySearchTree<String>();
    private static SortedLinkedList<String> list = new SortedLinkedList<String>();

    public static  ArrayList<String> words = new ArrayList<String>(); //check this syntax; justify its publicity

    private static String FILENAME;
    public  static String OUT_NAME;
    public  static int    CUTOFF;

    public static void main(String[] args) {
        try{
            FILENAME = args[0];
            CUTOFF = Integer.parseInt(args[1]);
            OUT_NAME = args[2];
        }catch(Exception oops){
            System.out.println("Please provide three parameters of correct type.\n`--help` for usage.");
            System.exit(0);
        }

        words = parse(FILENAME);

        testLinkedList();

        testBinarySearchTree();

        try{
            writeToFile();
        }catch(IOException oof){}
    }

    public static ArrayList<String> parse(String filename){
        long start, end;

        FileParser parser;
        ArrayList<String> words;
        try{
            parser = new FileParser(filename);
        }catch(IOException message){
            System.out.println(message);
            System.exit(0);
            return null; // this is silly, but necessary for the next line to compile
                         // (Java doesn't see that the System.exit() call will prevent it
                         // from excecuting if parser has not been initialized)
        }

        System.gc(); //invoke garbage collector
        start = System.nanoTime();
        words =  parser.getAllWords();
        end = System.nanoTime();
        System.out.printf("\nINFO: Reading file took %7d nanoseconds ( ~0.%d seconds).\n",
                         (end - start), (end - start)/1000000);
        System.out.printf("INFO: %d words read.\n", words.size());
        return words;
    }

    public static void testLinkedList(){
        long start, mid, end;
        int wordsAdded;
        System.gc(); //invoke java garbage collector

        start = System.nanoTime();

        for (String word : words){
            list.add(word);
        }
        wordsAdded = list.size();

        mid = System.nanoTime();
        list.prune(CUTOFF);
        end = System.nanoTime();

        // runtime analysis
        System.out.println("\nProcessing using Sorted Linked List:");
        System.out.printf("INFO: Creating index took %d nanoseconds ( ~0.%d seconds).\n",
        (mid - start), (mid - start)/1000000);
        System.out.printf("INFO: %d words stored in index.\n", wordsAdded);
        System.out.printf("INFO: Pruning index took %d nanoseconds ( ~0.%d seconds).\n",
        (end - mid), (end - mid)/1000000);
        System.out.printf("INFO: %d words remaining after pruning.\n", list.size());
    }

    public static void testBinarySearchTree(){
        long start, mid, end;
        int wordsAdded;
        System.gc(); //invoke java garbage collector

        start = System.nanoTime();
        for (String word : words){
            tree.add(word);
        }
        wordsAdded = tree.size();

        mid = System.nanoTime();
        tree.prune(CUTOFF);
        end = System.nanoTime();

        // runtime analysis
        System.out.println("\nProcessing using Recursive Binary Search Tree:");
        System.out.printf("INFO: Creating index took %d nanoseconds ( ~0.%d seconds).\n",
        (mid - start), (mid - start)/1000000);
        System.out.printf("INFO: %d words stored in index.\n", wordsAdded);
        System.out.printf("INFO: Pruning index took %d nanoseconds ( ~0.%d seconds).\n",
        (end - mid), (end - mid)/1000000);
        System.out.printf("INFO: %d words remaining after pruning.\n\n", tree.size());
    }

    public static void writeToFile() throws IOException {
        //uses BST traversal; it's faster and I've done more testing on it.
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(OUT_NAME)));
        writer.write(tree.traverse().toString());
        writer.flush();
        writer.close();
    }

}
