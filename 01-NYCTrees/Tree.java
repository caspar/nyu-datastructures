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
    private int zipcode   = 0;
    private int diameter  = 0;
    private int condition = 0;
    private String specode   = "";
    private String boro      = "";
    private String strName   = "";
    private String crossStr1 = "";
    private String crossStr2 = "";

    public Tree(String[] data){
        System.out.println(data.toString());
        this.treeID    = Integer.parseInt(data[0]);
        this.strName   = data[1];
        this.crossStr1 = data[2];
        this.crossStr2 = data[3];
        this.condition = Integer.parseInt(data[4]);
        this.diameter  = Integer.parseInt(data[5]);
        this.specode   = data[6];
        this.boro      = data[7];
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

    public int getID(){
        return treeID;
    }

    public void setID(int treeID){
        this.treeID = treeID;
        return;
    }

    public String getSpec(){
        return this.specode;
    }

    public void setSpec(String specode){
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
        return this.strName;
    }

    public void setStreet(String strName){
        this.strName = strName;
        return;
    }

    public String getCross1(){
        return this.crossStr1;
    }

    public void setCross1(String crossStr1){
        this.crossStr1 = crossStr1;
        return;
    }

    public String getCross2(){
        return this.crossStr2;
    }

    public void setCross2(String crossStr2){
        this.crossStr2 = crossStr2;
        return;
    }

}
