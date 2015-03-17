import java.io.*;
import java.util.*;

public class QuickSort<E extends Comparable<E> > implements Sorter<E> {

    private E[] values;
    int SIZE;

    public void sort(E[] list ){
        values = list;
        SIZE = values.length;
        System.out.println(SIZE);
        quickSort(0, SIZE - 1);
        //System.out.println(Arrays.toString(values));
    }

    public void quickSort(int first, int last){
        if (first < last){
            int pivot = split(first, last); //returns splitpoint
            quickSort(first, pivot - 1);
            quickSort(pivot + 1, last);
        }
    }

    private int split(int first, int last){
        E pivot = values[first]; //middle
        int firstIndex = first++;
        boolean onCorrectSide; //deefs to true

        do {
            onCorrectSide = true;
            while (onCorrectSide){
                if (values[first].compareTo(pivot) >= 0){
                    onCorrectSide = false;
                }
                else{
                    first++;
                    onCorrectSide = (first <= last);
                }
            }

            onCorrectSide = (first <= last);

            while (onCorrectSide){
                if (values[last].compareTo(pivot) < 0){
                    onCorrectSide = false;
                }
                else{
                    last--;
                    onCorrectSide = (first <= last);
                }
            }

            if (first < last){
                swap(first, last);
                first++;
                last--;
            }
        } while (first <= last);

        swap(firstIndex, last);
        return last;
    }

    public void swap(int left,int right){
        E temp = values[left];
        values[left] = values[right];
        values[right] = temp;
    }
}
