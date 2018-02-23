package chris.businesscards.parser;

/**
 * Matches a phone number using a couple techniques.  First, uses regex pattern.  Will match lines containing any of the following:
 * <pre>
 (###)###-####
 (###) ### - ####
 ###-###-####
 ### - ### - ####
 ##########
 ### ### ####
 ###.###.####
 </pre>
 That is not prefixed by the string Fax, FAX, f, or F.  
 * 
 * 
 * 
 * @author Chris
 *
 */
public class PhoneValidator implements Validator {

	private final String POSSIBLE_PHONE_NUM_REGEX = ".*\\d{10}|"
			+ ".*(?:\\d{3}-){2}\\d{4}|"
			+ ".*\\(\\d{3}\\)\\d{3}-?\\d{4}|"
			+ ".*(?:\\d{3}\\.){2}\\d{4}";
	private final String POSSIBLE_FAX_REGEX = "[fF]{1}[aA]?[xX]?.*";
	
	@Override
	public boolean isValid(String toCheck) {
		if(toCheck == null) return false;
		// rather than extend the regex pattern a lot to add possible whitespace everywhere, just remove all whitespace
		String toCheckClean =  toCheck.replaceAll("\\s", "");
		
		// if it has no phone number in it at all.... it can't be a match!
		if(!toCheckClean.matches(POSSIBLE_PHONE_NUM_REGEX))
			
			return false; 
		
		// check if the phone number is prefixed by FAX or something that means fax.  
		if(toCheckClean.matches(POSSIBLE_FAX_REGEX))
			return false;
		
		// it has a phone number and does not say FAX anywhere!  winner!
		return true;
	}

}
