package chris.businesscards.util;


/**
 * Contains static utility methods for equals and hashCode
 * @author Chris
 *
 */
public class Utils {

	/**
	 * Does smart comparisons.  Handles nulls. Assumes the object
	 * has an intelligent equals method implemented
	 * @param a
	 * @param b
	 * @return true if they are equal, false otherwise
	 */
	public static boolean equal(Object a, Object b) {
		if(a == b)
			return true;
		if(a == null || b == null)
			return false;
		return a.equals(b);
	}

	/**
	 * Return a number that can be used to generate a reasonable hash code.  Not perfect.
	 * @param o may be null
	 * @return a number that can be used to generate a reasonable hash code
	 */
	public static int hashCodePrime(Object o) {
		if(o == null) return 37;
		return 37 * o.hashCode();
	}
	
}
