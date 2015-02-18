/**
 *
 */
//package lecture03_searching_sorting;

import java.util.Arrays;

/**
 * @author asia
 *
 */
public class BinarySearchForPoints {

	/**
	 * @param args ignored
	 */
	public static void main(String[] args) {

		//create an array of Point objects
		int numOfPoints = 10;
		Point [] points = new Point [numOfPoints];

		points[0] = new Point(5,5);
		points[1] = new Point(-3,3);
		points[2] = new Point(2,-2);
		points[3] = new Point(4,-5);
		points[4] = new Point(-4,-5);
		points[5] = new Point(-2,2);
		points[6] = new Point(-4,-5);
		points[7] = new Point(5,-5);
		points[8] = new Point(-5,-4);
		points[9] = new Point(3,-3);

		//binary search assumes a sorted array, so we need to sort the points
		//before applying the search
		Arrays.sort(points);

		//print the content of the array
		for (int i = 0; i < points.length; i++) {
			System.out.printf("index %2d:  %s\n", i, points[i]);
		}


		Point p = new Point(-3,3);
		int index = binSearchIterative ( points, p );
		System.out.printf("point with the same distance to (0,0) as p=%s \n"
				+ "found at index %d\n\n ", p, index);


	}

	private static int binSearchIterative(Point[] points, Point p) {
		int left = 0;
		int right = points.length - 1;
		int mid;

		while ( left != right ) { //array is not empty
			mid = (left+right) / 2;
			if (0 > points[mid].compareTo(p) ) // mid element is smaller than p
				left = mid;					   //discard left half
			else if ( 0 < points[mid].compareTo(p) ) // mid element is larger than p
				right = mid;					   //discard right half
			else return mid;				   //found it, return the index
 		}

		return -1;  //did not find it, return -1
	}
}
