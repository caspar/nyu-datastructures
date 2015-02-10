import java.io.*;
import java.util.*;

////////////////////////////////////////////////////////
//             Proudly written sans IDE               //
////////////////////////////////////////////////////////
/*******************************************************
 * TreeList Class                                      *
 * Represents all Tree objects in a single container.  *
 * Stores and ArrayList of Trees                       *
 * @author Caspar Lant                                 *
 * @version 1.1 02/01/2015                             *
 *******************************************************/

public class TreeList{

    ArrayList<Tree> trees = new ArrayList<Tree>();
    ArrayList<Integer> zipcodes = new ArrayList<Integer>();
    ArrayList<String> specodes = new ArrayList<String>();
    //SortedMap<Integer, Integer> zippies = new Map<Integer, Integer>();
    public int NUM_TREES = 0;

    public final Hashtable<String, String> TREE_NAMES = new Hashtable<String, String>();
    public final ArrayList<String>         SPEC_CODES = new ArrayList<String>();
    public final ArrayList<String>         SPEC_NAMES = new ArrayList<String>();
    //for each line in .csv file, create new tree object with parameters given by that line
    /* to represent all the Tree objects in a single container. TreeList class should store all the Tree objects in
    an ArrayList of trees (depending on your design, you may use more than one such ArrayList). This class should provide
    methods that return the results needed by the five tasks described in the previous section. */

    /**
     * Deprecated TreeList Constructor
     * @param  a [description]
     * @return   [description]
     */
    public TreeList(String[] a){
        makeHash();
        for(String str : a){
                passArgs(str);
            }
        mostGreen();
        //tester();
    }

    /**
     * TreeList Constructor. Calls makeHash() and makes sure each String in the provided array of tree entries contains the correct number of parameters (done by calling hasEightCommas() method).
     * @param  entries ArrayList<String> containing unparsed tree entries
     */
    public TreeList(ArrayList<String> entries){
        makeHash();
        for (String str : entries){
                passArgs(str);
        }
    }

    /**
     * Reads in the data from ./species_list.txt, and fills the Hashtable<String, String> TREE_NAMES (previously declared)
     * @throws FileNotFoundException Deals with Exceptions by printing an error message.
     */
    private void makeHash(){
        try{
            //File file = new File("species_list.txt");
            Scanner scanner = new Scanner(new File("species_list.txt"));
            scanner.useDelimiter("\r?\n|\r");
            while (scanner.hasNext()){
                String line = scanner.next();
                TREE_NAMES.put((line.substring(0,line.indexOf(" ")).trim()),
                (line.substring(line.indexOf(" ")).trim()));
            }
            //System.out.println(TREE_NAMES.toString());
        }catch(FileNotFoundException oops){
            System.err.println("Species file not found \n");
        }
    }

    /**
    * Checks to see if the given String has eight commas (ie, if all 9 assumed fields are there)
    * @param  input String representing one Tree entry; a line in the .csv file.
    * @return       Returns true if input contains eight commas, false otherwise.
    */
    private Boolean hasEightCommas(String input){
        int count = 0;
        for(int i = 0; i < input.length(); i++){
            if (input.charAt(i) == ','){
                count++;
            }
        }
        return count == 8;
    }

    /**
    * Checks once more to see if the correct number of arguments is present,
    * breaks the String into a String[], with "," set as the delimeter.
    * Great line, in my opinion.
    * @param input String representing one Tree entry; a line in the .csv file.
    */
    private void passArgs(String input){
        String[] entry = input.split(",");
        if (entry.length == 9 && hasCorrectSpecFormat(entry[6]))
        trees.add(new Tree(entry)); //I love this line
        NUM_TREES++;
        //System.out.println(Arrays.toString(input.split(",")));
    }
    private Boolean hasCorrectSpecFormat(String input){
        if (input.length() == 0)
            return false;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == ',' || input.charAt(i) == ' ' || input.charAt(i) == '0')
                return false;
        }
        return true;
    }

    /**
    * Determines the three most popular tree species. Returns more than three if there is a tie.
    * @return The most popular species of trees and their respective quantities, formatted as a String
    */
    public String mostPopular(){
        String output = "Most popular trees:\n";
        //I don't really need to pass it in if I store it as a class variable...
        //sorts by frequency (tree type?) returns first three
        for (Tree tree : trees){
            specodes.add(tree.getSpec()); //now we have an array of speccodes
        }
        Collections.sort(specodes);
        //Collections.frequency
        return output + "\n";
    }

    /**
    * Determines the three most popular tree species. Returns more than three if there is a tie.
    * @return The most popular species of trees and their respective quantities, formatted as a String.
    */
    public String leastPopular(){
        String output = "least popular trees:\n";
        //sorts by frequency (tree type?) returns last three
        return output + "\n";
    }

    /**
     * Determines the three "greenest" ZIP codes (those which contain the most trees).
     * Please not that this is not an accurate reflection of the zipcode's actual "green-ness", because area is not taken into account.
     * @return The greenest ZIP codes and the number of trees that each contains, respectively, formatted as a String
     */
    public String mostGreen(){
        String output = "Most green ZIP codes:\n";
        for (Tree tree : trees){
            zipcodes.add(tree.getZip());
        }
        Collections.sort(zipcodes);
        int[] podium = new int[10];
        int current = zipcodes.get(0);
        for (int i = 0; i < NUM_TREES; i++){


            for (int j = 0; j < podium.length; i++){
                if (zipcodes.lastIndexOf(current) - zipcodes.indexOf(current) > podium[j]){
                    
                }
            }
        }
        return output + "\n";
    }

    /**
     * Determines the three least "green" ZIP codes (those which contain the most trees).
     * Please not that this is not an actual reflection of the zipcode's "green-ness", because area is not taken into account.
     * @return The least green ZIP codes and the number of trees that each contains, respectively, formatted as a String.
     */
    public String leastGreen(){
        String output = "Least green ZIP codes:\n";
        //sort
        return output + "\n";
    }

    /**
     * Determines the Tree with greatest diameter. Returns more than one if a tie is found.
     * @return The species, diameter, and location of the Tree with greatest diameter, formatted as a String.
     */
    public String largest(){
        //if there's a tie, return all
        String output = "The largest Tree:\n";
        Tree largest = trees.get(0); //IDK if it's better to store a Tree object or a local int. Do a speed test?
        for (Tree current : trees){
            if (current.getDiameter() > largest.getDiameter()){
                largest = current;
            }
        }
        //output += "\t" + largest.getSpec() + "\n"; //will be deleted
        output += "\t" + TREE_NAMES.get(largest.getSpec()) + ", " + largest.getDiameter() + " INCHES IN DIAMETER\n";
        output += "\t" + largest.getStreet() + " (" + largest.getCross1() + ", " + largest.getCross2() + ")\n";
        output += "\t" + largest.getZip();
        return output + "\n";
    }

}
