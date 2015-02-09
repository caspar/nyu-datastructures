import java.io.*;
import java.util.*;

public class MakeHash{

    Map<String, Integer> TREE_NAMES = new Map<String, Integer>();
    public static void main(String[] args){
        MakeHash mh = new MakeHash();
        mh.
    }

    public void makeHash(){
        for
    }
    public void readIn(){
        try{
            File file = new File("species_list.txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimeter("\n");
            while(scanner.hasNext()){
                int firstSpace = scanner.next().IndexOf(" ")
    }
}
