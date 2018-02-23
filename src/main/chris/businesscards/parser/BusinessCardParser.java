package chris.businesscards.parser;

import chris.businesscards.contactInfo.ContactInfo;

/**
 * Parses a single Business Card document as a string and return the ContactInfo. 
 * Figures out what the Name, Phone Number and Email address are in the document, 
 * and strips extreneous text.  
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
