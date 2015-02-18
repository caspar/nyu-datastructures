
package lecture03_searching_sorting;

/**
 * This program demonstrates different ways of comaring and sorting
 * Point objects.
 * @author Joanna Klukowska
 */
public class ComparingPoints {

	/**
	 * @param args ignored
	 */
	public static void main(String[] args) {

		//create some points
		Point p1 = new Point (0, 0);
		Point p2 = new Point (1, 1);
		Point p3 = new Point (1, 1);
		Point p4 = new Point (-1, 1);
		Point p5 = new Point ( 2, -1);

		//the results of using == operator and .equals() method
		//are not the same when we are working with objects
		//(== operator does not look at the content of the object,
		//just at its memory location)
		System.out.println("Comparing for equality, are the Point objects identical?");
		System.out.println("p2 = " + p2 + ",  p3 = " + p3);

		System.out.printf("p2 == p3  is %b\n", p2==p3);

		System.out.printf("p2.equals(p3)  is %b\n", p2.equals(p3));

		/**********************************************************************/

		//the natural ordering of objects is defined by the compareTo() method

		System.out.println("\nComparing using .compareTo() method based on \n"
				+ "Point objects' distance from the origin:   ");
		System.out.println("p1 = " + p1 + ",  p2 = " + p2);

		if ( 0 > p1.compareTo(p2) )
			System.out.println("0 > p1.compareTo(p2) is true , means p1 is \n"
					+ " \"smaller\"  than p2 (based on their distance to (0,0) )" );
		else if ( 0 < p1.compareTo(p2)  )
			System.out.println(" 0 < p1.compareTo(p2) is true, means p1 is \n"
					+ " \"larger\"  than p2 (based on their distance to (0,0) )" );
		else
			System.out.println(" 0 == p1.compareTo(p2) is true, means p1 is \n"
					+ " \"equal\"  to p2 (based on their distance to (0,0) )" );

		/**********************************************************************/

		System.out.println("\nComparing using .compareTo() method based on \n"
				+ "Point objects' distance from the origin:   ");
		System.out.println("p2 = " + p2 + ",  p4 = " + p4);

		if ( 0 > p2.compareTo(p4) )
			System.out.println("0 > p2.compareTo(p4) is true , means p2 is \n"
					+ " \"smaller\"  than p4 (based on their distance to (0,0) )" );
		else if ( 0 < p2.compareTo(p4)  )
			System.out.println(" 0 < p2.compareTo(p4) is true, means p2 is \n"
					+ " \"larger\"  than p4 (based on their distance to (0,0) )" );
		else
			System.out.println(" 0 == p2.compareTo(p4) is true, means p2 is \n"
					+ " \"equal\"  to p4 (based on their distance to (0,0) )" );
		System.out.printf("The result of p2.equals(p4) is: %b\n\n", p2.equals(p4) );

		/**********************************************************************/


	}

}
