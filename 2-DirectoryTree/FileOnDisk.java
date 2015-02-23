public class FileOnDisk implements Comparable<FileOnDisk>{

    private int size = 0;
    public FileOnDisk(){
        //empty constructor
    }

    public FileOnDisk(String name){
        File f = new File(name);
        size = new
    }

    public int compareTo(FileOnDisk other){
        if (this.getSize() = other.getSize())
            return 0;
        if (this.getSize() > other.getSize())
            return 1;
        return -1;
    }

    public String getAbsPath(){
        f.getCannonicalPath();
    }

    public long getSize(){
        f.length();
    }

    public String toString(){
        long size = this.getSize(); //f.length()??
        if (size < 1024)
            return size + "Bytes";
        if (size/1024 < 1024)
            return (float) size/(1024.0) + "KiloBytes";
        if (size/(1024*1024) < 1024)
            return (float) size/(1024.0*1024) + "MegaBytes";
        return (float) size/(1024.0*1024*1024) + "GigaBytes";
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
