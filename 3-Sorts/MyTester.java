import java.util.Arrays;
import java.util.Random;

public class MyTester{

    static private Random rand = new Random(0);

    public static void main(String[] args){
        int arraySize = 20;

		Integer[] list = {1, 4, 3, 5, 7, 8, 4, 2, 3, 5, 7, 3, 4, 5, 7, 2, 4, 1, 2, 6, 8, 9, 9, 2, 4 , 1};
		Sorter<Integer> arrayIntSorter;
		System.out.printf("\nArray size: %d", arraySize);
		System.out.printf("\nRunning merge sort: ");
		arrayIntSorter = new MergeSort<Integer>();
        arrayIntSorter.sort(list);
    }

    public static Integer[] generateRandomIntegerArray(int size) {
        Integer list[] = new Integer[size];
        for (int i = 0; i < list.length; i++)
            list[i] = rand.nextInt();
        return list;
    }
}
