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
        test.fileName = args[0];
        try{
            Scanner scanner = new Scanner(new File(test.fileName));
            scanner.useDelimiter("\\s*,\\s*");
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
            scanner.close();
        }catch(Exception oops){}
        test.outName  = test.fileName.substring(0,test.fileName.length()-2)+".txt";
        System.out.println(test.outName);
        test.makeHash();
        //System.out.println(TREES.toString());
    }

    private final void makeHash(){
        TREES.put("UNK",   "UNKNOWN");
        TREES.put("AC",    "MAPLE, OTHER ACER SPECIES");
        TREES.put("ACCA",  "MAPLE, HEDGE ACER CAMPESTRE");
        TREES.put("ACGI",  "MAPLE, AMUR ACER GINNALA");
        TREES.put("ACNE",  "BOXELDER ACER NEGUNDO");
        TREES.put("ACPA",  "MAPLE, JAPANESE ACER PALMATUM");
        TREES.put("ACPL",  "MAPLE, NORWAY ACER PLATANOIDES");
        TREES.put("ACPLCR","MAPLE, NORWAY-CR KNG ACER PLATANOIDES CRIMSON KING");
        TREES.put("ACPS",  "MAPLE, SYCAMORE ACER PSEUDOPLATANUS");
        TREES.put("ACRU",  "MAPLE, RED ACER RUBRUM");
        TREES.put("ACSA1", "MAPLE, SILVER ACER SACCHARINUM");
        TREES.put("AECA",  "HORSECHESTNUT, RED AESCULUS X CARNEA");
        TREES.put("AEHI",  "HORSECHESTNUT AESCULUS HIPPOCASTANUM");
        TREES.put("AIAL",  "TREE OF HEAVEN AILANTHUS ALTISSIMA");
        TREES.put("ALGL",  "ALDER, EUROPEAN ALNUS GLUTINOSA");
        TREES.put("AM",    "SERVICEBERRY, OTHER AMELANCHIER SPECIES");
        TREES.put("BE",    "BIRCH, OTHER BETULA SPECIES");
        TREES.put("CABE",  "HORNBEAM, EUROPEAN CARPINUS BETULUS");
        TREES.put("CA",    "CATALPA CATALPA");
        TREES.put("CACA",  "HORNBEAM, AMERICAN CARPINUS CAROLINIANA");
        TREES.put("CA",    "HICKORY CARYA");
        TREES.put("CEAT",  "CEDAR, ATLAS CEDRUS ");
        TREES.put("CECA",  "REDBUD, EASTERN CERCIS CANADENSIS");
        TREES.put("CEJA",  "KATSURA TREE CERCIDIPHYLLUM JAPONICUM");
        TREES.put("CEOC",  "HACKBERRY CELTIS OCCIDENTALIS");
        TREES.put("CHVI",  "FRINGE TREE CHIONANTHUS VIRGINICUS");
        TREES.put("CLLU",  "YELLOWOOD CLADRASTIS LUTEA");
        TREES.put("COCO2", "TURKISH HAZELNUT CORYLUS COLURNA");
        TREES.put("COFL",  "DOGWOOD, FLOWERING CORNUS FLORIDA");
        TREES.put("COKO",  "DOGWOOD, KOUSA CORNUS KOUSA");
        TREES.put("COMA",  "CHERRY, CORNELIAN CORNUS MAS");
        TREES.put("CR",    "HAWTHORN, OTHER CRATAEGUS SPECIES");
        TREES.put("DIVI",  "PERSIMMON, COMMON DIOSPYROS VIRGINIANA");
        TREES.put("EUUL",  "HARDY RUBBER TREE EUCOMMIA ULMOIDES");
        TREES.put("FAGR",  "BEECH AMERICAN FAGUS GRANDIFOLIA");
        TREES.put("FASY",  "BEECH EUROPEAN FAGUS SYLVATICA ");
        return;
    }
}
