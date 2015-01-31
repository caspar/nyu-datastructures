import java.io.*;
import java.util.*;
//Caspar Lant

public class TreeList{


    ArrayList trees = new ArrayList();
    //for each line in .csv file, create new tree object with parameters given by that line
    /* to represent all the Tree objects in a single container. TreeList class should store all the Tree objects in
    an ArrayList of trees (depending on your design, you may use more than one such ArrayList). This class should provide
    methods that return the results needed by the five tasks described in the previous section. */

    public TreeList(String[][] array){

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

    public String largest(ArrayList a){
        //if there's a tie, return all
        return "";
    }

}
