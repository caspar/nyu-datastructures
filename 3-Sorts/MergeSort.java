/** My non-recursive implementation of the mergesort algorithm
 * @author Caspar Lant
 * @see report.pdf
 */
public class MergeSort<E extends Comparable<E> > implements Sorter<E> {

    private E[] arr;  //Unsorted array is stored as a class variable to increase runtime efficiency
    private int SIZE; //Size of array is stored as a class variable because it is refenced with some frequency

    /**
     * Required by the Sorter interface.
     * Orders the values of an array of generic-types by way of their compareTo(E) methods.
     * @param list array of Objects to be sorted
     */
    public void sort(E[] list){
        arr = list;
        SIZE = arr.length;
        mergeSort(0, SIZE - 1);
    }

    /**
     * mergeSort(int, int) method. Confirms that the unsorted (sub)array contains more than one object,
     * determines the middle by evaluating (first+ last)/2 , and
     * calls itself, recursively, after having split the original subarray into two (around the middle)
     * @param  left bound of the unsorted subarray -- the beginning
     * @param  right bound of the unsorted subarray -- the end
     */
    private void mergeSort(int first, int last){
        if (last > first){
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }

    /**
     * Merges two subarrays (subsections) of the class variable arr
     * Creates an empty array of objects, temp.
     * Iterates over both subarrays while they both cotain elements.
     * When either subarray is exhausted, merge(int, int, int, int) dumps the contents of the remaining subarray into temp.
     * Passes the sorted values from temp into the main array, type-casting as it goes.
     * @param  f1 - the left bound of the first unsorted subarray.
     * @param  r1 - the right bound of the first unsorted subarray.
     * @param  f2 - the left bound of the second unsorted subarray.
     * @param  r2 - the rught bound of the second unsorted subarray.
     */
    @SuppressWarnings("unchecked")
    private void merge(int f1, int r1, int f2, int r2){
        Object[] temp = new Object[r2-f1+1]; // Type-Casting to get around Generic Array creation error
        int i = 0;
        int firstIndex = f1; //to Remember where I started. (r2 - temp.length + 1 does not work any better
        while (f1 <= r1 && f2 <= r2){
            if (arr[f1].compareTo(arr[f2]) <= 0){
                temp[i++] = arr[f1++];
            }
            else{
                temp[i++] = arr[f2++];
            }
        }
        while (f1 <= r1){
            temp[i++] = arr[f1++];
        }
        while (f2 <= r2){
            temp[i++] = arr[f2++];
        }
        int j = 0;
        for (i = firstIndex; i <= r2; i++){
            arr[i] = (E) temp[j++]; //type-casting as generic; poor form?
        }
    }
}
