package chris.businesscards.contactInfo;

/**
 * Formats a {@link ContactInfo} as a pretty string
 * @author Chris
 *
 */
public interface ContactInfoFormatter {

	/**
	 * Format the provided ContactInfo and return it as a string.  If the provided object is null or empty, 
	 * don't throw an error, simply print to a nice string
	 * @param printMe  May be null. 
	 * @return the desired format
	 */
	String format(ContactInfo printMe);

}
