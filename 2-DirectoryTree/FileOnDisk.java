public class FileOnDisk implements Comparable<FileOnDisk>{

    private int size = 0;
    public FileOnDisk(){
    }

    public int compareTo(FileOnDisk other){
        return -1;
    }

    public Boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        if (


        return true;


    }
}
