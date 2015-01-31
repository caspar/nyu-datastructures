import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeInfo{

    public static final Hashtable<String, String> TREES = new Hashtable<String, String>(36);

    public String fileName;
    public String outName;
    public static void main(String[] args){
        TreeInfo test = new TreeInfo();
        TreeList list = new TreeList();
        test.fileName = args[0];
        try{
            Scanner scanner = new Scanner(new File(test.fileName));
            scanner.useDelimiter("\\s*,\\s*");
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
            scanner.close();
        }catch(Exception oops){}
        test.outName  = test.fileName.substring(0,test.fileName.length()-4)+".txt";
        System.out.println(test.outName);
        test.makeHash();
        //System.out.println(TREES.toString());
    }

    private void parse(){
            for(int i = 0; scanner.hasNext

        }
    }
    private final void makeHash(){
        TREES.put("UNK",   "Unknown");
        TREES.put("AC",    "Other Maple");
        TREES.put("ACCA",  "Hedge Maple");
        TREES.put("ACGI",  "Amur Maple");
        TREES.put("ACNE",  "Box Elder");
        TREES.put("ACPA",  "Japanese Maple");
        TREES.put("ACPL",  "Norway Maple");
        TREES.put("ACPLCR","Norway Crimson King Maple");
        TREES.put("ACPS",  "Sycamore Maple");
        TREES.put("ACRU",  "Red Maple");
        TREES.put("ACSA1", "Silver Maple");
        TREES.put("AECA",  "Red Horsechestnut");
        TREES.put("AEHI",  "Horsechestnut");
        TREES.put("AIAL",  "Tree of Heaven");
        TREES.put("ALGL",  "European Alder");
        TREES.put("AM",    "Serviceberry");
        TREES.put("BE",    "Birch");
        TREES.put("CABE",  "European Hornbeam");
        TREES.put("CA",    "CATALPA CATALPA");
        TREES.put("CACA",  "American Hornbeam");
        TREES.put("CA",    "Hickory");
        TREES.put("CEAT",  "Cedar");
        TREES.put("CECA",  "Eatern Redbud");
        TREES.put("CEJA",  "Katsura Tree");
        TREES.put("CEOC",  "Hackberry");
        TREES.put("CHVI",  "Fringe Tree");
        TREES.put("CLLU",  "Yellowood");
        TREES.put("COCO2", "Turkish Hazelnut");
        TREES.put("COFL",  "Flowering Dogwood");
        TREES.put("COKO",  "Kousa Dogwood");
        TREES.put("COMA",  "Cornelian Cherry");
        TREES.put("CR",    "Hawthorn");
        TREES.put("DIVI",  "Common Persimmon");
        TREES.put("EUUL",  "Hardy Rubber Tree");
        TREES.put("FAGR",  "American Beech");
        TREES.put("FASY",  "European Beech");
        return;
    }
}
