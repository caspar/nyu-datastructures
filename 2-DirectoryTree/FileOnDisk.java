
/**
*
* @author Caspar Lant
* @see java.io.File
*/
public class FileOnDisk implements Comparable<FileOnDisk> {


    File f;
    String path = "";
    long size = 00;

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
    */
    public int compareTo(FileOnDisk other){
        if (this.size == other.size)
        return 0;
        if (this.getSize() > other.getSize())
        return 1;
        return -1;
    }

    /**
    * Returns the file's absolute pathname
    * @return the cannonical pathname of the file represented by a FileOnDisk object
    */
    public String getAbsPath(){
        return path;
    }

    /**
    * Returns the FileOnDisk object's size by calling the wrapped File object's length() method
    * @return the file's length, as a long object
    */
    public long getSize(){
        return size;
    }

    /**
    * Converts the File's size to a human-readable string
    * @return the File's size formatted with units
    */
    public String toString(){
        long size = this.size; //f.length()??

        if (size < 1024 ) //print bytes
        return String.format("%7.2f bytes", (float) size  );
        else if (size/1024 < 1024 )//print kilobytes
        return String.format("%7.2f KB", (float) size / 1024.0 );
        else if (size/1024/1024 < 1024 )//print megabytes
        return String.format("%7.2f MB", (float) size / (1024.0 * 1024));
        else //print gigabytes
        return String.format("%7.2f GB", (float) size / (1024.0 * 1024*1024));
    }

}
