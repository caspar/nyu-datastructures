import java.util.Arrays;
import java.util.Random;

public class MyTester{

    static private Random rand = new Random(0);

    public static void main(String[] args){
        int arraySize = 20;

		Integer[] list = generateRandomIntegerArray(arraySize);
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
