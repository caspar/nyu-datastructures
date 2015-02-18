/**
 *
 */
package lecture03_searching_sorting;

import java.util.Arrays;

/**
 * @author Joanna Klukowska
 *
 */
public class SearchingForPoints {

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

		//print the content of the array
		for (int i = 0; i < points.length; i++) {
			System.out.printf("index %2d:  %s\n", i, points[i]);
		}


		Point p = new Point(-2,2);
		int index = linSearchObj ( points, p );
		System.out.printf( "\npoint p=%s found at index %d\n\n", p, index );

		p = new Point(-2,2);
		index = linSearchDist ( points, p );
		System.out.printf("point with the same distance to (0,0) as p=%s \n"
				+ "found at index %d\n\n ", p, index);



	}

	public static int linSearchObj ( Point [] points, Point p ) {
		for (int i=1; i<points.length; i++)
		    if (points[i].equals(p))    // if we found it return this position
		       return i;
		return -1;						// otherwise, return -1
	}

	public static int linSearchDist ( Point [] points, Point p ) {
		for (int i=1; i<points.length; i++)
		    if (0 == points[i].compareTo(p))// if we found a point with same distance
		    	return i;   				//return this position
		return -1;						// otherwise, return -1
	}
}
