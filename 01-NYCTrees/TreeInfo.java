import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeInfo{

    public String[] parsed;
    //public  String fileName;
    public  String outName;
    private Scanner scanner;
    final int EXT_LEN = 4;

    public static void main(String[] args){
        if(args.length == 0){
            System.exit(0);
        }
        TreeInfo test = new TreeInfo(args[0]);
    }

    public TreeInfo(String file){
        parse(file);
        TreeList list = new TreeList(parsed);
    }

    private void parse(String file){
        outName = file.substring(0, file.length() - EXT_LEN) + ".txt";
        try{
            scanner = new Scanner(new File(file));
            for(int i = 0; scanner.hasNext(); i++){
                parsed[i] = scanner.next();
            }
            scanner.close();
        }catch(Exception oops){}
        System.out.println(parsed.toString());
        return;
    }
}
