import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

/**
 * MostFrequentWord.java program
 * Calculated the most frequent words in a text given a file and a cutoff value
 * using sorted linked list (reference-based)
 * and binary search tree (recursive) data structures.
 * Prints computation time of each algorithm to command line.
 * Writes most frequent words to a file of user-specified name.
 * @author Caspar Lant
 * @see github.com/caspar
 */
public class MostFrequentWord {

    //instaniate ADTs at class instantiation; not a factor in speed tests
    private static BinarySearchTree<String> tree = new BinarySearchTree<String>();
    private static SortedLinkedList<String> list = new SortedLinkedList<String>();

    //stores words spat-out by FileParser in parse() method. Publicly viewable.
    public static  ArrayList<String> words = new ArrayList<String>();

    private static String FILENAME;
    public  static String OUT_NAME; //public; can be modified after runtime at no consequence to the program.
    public  static int    CUTOFF;   //public; can be modified after runtime at no consequence to the program.

    /**
     * Main method.
     * Handles argument errors and catches exceptions thrown.
     * Parses through specified file, or catches an error if file is not found/corrupted.
     * Runs tests of SortedLinkedList and BinarySearchTree.
     * Writes data to text file.
     * @param args Array of type String that contains user arguments:
     *             -Filename
     *             -Cutoff
     *             -Name of output file
     */
    public static void main(String[] args) {
        //comprehensive argument-handling
        try{
            FILENAME = args[0];
            CUTOFF = Integer.parseInt(args[1]);
            OUT_NAME = args[2];
        }catch(ArrayIndexOutOfBoundsException oops){
            System.out.println("Please provide three parameters.");
            System.exit(0);
        }catch(NumberFormatException oofs){
            System.out.println("Second argument should be an integer.");
            System.exit(0);
        }catch(Exception eesh){
            System.out.print("Incorrect argument format.");
            System.exit(0);
        }

        words = parse(FILENAME);

        testLinkedList();

        testBinarySearchTree();

        try{
            writeToFile();
        }catch(IOException oof){}
    }

    /**
     * This method parses through the user-specified file.
     * Instantiates the FileParser object (written by Prof. Klukowska),
     * Returns an ArrayList of Strings
     * @param  filename User-declared filename, passed to this instance of FileParser
     * @return          All the words in the file, formatted in an ArrayList<String>
     *                  with strange characters removed
     */
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
        System.out.printf("\nINFO: Reading file took %7d nanoseconds ( ~%.3f seconds).\n",
                         (end - start), (double)(end - start)/1000000000.0);
        System.out.printf("INFO: %d words read.\n", words.size());
        return words;
    }

    /**
     * Populates the SortedLinkedList object with the words returned by the parse(String) method.
     * Computes the runtimes of the add() and prune() methods in nanoseconds,
     * and prints the results to the command line in a FormattedString.
     */
    public static void testLinkedList(){
        long start, mid, end;
        int wordsAdded;
        System.gc(); //invoke java garbage collector

        start = System.nanoTime();

        for (String word : words){
            list.add(word);
        }
        wordsAdded = list.getSize();

        mid = System.nanoTime();
        list.prune(CUTOFF);
        end = System.nanoTime();

        // runtime analysis
        System.out.println("\nProcessing using Sorted Linked List:");
        System.out.printf("INFO: Creating index took %d nanoseconds ( ~%.3f seconds).\n",
        (mid - start), (double)(mid - start)/1000000000.0);
        System.out.printf("INFO: %d words stored in index.\n", wordsAdded);
        System.out.printf("INFO: Pruning index took %d nanoseconds ( ~%.3f seconds).\n",
        (end - mid), (double)(end - mid)/1000000000.0);
        System.out.printf("INFO: %d words remaining after pruning.\n", list.getSize());
    }

    /**
     * Populates the BinarySearchTree object it with the words returned by the parse(String) method.
     * Computes the runtimes of the add() and prune() methods in nanoseconds,
     * and prints the results to the command line in a FormattedString.
     */
    public static void testBinarySearchTree(){
        long start, mid, end;
        int wordsAdded;
        System.gc(); //invoke java garbage collector

        start = System.nanoTime();
        for (String word : words){
            tree.add(word);
        }
        wordsAdded = tree.getSize();

        mid = System.nanoTime();
        tree.prune(CUTOFF);
        end = System.nanoTime();

        // runtime analysis
        System.out.println("\nProcessing using Recursive Binary Search Tree:");
        System.out.printf("INFO: Creating index took %d nanoseconds ( ~%.3f seconds).\n",
        (mid - start), (double)(mid - start)/1000000000.0);
        System.out.printf("INFO: %d words stored in index.\n", wordsAdded);
        System.out.printf("INFO: Pruning index took %d nanoseconds ( ~%.3f seconds).\n",
        (end - mid), (double)(end - mid)/1000000000.0);
        System.out.printf("INFO: %d words remaining after pruning.\n\n", tree.getSize());
    }

    /**
     * Instansiates a BufferedWriter object, as well as FileWriter and File objects.
     * Implementation guidelines found in ORACLE Java documentation.
     * Writes traversal of BinarySearchTree post-pruning to a file of user-specified name.
     * Throws an IOException in the case of a non-utf8 compliant filename.
     */
    public static void writeToFile() throws IOException {
        //uses BST traversal; it's faster and I've done more testing on it.
        //It's possible that I don't need a BufferedWriter here (StringBuffer is already fully-formed),
        //but hey, I'd never used one before.
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(OUT_NAME)));
        writer.write(tree.traverse().toString());
        writer.flush(); //just to be safe
        writer.close();
    }

}
