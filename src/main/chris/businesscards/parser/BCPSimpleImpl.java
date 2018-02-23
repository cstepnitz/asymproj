package chris.businesscards.parser;

import chris.businesscards.contactInfo.ContactInfo;
import chris.businesscards.contactInfo.ContactInfoImpl;


/**
 * A simple implementation that just returns the first likely hits for each of name, phone number, and email address.
 * Cleans up the format of the lines, removes whitespace and extraneous text, ect.  
 * 
 * Uses some simple commonsense rules to determine likely hit.  
 * 
 * @author Chris
 *
 */
public class BCPSimpleImpl implements BusinessCardParser{

		
	private final Validator emailFinder = new EmailValidator();
	private final Validator phoneFinder = new PhoneValidator();
	private final Validator nameFinder = new NameValidator();
	
	@Override
	public ContactInfo getContactInfo(String document) {
		// parse into lines
		if(document == null)
			return ContactInfoImpl.EMPTY;
		String[] lines = document.split("\n");
		
		String rawPhone =  findFirstMatch(lines, phoneFinder);
		String rawEmail =  findFirstMatch(lines, emailFinder);
		String rawName = findFirstMatch(lines, nameFinder);
		
		return new ContactInfoImpl(formatName(rawName), formatPhoneNumber(rawPhone), formatEmail(rawEmail));
	}
	
	
	/**
	 * Take the phone number and format it correctly as a string of numbers, no whitespace or punctuation
	 * @param s the phone number string  May be null. 
	 * @return the formatted phone number string.  May be null. 
	 */
	protected String formatPhoneNumber(String s) {
		if(s == null)
			return null;
		return s.replaceAll("\\D", "");
	}
	
	/**
	 * Take the email address line and format it correctly without any prefix text. 
	 * Works by tokenizing the string and looking for the token with @
	 * If it can't find a token with @, returns the entire string, trimmed.  
	 * Null results in a response of null. 
	 * @param s may be null
	 * @return just an email address, extracted from everything else in the line
	 */
	protected String formatEmail(String s) {
		if(s == null) return null;
		String[] emailTokens = s.split(" ");
		
		// look for a token with @
		for(int i = 0; i < emailTokens.length; i++)
			if(emailTokens[i] != null && emailTokens[i].contains("@"))
				return emailTokens[i].trim();
		
		// just return the entire string, trimmed, coun't find @
		return s.trim(); 
		
	}
	
	/**
	 * Take the name line and format it correctly without any prefix text
	 * @param s
	 * @return just a name, extracted from everything else in the line
	 */
	protected String formatName(String s) {
		if(s == null) return null;
		if(s.toLowerCase().startsWith("name: "))
			s = s.substring(5, s.length());
		else if(s.toLowerCase().startsWith("name "))
			s = s.substring(4, s.length());
		return s.trim();
	}
	
	
	/**
	 * Finds lines that match based on the implementation of validator
	 * @param contactInfoLines
	 * @param validator
	 * @return the first match found, or null if none are found 
	 */
	protected String findFirstMatch(String[] contactInfoLines, Validator validator) {
		if(contactInfoLines == null) return null;
		
		for(String aLine: contactInfoLines) 
			if(validator.isValid(aLine))
				return aLine;					
		return null;
	}
	

}
