package chris.businesscards.parser;

/**
 * Checks if something is a valid email.  Uses regex to match (anyNonWhitespaceChars)@(anyNonWhitespaceChars).(anyNonWhitespaceChars)
 * since it's not likely something that is not an email will match this.  Some businesses use @ symbols in their 
 * business name, but normally they will have some whitespace in there which won't match.  Also, the . is key in identifying a valid web address.  
 * 
 * 
 * @author Chris
 *
 */
public class EmailValidator implements Validator{


	private final String EMAIL_REGEX = ".*\\S+@\\S+\\.\\S+";
	
	@Override
	public boolean isValid(String toCheck) {
		if(toCheck == null) return false;
		String toCheckClean = toCheck.trim();
		return toCheckClean.matches(EMAIL_REGEX);
	}

}
