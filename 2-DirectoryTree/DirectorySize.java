public class DirectorySize(){

    /*********************************************************************
     * computes the total size of all the files and sub-directories,     *
     * prints a list of n largest files (their sizes and absolute paths) *
     *********************************************************************/

    int numFiles = 0;
    String PATH = "";
    public static void main(String[] args){
        PATH = args[0];
        numFiles = Integer.parseInt(args[1]);
    }

    public Boolean containsLetter(String input){
        for (int i = 0; i < input.length(); i++){
            if (input.charAt().equals("/D"))
                return false;
        }
        return true;
    }


}
