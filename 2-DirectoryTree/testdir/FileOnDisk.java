
/*************************************************************
 * This class represents a physical file on a computer's HD. *
 * It acts as a simplified java.io.File Class,               *
 * and stores critical information about the file.           *
 * @author Caspar Lant                                       *
 * @see java.io.File                                         *
 *************************************************************/

public class FileOnDisk implements Comparable<FileOnDisk> {

    //Two Class variables
    String path;
    long size;

    /**
    * FileOnDisk constructor that accepts the file's name and size as parameters
    * @param   path The path to the physical file in memory represented by the abstract FileOnDisk object
    * @param   size The size of this file, calculated by calling the .length() method from java's native File class
    * @return  [Not Applicable]
    */
    public FileOnDisk(String path, long size){
        this.path = path;
        this.size = size;
    }

    /**
    * Compares two FileOnDisk objects, based on size
    * @param  other the FileOnDisk object that the comparison will be based on
    * @return       a signed int, or 0, representing the relationship between the two FileOnDisk objects
    *               returns -1 if other > this, 0 if other == this, and 1 if other < this
    */
    public int compareTo(FileOnDisk other){
        if (this.size == other.size)
        return 0;
        if (this.getSize() > other.getSize())
        return 1;
        return -1;
    }

    /**
    * Returns the file's absolute pathname, without symbolic-link directories.
    * This is done to avoid the duplication of file objects
    * @return the cannonical pathname of the file represented by a FileOnDisk object
    */
    public String getAbsPath(){
        return path;
    }

    /**
    * Returns the FileOnDisk object's size, stored as a class variable
    * Assumes the file's size is less than an exabyte
    * @return the file's length, as a long object
    */
    public long getSize(){
        return size;
    }

    /**
    * Converts the File's size to a human-readable string.
    * First calculates the file size's order of manitude, and appends relevent units
    * @return the File's size formatted with units
    */
    public String toString(){
        long size = this.size; //f.length()??

        if (size < 1024 ) //print bytes
        return String.format("%7.2f bytes ", (float) size) + path;
        else if (size/1024 < 1024 )//print kilobytes
        return String.format("%7.2f KB ", (float) size / 1024.0) + path;
        else if (size/1024/1024 < 1024 )//print megabytes
        return String.format("%7.2f MB ", (float) size / (1024.0 * 1024)) + path;
        else //print gigabytes
        return String.format("%7.2f GB ", (float) size / (1024.0 * 1024 * 1024)) + path;
    }

}
