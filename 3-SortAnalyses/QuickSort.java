/** My implementation of the famous quicksort algorithm
 * @author Caspar Lant
 * @see report.pdf
 */
public class QuickSort<E extends Comparable<E> > implements Sorter<E> {

    private E[] arr;  //Unsorted array is stored as a class variable to increase runtime efficiency
    private int SIZE; //Size of array is stored as a class variable because it is refenced with some frequency

    /**
     * Required by the Sorter interface.
     * Orders the values of an array of generic-types by way of their compareTo(E) methods.
     * @param list array of Objects to be sorted
     */
    public void sort(E[] list ){
        arr = list;
        SIZE = arr.length;
        System.out.println(SIZE);
        quickSort(0, SIZE - 1);
    }

    /**
     * quicksort(int, int) method. Confirms that the unsorted (sub)array contains more than one object,
     * determines the index of pivot by calling split(int, int), and
     * calls itself, recursively, after having split the original subarray into two (around the pivot point)
     * @param  left bound of the unsorted subarray -- the beginning
     * @param  right bound of the unsorted subarray -- the end
     */
    public void quickSort(int left, int right){
        if (left < right){
            int pivotIndex = split(left, right); //returns splitpoint
            quickSort(left, pivotIndex - 1);
            quickSort(pivotIndex + 1, right);
        }
    }

    /**
     * Split method drawn from textbook's pseudocode.
     * Stores a local variable of Boolean type to verify that a value is on the correct side of the pivot point
     * (stored as a local variable of type E in the first line)
     * @param   left bound of the unsorted subarray -- the beginning
     * @param   right bound of the unsorted subarray -- the end
     * @return  the index of the pivot point
     */
    private int split(int left, int right){
        E pivot = arr[left]; //middle
        int leftIndex = left;
        left++;
        boolean onCorrectSide; //defaults to true

        do {
            onCorrectSide = true;
            while (onCorrectSide){
                if (arr[left].compareTo(pivot) >= 0){
                    onCorrectSide = false;
                }
                else{
                    left++;
                    onCorrectSide = (left <= right);
                }
            }

            onCorrectSide = (left <= right);

            while (onCorrectSide){
                if (arr[right].compareTo(pivot) < 0){
                    onCorrectSide = false;
                }
                else{
                    right--;
                    onCorrectSide = (left <= right);
                }
            }

            if (left < right){
                swap(left, right);
                left++;
                right--;
            }
        } while (left <= right);

        swap(leftIndex, right);
        return right;
    }

    /**
     * Quickly calculates the median of the first three values of arr[].
     * Assumes an array of int primitives for brevity's sake.
     * This method is not implemented in QuickSort.java, but included for reference.
     * @param  first the first index of an unsorted subarray
     * @return       the value of the median of the first three values in aforementioned subarray.
     */
    // private int median(int first){
    //     int a = arr[first  ];
    //     int b = arr[first+1];
    //     int c = arr[first+2];
    //     if ((a - b) * (c - a) >= 0){
    //         return a;
    //     }
    //     if ((b - a) * (c - b) >= 0 && (b <= c || (b <= a && b >= c))){
    //         return b;
    //     }
    //     return c;
    // }

    /**
     * Creates a temporary array to store one value (at index left)
     * while it is replaced by another (at index right).
     * Subsequently copies the stored value to index right
     * @param  index of first object to swap
     * @param  index of second object to swap
     */
    private void swap(int left,int right){
        E temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
