import java.io.*;
import java.util.*;

//Caspar Lant

/* Notes
 * create primary arraylist
 * create secondary arrqaylists sorted by various params (ie. sipcode, type, etc)
 *
 */

public class Tree{

    private int treeID = 0;
    private int specode = 0;
    private int zipcode = 0;
    private int diameter = 0;
    private int condition = 0;
    private String boro = "";
    private String streetName = "";
    private String crossStreet1 = "";
    private String crossStreet2 = "";

    public static void main(String[] args){
        Tree t = new Tree();
        t.setZip(11201);
        System.out.println(t.getZip());
    }

    public int getID(){
        return treeID;
    }

    public void setID(int treeID){
        treeID = this.treeID;
        return;
    }

    public int getZip(){
        return zipcode;
    }

    public void setZip(int zipcode){
        this.zipcode = zipcode;
    }



}
