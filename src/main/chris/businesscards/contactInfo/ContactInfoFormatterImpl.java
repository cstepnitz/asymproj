package chris.businesscards.contactInfo;


/**
 * A simple printer impl that prints out a {@link ContactInfo} in the following format:  
 * 
<pre>
Name: Mike Smith
Phone: 4105551234
Email: msmith@asymmetrik.com
</pre>
 * 
 * @author Chris
 *
 */
public class ContactInfoFormatterImpl implements ContactInfoFormatter{

	private static final String NULL_PRINT_STRING = "Name: \nPhone: \nEmail:\n";
	
	@Override
	public String format(ContactInfo printMe) {
		
		if(printMe == null)
			return NULL_PRINT_STRING;
		
		return new StringBuilder()
		       .append("Name: ").append(printMe.getName())
		       .append("\nPhone: ").append(printMe.getPhoneNumber())
		       .append("\nEmail: ").append(printMe.getEmailAddress()).append('\n')
		       .toString();
		
	}

}
