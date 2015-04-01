public class SelectionSort<E extends Comparable<E> > implements Sorter<E> {

    private E[] arr;  //Unsorted array is stored as a class variable to increase runtime efficiency
    private int SIZE; //Size of array is stored as a class variable because it is refenced with some frequency

    /**
     * Required by the Sorter interface.
     * Orders the arr of an array of generic-types by way of their compareTo(E) methods.
     * @param list array of Objects to be sorted
     */
    public void sort(E[] list){
        arr = list;
        SIZE = arr.length;
        selectionSort();
    }

    /**
     * My non-recursive implementation of the selection sort algorithm.
     * @param first index of subarray
     */
    public void selectionSort(int first){
        if ( first >= SIZE - 1 ){
            return;
        }
        int mindex = first;
        for ( int i = first + 1; i < SIZE; i++ )
        {
            if (arr[i].compareTo(arr[mindex]) < 0)
            mindex = i;
        }
        swap(first, mindex);
        // int temp = arr[first];
        // arr[first] = arr[mindex];
        // arr[mindex] = temp;
        selectionSort(first + 1);
    }

    /**
     * My non-recursive implementation of the selection sort algorithm.
     */
    public void selectionSort(){
        //int endex = SIZE - 1;
        for (int i = 0; i < SIZE - 1; i++){
            swap(i, minIndex(i, SIZE - 1));
        }
    }

    /**
     * Calcuates the index of the minimum value in the specified subarray
     * @param  left bound of the unsorted subarray -- the beginning
     * @param  right bound of the unsorted subarray -- the end
     * @return  the index of the minimum value in the specified subarray
     */
    private int minIndex(int first, int last){
        int mindex = first;
        for (int i = first + 1; i <= last; i++){
            if (arr[i].compareTo(arr[mindex]) < 0){
                mindex = i;
            }
        }
        return mindex;
    }

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
