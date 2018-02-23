package chris.businesscards.parser;

/**
 * Finds the name of a person.  uses a simple implementation where it looks for signs something is NOT a name and bases
 * the decision on that, mostly.
 * @author Chris
 *
 */
public class NameValidator implements Validator {

	
	
	// names don't have digits or punctuation
	private final String NOT_NAME_REGEX = ".*\\d+?.*|.*[!@#$%^&\\*()\\[\\]\\{\\}]+?.*";
	
	
	@Override
	public boolean isValid(String toCheck) {
		if(toCheck == null)
			return false;
		
		// look for indicators it's not a name, like a number or a weird symbol like @
		if(toCheck.matches(NOT_NAME_REGEX))
			return false;
		
		// lowercase and tokenize
		String[] tokens = toCheck.toLowerCase().trim().split(" ");
		
		// names are usually a first and last.  They have at least two words 
		if(tokens.length < 2)
			return false;
		
		// names don't include these terms...  they just don't. 
		for(int i = 0; i < tokens.length; i++)
			if(tokens[i] == null) continue;
			else if(tokens[i].equals("company") || tokens[i].equals("incorporated") || tokens[i].equals("technology")|| tokens[i].equals("technologies")
					|| tokens[i].equals("corporation") || tokens[i].equals("technologies") || tokens[i].equals("inc") || tokens[i].equals("ltd")
					|| tokens[i].equals("corp") || tokens[i].equals("llc") || tokens[i].equals("agency") || tokens[i].equals("trust") || tokens[i].equals("software")
					|| tokens[i].equals("engineer") || tokens[i].equals("developer") || tokens[i].equals("ceo") || tokens[i].equals("executive")
					|| tokens[i].contains("admin") || tokens[i].equals("assistant") )
				return false;
		
		
		// it's probably a name
		return true;
	}

}
