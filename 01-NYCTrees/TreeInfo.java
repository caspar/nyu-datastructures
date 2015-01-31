import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeInfo{

    private String[][] parsed;
    //public  String fileName;
    public  String outName;
    private Scanner scanner;
    final int EXT_LEN = 4;

    public static final Hashtable<String, String> TREES = new Hashtable<String, String>(36);

    public static void main(String[] args){
        if(args.length == 0){
            System.exit(0);
        }
        TreeInfo test = new TreeInfo(args[0]);
        TreeList list = new TreeList();
    }

    public TreeInfo(String file){
        makeHash();
        parse(file);
    }

    private void parse(String file){
        outName = file.substring(0, file.length() - EXT_LEN) + ".txt";
        try{
            scanner = new Scanner(new File(file));
            scanner.useDelimiter("\\s*,\\s*");
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
            scanner.close();
        }catch(Exception oops){}

        for(int i = 0; scanner.hasNext(); i++){

        }
        return;
    }

    private final void makeHash(){
        TREES.put("UNK",    "Unknown");
        TREES.put("AC",     "Other Maple");
        TREES.put("ACCA",   "Hedge Maple");
        TREES.put("ACGI",   "Amur Maple");
        TREES.put("ACNE",   "Box Elder");
        TREES.put("ACPA",   "Norway Maple");
        TREES.put("ACPLCR", "Norway Crimson King Maple");
        TREES.put("ACPS",   "Sycamore Maple");
        TREES.put("ACRU",   "Red Maple");
        TREES.put("ACSA1",  "Silver Maple");
        TREES.put("AECA",   "Red Horsechestnut");
        TREES.put("AEHI",   "Horsechestnut");
        TREES.put("AIAL",   "Tree of Heaven");
        TREES.put("ALGL",   "European Alder");
        TREES.put("AM",     "Serviceberry");
        TREES.put("BE",     "Birch");
        TREES.put("CABE",   "European Hornbeam");
        TREES.put("CA",     "CATALPA CATALPA");
        TREES.put("CACA",   "American Hornbeam");
        TREES.put("CEAT",   "Cedar");
        TREES.put("CECA",   "Eatern Redbud");
        TREES.put("CEJA",   "Katsura Tree");
        TREES.put("CEOC",   "Hackberry");
        TREES.put("CHVI",   "Fringe Tree");
        TREES.put("CLLU",   "Yellowood");
        TREES.put("COCO2",  "Turkish Hazelnut");
        TREES.put("COFL",   "Flowering Dogwood");
        TREES.put("COKO",   "Kousa Dogwood");
        TREES.put("COMA",   "Cornelian Cherry");
        TREES.put("CR",     "Hawthorn");
        TREES.put("DIVI",   "Common Persimmon");
        TREES.put("EUUL",   "Hardy Rubber Tree");
        TREES.put("FAGR",   "American Beech");
        TREES.put("FASY",   "European Beech");
        return;
    }
}
