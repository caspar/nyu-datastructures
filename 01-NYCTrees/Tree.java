import java.io.*;
import java.util.*;

//Caspar Lant

/* Notes
 * create primary arraylist
 * create secondary arrqaylists sorted by various params (ie. sipcode, type, etc)
 *
 */

public class Tree{

    private int treeID    = 0;
    private int specode   = 0;
    private int zipcode   = 0;
    private int diameter  = 0;
    private int condition = 0;
    private String boro         = "";
    private String streetName   = "";
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
        this.treeID = treeID;
        return;
    }

    public int getSpec(){
        return this.specode;
    }

    public void setSpec(int specode){
        this.specode = specode;
        return;
    }

    public int getZip(){
        return this.zipcode;
    }

    public void setZip(int zipcode){
        this.zipcode = zipcode;
        return;
    }

    public int getDiameter(){
        return this.diameter;
    }

    public void setDiameter(int diameter){
        this.diameter = diameter;
        return;
    }

    public int getCond(){
        return this.diameter;
    }

    public void setCond(int diameter){
        this.diameter = diameter;
        return;
    }

    public String getBoro(){
        return this.boro;
    }

    public void setBoro(String boro){
        this.boro = boro;
        return;
    }

    public String getStreet(){
        return this.streetName;
    }

    public void setStreet(String streetName){
        this.streetName = streetName;
        return;
    }

    public String getCross1(){
        return this.crossStreet1;
    }

    public void setCross1(String crossStreet1){
        this.crossStreet1 = crossStreet1;
        return;
    }
        return this.crossStreet2;
    }

    public void setCross2(String crossStreet2){
        this.crossStreet2 = crossStreet2;
        return;
    }
                            

}
