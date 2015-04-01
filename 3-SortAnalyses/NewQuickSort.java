public class NewQuickSort<E extends Comparable<E> >{

    public E[] array;
    public int SIZE;

    public NewQuickSort(E[] list){
        SIZE = list.length;
        array = new E[SIZE]
        quickSort(0, SIZE-1);
    }

    quickSort(int left, int right){
        pivot = array[pivotIndex(left, right)];
        swap(pivotIndex, right);
        int firstRight = partition(left, right -1, array[right]);
        swap(firstRight, right);
        if ((k-i) > 1) quicksort(A, i, k-1);  // Sort left partition
        if ((j-k) > 1) quicksort(A, k+1, j);  // Sort right partition
    }

    public int partition(int left, int right, E pivot){
        while (left <= right){
            while(array[left].compareTo(pivot) < 0){
                left++;
            }
            while(right >= left && array[right].compareTo(pivot) >= 0){
                right--;
            }
            if(right > left){
                swap(right, left);
            }
        }
        return left;
    }

    public int pivotIndex(int left, int right){
        return (left+right)/2);
    }

    private void swap(int left,int right){
        E temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
