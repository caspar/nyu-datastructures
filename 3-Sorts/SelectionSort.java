import java.io.*;
import java.util.*;

public class SelectionSort<E extends Comparable<E> > implements Sorter<E> {

    private E[] values;
    private int SIZE;

    public void sort(E[] list){
        values = list;
        SIZE = values.length;
        System.out.println(SIZE);
        selectionSort(0);
        //System.out.println(Arrays.toString(values));
    }

    public void selectionSort(int first){
        if ( first >= SIZE - 1 ){
            return;
        }
        int mindex = first;
        for ( int i = first + 1; i < SIZE; i++ )
        {
            if (values[i].compareTo(values[mindex]) < 0)
            mindex = i;
        }
        swap(first, mindex);
        // int temp = values[first];
        // values[first] = values[mindex];
        // values[mindex] = temp;
        selectionSort(first + 1);
    }

    public int minIndex(int first, int last){
        int mindex = first;
        for (int i = first + 1; i <= last; i++){
            if (values[i].compareTo(values[mindex]) < 0){
                mindex = i;
            }
        }
        return mindex;
    }

    private void swap(int left,int right){
        E temp = values[left];
        values[left] = values[right];
        values[right] = temp;
    }
}
