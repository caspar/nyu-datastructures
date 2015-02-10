import java.io.*;
import java.util.*;


/* Notes
* create primary arraylist
* create secondary arrqaylists sorted by various params (ie. zipcode, type, etc)
*
*/

//////////////////////////////////////////////////////////////
//             Proudly written without an IDE               //
//////////////////////////////////////////////////////////////
/*************************************************************
* Tree Class -- contains and provides all tree-related data *
* @author Caspar Lant                                       *
*************************************************************/

public class Tree{

    private int treeID    = 0;
    private int zipcode   = 0;
    private int diameter  = 0;
    private int condition = 0;
    private String specode   = "";
    private String boro      = "";
    private String strName   = "";
    private String crossStr1 = "";
    private String crossStr2 = "";

    public Tree(String[] data){
        //System.out.println(Arrays.toString(data));
        this.treeID    = Integer.parseInt(data[0]);
        this.strName   = data[1].trim();
        this.crossStr1 = data[2].trim();
        this.crossStr2 = data[3].trim();
        this.condition = Integer.parseInt(data[4]);
        this.diameter  = Integer.parseInt(data[5]);
        this.specode   = data[6].trim();
        this.boro      = data[7].trim();
        this.zipcode   = Integer.parseInt(data[8]);
    }

    //TREEID,ONSTREET,CROSSSTREE,CROSSSTR_1,TREECONDIT,DIAMETER,SPECIES,BOROUGH,ZIPCODE
    public Tree(String strName, String crossStr1,String crossStr2, int condition, int diameter, String specode, String boro, int zipcode){
        this.treeID    = treeID;
        this.zipcode   = zipcode;
        this.diameter  = diameter;
        this.condition = condition;
        this.specode   = specode;
        this.boro      = boro;
        this.strName   = strName;
        this.crossStr1 = crossStr1;
        this.crossStr2 = crossStr2;
    }

    /**
    * getID method. Returns the private treeID variable.
    * @return treeID; an int unique to a particular Tree object
    */
    public int getID(){
        return treeID;
    }

    public void setID(int treeID){
        this.treeID = treeID;
        return;
    }

    /**
    * getSpec method. Returns the private specode variable
    * @return [description]
    */
    public String getSpec(){
        return this.specode;
    }

    public void setSpec(String specode){
        this.specode = specode;
        return;
    }

    /**
    * getSpec method. Returns the private specode variable.
    * @return zipcode an int representing the ZIP code in which the physical incarnation of the Tree object is located.
    */
    public int getZip(){
        return this.zipcode;
    }

    public void setZip(int zipcode){
        this.zipcode = zipcode;
        return;
    }

    /**
    * getDiameter method. Returns the private diameter variable.
    * @return diameter of the physical tree this object represents
    */
    public int getDiameter(){
        return this.diameter;
    }

    public void setDiameter(int diameter){
        this.diameter = diameter;
        return;
    }

    /**
    * getBoro method. Returns the private boro variable.
    * @return the New York City borough in which the tree is located
    */
    public String getBoro(){
        return this.boro;
    }

    public void setBoro(String boro){
        this.boro = boro;
        return;
    }

    /**
    * getStreet method. Returns the private strName variable.
    * @return name of the street that the tree lives on.
    */
    public String getStreet(){
        return this.strName;
    }

    public void setStreet(String strName){
        this.strName = strName;
        return;
    }

    /**
    * getCross1 method. Returns the private crossStr1 variable.
    * @return the first of the two cross streets that the tree lives betwixt.
    */
    public String getCross1(){
        return this.crossStr1;
    }

    public void setCross1(String crossStr1){
        this.crossStr1 = crossStr1;
        return;
    }

    /**
    * getCross2 method. Returns the private crossStr2 variable.
    * @return the second of the two cross streets that the tree lives betwixt.
    */
    public String getCross2(){
        return this.crossStr2;
    }

    public void setCross2(String crossStr2){
        this.crossStr2 = crossStr2;
        return;
    }

}
