package chris.businesscards.parser;


/**
 * Functor used to check if something is a valid X, where X is specified by the implementation.  Validity of
 * s
 * 
 * For example, an EmailValidator would verify if the string was a valid email. 
 * @author Chris
 *
 */
public interface Validator {

	/**
	 * returns true if the string is a valid X.  
	 * @param toCheck may be null. 
	 * @return true if it's a valid x.  
	 */
	boolean isValid(String toCheck);
	
	
}
