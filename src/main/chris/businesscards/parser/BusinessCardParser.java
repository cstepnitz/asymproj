package chris.businesscards.parser;

import chris.businesscards.contactInfo.ContactInfo;

/**
 * Parses a single Business Card document as a string and return the ContactInfo
 * @author Chris
 *
 */
public interface BusinessCardParser {

	/**
	 * Given a string document in the expected format, returns a ContactInfo
	 * @param document the string document in an expected format
	 * @return a single ContactInfo.  
	 */
    ContactInfo getContactInfo(String document);
}
