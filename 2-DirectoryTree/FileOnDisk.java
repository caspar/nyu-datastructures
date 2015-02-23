public class FileOnDisk implements Comparable<FileOnDisk>{

    private int size = 0;
    public FileOnDisk(){
    }

    public int compareTo(FileOnDisk other){
        if (this.getSize() = other.getSize())
            return 0;
        if (this.getSize() > other.getSize())
            return 1;
        return -1;
    }

    public String getAbsPath(){

    }

    public long getSize(){

    }

    public String toString(){

    }

    // public Boolean equals(Object obj){
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (this.getClass() != obj.getClass())
    //         return false;
    //     if (this.getSize() != obj.getSize())
    //         return false;
    //
    //     return true;


    }
}
