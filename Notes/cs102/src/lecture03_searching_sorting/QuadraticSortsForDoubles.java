package lecture03_searching_sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Demonstrates the relative performance of quadratic sort methods:
 * insertion sert, selection sort and bubble sort.
 *
 * @author Joanna Klukowska
 *
 */
public class QuadraticSortsForDoubles {

	public static void main(String[] args) {

		//run each of the sorts on a small array so that
		//we know all three methods are loaded into the memory
		double [] tmp;
		tmp = generateRandomDoubleArray( 100 );
		double [] tmp1 = copyArray (tmp );
		selectionSort(tmp1);
		tmp1 = copyArray (tmp );
		insertionSort(tmp1);
		tmp1 = copyArray (tmp );
		bubbleSort(tmp1);

		//get the size of the test array from the user
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the size for the testing array: ");
		int size = in.nextInt();


		long start, end;
		tmp = generateRandomDoubleArray( size );



		//time the insertion sort method
		tmp1 = copyArray (tmp );
		System.gc();

		start = System.nanoTime();
		insertionSort(tmp1);
		end = System.nanoTime();

		if ( isSorted (tmp1 ) )
			System.out.printf("insertionSort took %12d nanoseconds (%.6f seconds)\n\n",
					end - start, (end-start)/1000000000.0);

		//time the bubble sort method
		tmp1 = copyArray (tmp );
		System.gc();

		start = System.nanoTime();
		bubbleSort(tmp1);
		end = System.nanoTime();

		if ( isSorted (tmp1 ) )
			System.out.printf("   bubbleSort took %12d nanoseconds (%.6f seconds)\n\n",
					end - start, (end-start)/1000000000.0);


		//time the selection sort method
		tmp1 = copyArray (tmp );
		System.gc();

		start = System.nanoTime();
		selectionSort(tmp1);
		end = System.nanoTime();

		if ( isSorted (tmp1 ) )
			System.out.printf("\nselectionSort took %12d nanoseconds (%.6f seconds)\n\n",
					end - start, (end-start)/1000000000.0);



	}

	/**
	 * Generates an array of random numbers of type double.
	 * @param size  number of elements in the generated array
	 * @return  an array of specified size filled with random
	 * values
	 */
	public static double[] generateRandomDoubleArray(int size) {
		double list[] = new double[size];
		Random rand = new Random();

		for (int i = 0; i < list.length; i++)
			list[i] = rand.nextDouble();
		return list;
	}

	/**
	 * Determines if the given array is in sorted order or not.
	 * @param list array to test
	 * @return true if the array is sorted, false otherwise
	 */
	public static  boolean isSorted ( double [] list )
	{
		for (int i = 1; i < list.length; i++) {
			if (list[i-1] > ( list[i] )  )
				return false;
		}
		return true;
	}

	/**
	 * Creates a duplicate of a given array.
	 * @param list array to duplicate
	 * @return a copy of the given array
	 */
	public static double[] copyArray ( double [] list ) {
		double listCopy[] = new double[list.length];
		for (int i = 0; i < list.length; i++)
			listCopy[i] = list[i];
		return listCopy;
	}


	/**
	 * Sorts the given array using selection sort algorithm.
	 * @param list array to sort.
	 */
	public static void selectionSort(double[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			double currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

			// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}

	/**
	 * Sorts the given array using insertion sort algorithm.
	 * @param list array to sort.
	 */
	public static void insertionSort(double[] list) {
		for (int i = 1; i < list.length; i++) {
			/*
			 * insert list[i] into a sorted sublist list[0..i-1] so that
			 * list[0..i] is sorted.
			 */
			double currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
			}

			// Insert the current element into list[k+1]
			list[k + 1] = currentElement;
		}
	}

	/**
	 * Sorts the given array using bubble sort algorithm.
	 * @param list array to sort.
	 */
	public static void bubbleSort(double[] list) {
		double tmp;
		for (int i = 0; i < (list.length - 1); i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j] > list[j + 1])
				{
					tmp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = tmp;
				}
			}
		}
	}


}
