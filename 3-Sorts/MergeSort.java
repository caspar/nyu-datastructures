import java.io.*;
import java.util.*;

public class MergeSort<E extends Comparable<E> > implements Sorter<E> {

    private E[] values;
    private int SIZE;

    public MergeSort(){
    }

    public MergeSort(E[] list){
        sort(list);
    }

    public void sort(E[] list){
        values = list;
        SIZE = values.length;
        mergeSort(0, SIZE - 1);
        System.out.println(Arrays.toString(values));
    }

    private void mergeSort(int first, int last){
        if (last > first){
            int pivot = (first + last) / 2;
            mergeSort(first, pivot);
            mergeSort(pivot + 1, last);
            merge(first, pivot, pivot + 1, last);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(int leftFirst, int leftLast, int rightFirst, int rightLast){
        Object[] temp = new Object[SIZE]; // Type-Casting to get around Generic Array creation error
        int i = leftFirst;
        int firstIndex = i; //to Remember where I started. See if (rightLast - temp.length + 1 works any better...)
        while (leftFirst <= leftLast && rightFirst <= rightLast){
            if (values[leftFirst].compareTo(values[rightFirst]) <= 0){
                temp[i] = values[leftFirst];
                leftFirst++;
            }
            else{
                temp[i] = values[rightFirst];
                rightFirst++;
            }
            i++;
        }
        while (leftFirst <= leftLast){
            temp[i] = values[leftFirst];
            leftFirst++; i++;
        }
        while (rightFirst <= rightLast){
            temp[i] = values[rightFirst];
            rightFirst++; i++;
        }
        for (i = firstIndex; i <= rightLast; i++){
            values[i] = (E) temp[i];
        }
    }
}
