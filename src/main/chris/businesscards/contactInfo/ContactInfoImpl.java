package chris.businesscards.contactInfo;

import static chris.businesscards.util.Utils.*;

/**
 * An immutable {@link ContactInfo} implementation
 * @author Chris
 *
 */
public class ContactInfoImpl implements ContactInfo{

	public static final ContactInfoImpl EMPTY = new ContactInfoImpl(null, null, null);
	private final String name;
	private final String phoneNumber;
	private final String emailAddress;
	
	/**
	 * Build a contactInfoImpl.  Null values ok. does a deep copy 
	 * @param name
	 * @param phoneNumber
	 * @param emailAddress
	 */
	public ContactInfoImpl(String name, String phoneNumber, String emailAddress) {
		// Since strings are immutable, its ok to hang on to the reference. 
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	/**
	 * Copy Constructor.  Does a deep copy
	 * 
	 */
	public ContactInfoImpl(ContactInfo copyMe) {
		// Since strings are immutable, its ok to hang on to the reference.
		if(copyMe == null) {
			this.name = null;
			this.phoneNumber = null;
			this.emailAddress = null;
		}
		else {
			this.name = copyMe.getName();
			this.phoneNumber = copyMe.getPhoneNumber();
			this.emailAddress = copyMe.getEmailAddress();
		}
	}
	
	public boolean equals(Object o) {
		if(o == null || !(o instanceof ContactInfo)) return false;
		ContactInfo that = (ContactInfo)o;
		return equal(this.name, that.getName()) && equal(this.phoneNumber, that.getPhoneNumber()) && equal(this.emailAddress, that.getEmailAddress());
	}
	
	public int hashCode() {
		return 37 + hashCodePrime(this.name) + hashCodePrime(this.phoneNumber) + hashCodePrime(this.emailAddress);
	}
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return new StringBuilder(500).append("Name: ").append(name).append(" Email: ").append(emailAddress).append(" Phone: ").append(phoneNumber).toString();
	}
	
	
}
