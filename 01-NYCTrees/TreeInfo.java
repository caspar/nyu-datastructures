import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

////////////////////////////////////////////
//        Proudly written sans IDE        //
////////////////////////////////////////////
/*******************************************
* TreeInfo Class; Main                    *
* Parses command-line prompted file       *
* Passes file's entries to TreeList class *
* @author Caspar Lant                     *
* @version 1.1 02/01/2015                 *
*******************************************/

public class TreeInfo{

    public static ArrayList<String> parsed = new ArrayList<String>();
    public String outName;
    public File outFile;
    public static int ENTRIES = 0;
    TreeList list;

    /**
    * Main method of TreeInfo. Used to instansiate the rest of the program and parse arguments
    * @param args user input. args[0] should be the .csv file to parse
    */
    public static void main(String[] args){
        if(args.length == 0){
            System.err.println("No file specified");
            System.exit(0);
        }
        TreeInfo test = new TreeInfo(args[0]);
        //test.writeFile();
    }

    /**
    * TreeInfo Constructor
    * @param  file user-specified .csv file. Same as args[0] in method main().
    */
    public TreeInfo(String file){
        parse(file);
        list = new TreeList(parsed);
        writeFile();
    }

    /**
    * Parses through user-specified .csv file.
    * Determines name of output file.
    * Adds all Tree entries to ArrayList<String> parsed.
    * @param file user-specified .csv file. Same as args[0] in method main() and file in TreeInfo constructor.
    * @see TreeInfo()
    */
    private void parse(String file){
        if (file.contains(".")){
            outName = file.substring(0, file.lastIndexOf('.')) + ".out"; //yummy!
        }
        else{
            outName = file + ".out";
        }
        System.out.println(outName);
        try{
            File f = new File(file);
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\n");
            scanner.next(); //skip first line
            while(scanner.hasNext()){
                parsed.add(scanner.next());
            }
            scanner.close();
        }catch(FileNotFoundException oops){
            System.err.println("File not found");
        }
        //System.out.println(Arrays.toString(parsed));
        return;
    }

    /**
    * Writes required Tree data to output file.
    */
    public void writeFile(){
        String values = getValues();
        try{
            PrintWriter pw = new PrintWriter(outName);
            pw.println(values);
            pw.close();
        }catch(FileNotFoundException oops){
            System.out.println("Error: File Not Found");
            System.exit(0);
        }
    }

    /**
    * Returns all required TreeData. Invoked by method writeFile().
    * @return calls TreeList methods and concatenates their outputs into a String.
    */
    public String getValues(){
        return list.mostPopular() + list.leastPopular() + list.green() + list.largest();
    }
}
