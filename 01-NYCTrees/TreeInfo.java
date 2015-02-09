import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeInfo{

    public String[] parsed = new String[92];
    //public  String fileName;
    public String outName;
    public File outFile;
    public static int ENTRIES = 0;
    TreeList list;

    public static void main(String[] args){
        if(args.length == 0){
            System.err.println("No file specified");
            System.exit(0);
        }
        TreeInfo test = new TreeInfo(args[0]);
        //test.writeFile();
    }
    public TreeInfo(String file){
        parse(file);
        list = new TreeList(parsed);
        writeFile();
    }

    private void parse(String file){
        if (file.contains(".")){
            outName = file.substring(0, file.lastIndexOf('.')) + ".out"; //yummy!
        }
        else{
            outName = file + ".out";
        }
        //System.out.println(outName);
        try{
            File f = new File(file);
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\n");
            scanner.next(); //skip first line
            while(scanner.hasNext()){
                parsed[ENTRIES++] = scanner.next();
            }
            scanner.close();
        }catch(Exception oops){
            System.err.println("File not found");
        }
        //System.out.println(Arrays.toString(parsed));
        return;
    }
    public void writeFile(){
        try{
            PrintWriter pw = new PrintWriter(outName);
            pw.println(list.largest());
            pw.close();
        }catch(Exception oops){
            System.out.println("oopsies");
        }


    }
}
