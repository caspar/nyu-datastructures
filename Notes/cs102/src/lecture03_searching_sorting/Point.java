package lecture03_searching_sorting;

/**
 * Point class represent points in 2D coordinates system.
 * @author Joanna Klukowska
 *
 */
public class Point implements Comparable<Point>{
	private double x;
    private double y;

    /**
     * Constructs a Point object with given coordinates.
     * @param x  x-coordinate of the point
     * @param y  y-coordinate of the point
     */
    public Point ( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    /**
     * Compare this object to the parameter object other based on their
     * distance from origin.
     * Note: this class has a natural ordering that is inconsistent with equals
     * method.
     * @param other Point object to compare the current object to
     * @return 0 if two objects are the same, -1 if this object is smaller
     *   than other object, 1 if this object is larger than the other object
     */
    @Override
    public int compareTo ( Point other ) {
        double d1 = x*x + y*y;
        double d2 = other.x * other.x + other.y * other.y;
        if ( d1 < d2 ) return -1 ;
        if ( d1 == d2 ) return 0;
        return 1;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString ( ) {
    	return String.format( "(%+6.2f, %+6.2f)",x,y); //returns formatted ( x, y )
    }
}
