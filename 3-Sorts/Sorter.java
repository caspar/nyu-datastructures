
/**
 * The interface for the implementation of different sort algorithms.
 *
 * @author Joanna Klukowska
 *
 * @param <E> The type of objects that this Sorter objects expects in
 *                       the list to be sorted.
 */
interface Sorter <E extends Comparable <E> >{

	/**
	 * Sorts the list according to the natural ordering of its elements
	 * from smallest to largest. The list is modified.
	 * @param list array of elements to be sorted
	 */

	/**
	 * This is an interface that you have to implement for your implementations of merge sort, quick sort and selection sort.
	 * For each of the three algorithms you have to provide a class that implements the Sorter interface.
	 * In order to work with SortTester, your classes need to be called MergeSort, QuickSort, and SelectionSort.
 	 */

	public void sort(  E[] list );
}
