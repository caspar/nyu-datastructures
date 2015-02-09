import java.io.*;
import java.util.*;
//Caspar Lant

public class TreeList{

    ArrayList<Tree> trees = new ArrayList<Tree>();
    ArrayList<Integer> zipcodes = new ArrayList<Integer>();
    ArrayList<String> specodes = new ArrayList<String>();
    public final Hashtable<String, String> TREE_NAMES = new Hashtable<String, String>(100);
    public final ArrayList<String>         SPEC_CODES = new ArrayList<String>();
    public final ArrayList<String>         SPEC_NAMES = new ArrayList<String>();
    //for each line in .csv file, create new tree object with parameters given by that line
    /* to represent all the Tree objects in a single container. TreeList class should store all the Tree objects in
    an ArrayList of trees (depending on your design, you may use more than one such ArrayList). This class should provide
    methods that return the results needed by the five tasks described in the previous section. */

    public TreeList(String[] a){
        makeHash();
        for(String str : a){
            if (hasEightCommas(str)){
                passArgs(str);
            }
        }
        mostGreen();
        //tester();
    }

    public TreeList(ArrayList<String> a){
        makeHash();
        for (String str : a){
            if (hasEightCommas(str)){
                passArgs(str);
            }
        }
    }
    public void tester(){
        for (Tree t : trees){
            System.out.println(t.getID());
        }
    }
    public TreeList(){

    }
    public String mostPopular(){
        //I don't really need to pass it in if I store it as a class variable...
        //sorts by frequency (tree type?) returns first three
        for (Tree tree : trees){
            specodes.add(tree.getSpec()); //now we have an array of speccodes
        }
        //find out which is most popular
        //Collections.frequency
        return "";
    }

    public String leastPopular(){
        //sorts by frequency (tree type?) returns last three
        return "";
    }

    public String mostGreen(){
        String output = "";
        // int last = 0;
        // int current = 0;
        // //sorts by ZC, returns top 3
        // for (Tree t : trees){
        //     if (zipMap.containsKey(t.getZip())){
        //         zipMap.put(t.getZip(), zipMap.get(t.getZip())+1);
        //     }
        //     else{
        //         zipMap.put(t.getZip(), 1);
        //     }
        // }
        return output;
    }

    public String leastGreen(){
        return "";
    }

    public String largest(){
        //if there's a tie, return all
        Tree largest = trees.get(0); //IDK if it's better to store a Tree object or a local int. Do a speed test?
        for (Tree current : trees){
            if (current.getDiameter() > largest.getDiameter()){
                largest = current;
            }
        }
        String output = "";
        output += largest.getSpec() + " \n";
        output += TREE_NAMES.get(largest.getSpec()) + ", " + largest.getDiameter() + " inches in diameter\n";
        output += largest.getStreet() + " (" + largest.getCross1() + ", " + largest.getCross2() + ")\n";
        output += largest.getZip();
        return output;
    }

    private Boolean hasEightCommas(String input){
        //checks to see if the given string has eight commas (ie, if all assumed fields are there)
        int count = 0;
        for(int i = 0; i < input.length(); i++){
            if (input.charAt(i) == ','){
                count++;
            }
        }
        return count == 8;
    }

    private void passArgs(String input){
        trees.add(new Tree(input.split(","))); //I love this line
        //System.out.println(Arrays.toString(input.split(",")));
    }

    private void makeHash(){
        try{
            File file = new File("species_list.txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\r?\n|\r");
            while (scanner.hasNext()){
                String line = scanner.next();
                    TREE_NAMES.put((line.substring(0,line.indexOf(" ")).trim()),
                    (line.substring(line.indexOf(" ")).trim()));
            }
            System.out.println(TREE_NAMES.toString());
        }catch(FileNotFoundException oops){
            System.err.println("Species file not found \n" + oops);
        }
    }
}
