package chris.businesscards.contactInfo;

/**
 * Holds contact information from a business card.
 * 
 * @author Chris
 *
 */
public interface ContactInfo {

	/**
	 * @return the full name of the individual (eg. John Smith, Susan Malick)
	 */
	String getName();

	/**
	 * @return the phone number formatted as a sequence of digits (no spaces or
	 *         dashes)
	 */
	String getPhoneNumber();

	/**
	 * 
	 * @return the email address
	 */
	String getEmailAddress();
}
