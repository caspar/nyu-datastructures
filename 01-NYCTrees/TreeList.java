import java.io.*;
import java.util.*;
//Caspar Lant

public class TreeList{

    ArrayList trees = new ArrayList();
    public final Hashtable<String, String> TREE_NAMES = new Hashtable<String, String>(36);
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
    }

    public TreeList(){

    }
    public String mostPopular(ArrayList a){//I don't really need to pass it in if I store it as a class variable...
        //sorts by frequency (tree type?) returns first three
        return "";
    }

    public String leastPopular(ArrayList a){
        //sorts by frequency (tree type?) returns last three
        return "";
    }

    public String mostGreen(ArrayList a){
        //sorts by ZC, returns top 3
        return "";
    }

    public String leastGreen(ArrayList a){
        return "";
    }

    public String largest(){
        //if there's a tie, return all
        //int largest = 0;
        Tree largest; //IDK if it's better to store a Tree object or a local int. Do a speed test?
        for (Tree current : trees){
            if (current.getDiameter() > largest.getDiameter()){
                largest = current;
            }
        }
        output  = TREE_NAMES.get(largest.getID()) + ", " + largest.getDiameter() + " inches in diameter\n";
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
        trees.add(new Tree(input.split(",")));
    }

    private final void makeHash(){
        TREE_NAMES.put("UNK",    "Unknown");
        TREE_NAMES.put("AC",     "Other Maple");
        TREE_NAMES.put("ACCA",   "Hedge Maple");
        TREE_NAMES.put("ACGI",   "Amur Maple");
        TREE_NAMES.put("ACNE",   "Box Elder");
        TREE_NAMES.put("ACPA",   "Norway Maple");
        TREE_NAMES.put("ACPLCR", "Norway Crimson King Maple");
        TREE_NAMES.put("ACPS",   "Sycamore Maple");
        TREE_NAMES.put("ACRU",   "Red Maple");
        TREE_NAMES.put("ACSA1",  "Silver Maple");
        TREE_NAMES.put("AECA",   "Red Horsechestnut");
        TREE_NAMES.put("AEHI",   "Horsechestnut");
        TREE_NAMES.put("AIAL",   "Tree of Heaven");
        TREE_NAMES.put("ALGL",   "European Alder");
        TREE_NAMES.put("AM",     "Serviceberry");
        TREE_NAMES.put("BE",     "Birch");
        TREE_NAMES.put("CABE",   "European Hornbeam");
        TREE_NAMES.put("CA",     "CATALPA CATALPA");
        TREE_NAMES.put("CACA",   "American Hornbeam");
        TREE_NAMES.put("CEAT",   "Cedar");
        TREE_NAMES.put("CECA",   "Eatern Redbud");
        TREE_NAMES.put("CEJA",   "Katsura Tree");
        TREE_NAMES.put("CEOC",   "Hackberry");
        TREE_NAMES.put("CHVI",   "Fringe Tree");
        TREE_NAMES.put("CLLU",   "Yellowood");
        TREE_NAMES.put("COCO2",  "Turkish Hazelnut");
        TREE_NAMES.put("COFL",   "Flowering Dogwood");
        TREE_NAMES.put("COKO",   "Kousa Dogwood");
        TREE_NAMES.put("COMA",   "Cornelian Cherry");
        TREE_NAMES.put("CR",     "Hawthorn");
        TREE_NAMES.put("DIVI",   "Common Persimmon");
        TREE_NAMES.put("EUUL",   "Hardy Rubber Tree");
        TREE_NAMES.put("FAGR",   "American Beech");
        TREE_NAMES.put("FASY",   "European Beech");
        return;
    }
}
